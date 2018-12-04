package org.opensource.analysis.parse;

import org.opensource.analysis.parse.structure.MethodrefInfo;

public class GraphMethodResolver {

    private GraphClassResolver classResolver;

    public GraphMethodResolver(GraphClassResolver classResolver) {
        this.classResolver = classResolver;
    }

    public void resolveMethodref(MethodrefInfo methodrefInfo) {
        classResolver.resolveClass(methodrefInfo.getOwner());


    }


}
