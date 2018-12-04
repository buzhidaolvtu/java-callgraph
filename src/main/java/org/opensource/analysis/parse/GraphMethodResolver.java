package org.opensource.analysis.parse;

import org.opensource.analysis.parse.structure.MethodrefInfo;

public class GraphMethodResolver {

    private GraphClassResolver classResolver;

    public GraphMethodResolver(GraphClassResolver classResolver) {
        this.classResolver = classResolver;
    }

    public void resolveMethodref(MethodrefInfo methodrefInfo) {
        boolean resolvedResult = classResolver.resolveClass(methodrefInfo.getOwner());
        methodrefInfo.setResolvedResult(resolvedResult);
        if (methodrefInfo.isInvokeInterface()) {
            //寻找实现
        } else if (methodrefInfo.isInvokeSpecial()) {
            //寻找所有实现类及子类
        } else if (methodrefInfo.isInvokeVirtual()) {
            //寻找所有实现类及子类
        } else if (methodrefInfo.isInvokeStatic()) {
            //寻找所有实现类及子类
        } else if (methodrefInfo.isInvokeDynamic()) {

        }

    }


}
