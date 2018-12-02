package org.opensource.analysis.parse.structure;

import java.util.ArrayList;
import java.util.List;

public class MethodInfo {

    private int access;
    private String owner;
    private String name;
    private String descriptor;
    private String signature;
    private String[] exceptions;


    private List<MethodrefInfo> methodrefInfos = new ArrayList<>();
}
