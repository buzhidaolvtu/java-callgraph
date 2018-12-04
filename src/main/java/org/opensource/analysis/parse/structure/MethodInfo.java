package org.opensource.analysis.parse.structure;

import java.util.ArrayList;
import java.util.List;

public class MethodInfo {

    private ClassInfo ownerClassInfo;
    private int access;
    private String name;
    private String descriptor;
    private String signature;
    private String[] exceptions;

    public MethodInfo(int access, String name, String descriptor, String signature, String[] exceptions) {
        this.access = access;
        this.name = name;
        this.descriptor = descriptor;
        this.signature = signature;
        this.exceptions = exceptions;
    }

    private List<MethodrefInfo> methodrefInfos = new ArrayList<>();

    public void addMethodRef(MethodrefInfo methodref) {
        methodrefInfos.add(methodref);
    }

    public ClassInfo getOwnerClassInfo() {
        return ownerClassInfo;
    }

    public void setOwnerClassInfo(ClassInfo ownerClassInfo) {
        this.ownerClassInfo = ownerClassInfo;
    }

    public int getAccess() {
        return access;
    }

    public String getName() {
        return name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public String getSignature() {
        return signature;
    }

    public String[] getExceptions() {
        return exceptions;
    }

    public List<MethodrefInfo> getMethodrefInfos() {
        return methodrefInfos;
    }
}
