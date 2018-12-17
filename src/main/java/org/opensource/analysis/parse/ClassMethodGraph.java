package org.opensource.analysis.parse;

import org.apache.commons.lang3.StringUtils;
import org.opensource.analysis.parse.structure.ClassInfo;
import org.opensource.analysis.parse.structure.MethodInfo;
import org.opensource.analysis.parse.structure.MethodrefInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ClassMethodGraph implements ICallGraph {

    private final static Logger logger = LoggerFactory.getLogger(ClassMethodGraph.class);

    private GraphClassResolver graphClassResolver;

    public ClassMethodGraph(GraphClassResolver graphClassResolver) {
        this.graphClassResolver = graphClassResolver;
    }

    public static final ThreadLocal<List> stack = ThreadLocal.withInitial(ArrayList::new);

    @Override
    public void callGraph(String className, String method) {
        Map<String, ClassInfo> resolvedClassesMap = graphClassResolver.getResolvedTable().getResolvedClassesMap();
        ClassInfo classInfo = resolvedClassesMap.get(StringUtils.replace(className, ".", "/"));

        if (Objects.isNull(classInfo)) {
            //可能没有解析成功，再解析一遍
            if (!graphClassResolver.resolveClass(className)) {
                //仍然没有解析成功
                return;
            }
        }

        classInfo = resolvedClassesMap.get(StringUtils.replace(className, ".", "/"));

        //调用栈并且递归解析
        Optional<MethodInfo> methodInfoOptional = classInfo.getMethods()
                .stream()
                .filter(methodInfo -> methodInfo.getName().equals(method))
                .findFirst();
        List<MethodrefInfo> methodrefInfos = methodInfoOptional.get().getMethodrefInfos();
        for (int i = 0; i < methodrefInfos.size(); i++) {
            MethodrefInfo methodrefInfo = methodrefInfos.get(i);
            logger.info("called class:{},method:{}", methodrefInfo.getOwner(), methodrefInfo.getName());
            callGraph(methodrefInfo.getOwner(), methodrefInfo.getName());
        }
    }

    @Override
    public void search(String className, String method) {

    }
}
