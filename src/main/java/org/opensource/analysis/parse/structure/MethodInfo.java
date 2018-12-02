package org.opensource.analysis.parse.structure;

import java.util.ArrayList;
import java.util.List;

public class MethodInfo {

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
}
