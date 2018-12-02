package org.opensource.analysis.parse.structure;

import java.util.ArrayList;
import java.util.List;

public class ClassInfo {

    private int access;
    private String name;
    private String signature;
    private String superName;
    private String[] interfaces;

    private List<MethodInfo> methods = new ArrayList();

    public ClassInfo(int access, String name, String signature, String superName, String[] interfaces) {
        this.access = access;
        this.name = name;
        this.signature = signature;
        this.superName = superName;
        this.interfaces = interfaces;
    }

    public void addMethod(MethodInfo method) {
        methods.add(method);
    }

}
