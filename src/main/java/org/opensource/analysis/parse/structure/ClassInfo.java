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

}
