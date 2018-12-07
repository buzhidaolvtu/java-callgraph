package org.opensource.analysis.parse;

import org.apache.commons.lang3.StringUtils;
import org.opensource.analysis.parse.structure.ClassInfo;
import org.opensource.analysis.parse.structure.MethodInfo;
import org.opensource.analysis.parse.structure.MethodrefInfo;

import java.util.List;
import java.util.Optional;

public class ClassMethodGraph implements ICallGraph {

    private GraphClassResolver graphClassResolver;

    public ClassMethodGraph(GraphClassResolver graphClassResolver) {
        this.graphClassResolver = graphClassResolver;
    }

    @Override
    public void callGraph(String className, String method) {
        ClassInfo classInfo = graphClassResolver.getResolvedTable()
                .getResolvedClassesMap()
                .get(StringUtils.replace(className, ".", "/"));

        //调用栈并且递归解析
        Optional<MethodInfo> methodInfoOptional = classInfo.getMethods().stream().filter(methodInfo -> methodInfo.getName().equals(method)).findFirst();
        List<MethodrefInfo> methodrefInfos = methodInfoOptional.get().getMethodrefInfos();
        methodrefInfos.forEach(methodrefInfo -> {
            graphClassResolver.getMethodResolver().resolveMethodref(methodrefInfo);
        });

    }

    @Override
    public void search(String className, String method) {

    }
}
