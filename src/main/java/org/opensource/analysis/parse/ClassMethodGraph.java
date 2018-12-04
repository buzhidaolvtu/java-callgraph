package org.opensource.analysis.parse;

import org.apache.commons.lang3.StringUtils;
import org.opensource.analysis.parse.structure.ClassInfo;

public class ClassMethodGraph implements ICallGraph {

    private GraphClassResolver graphClassResolver;

    public ClassMethodGraph(GraphClassResolver graphClassResolver) {
        this.graphClassResolver = graphClassResolver;
    }

    @Override
    public void callGraph(String className, String method) {
        ClassInfo classInfo = graphClassResolver.getResolvedTable().getResolvedClassesMap().get(StringUtils.replace(className, ".", "/"));

    }

    @Override
    public void search(String className, String method) {

    }
}
