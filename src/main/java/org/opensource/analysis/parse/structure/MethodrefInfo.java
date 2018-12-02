package org.opensource.analysis.parse.structure;

public class MethodrefInfo {

    private String owner;
    private String name;
    private String descriptor;
    private boolean isInterface;

    public MethodrefInfo(String owner, String name, String descriptor, boolean isInterface) {
        this.owner = owner;
        this.name = name;
        this.descriptor = descriptor;
        this.isInterface = isInterface;
    }
}
