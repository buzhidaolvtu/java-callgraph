package org.opensource.analysis.parse.structure;

import org.objectweb.asm.Opcodes;

public class MethodrefInfo {

    private int opcode;
    private String owner;
    private String name;
    private String descriptor;
    private boolean isInterface;
    private boolean resolvedResult;

    public MethodrefInfo(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        this.opcode = opcode;
        this.owner = owner;
        this.name = name;
        this.descriptor = descriptor;
        this.isInterface = isInterface;
    }

    public boolean isInvokeVirtual() {
        return opcode == Opcodes.INVOKEVIRTUAL;
    }

    public boolean isInvokeInterface() {
        return opcode == Opcodes.INVOKEINTERFACE;
    }

    public boolean isInvokeSpecial() {
        return opcode == Opcodes.INVOKESPECIAL;
    }

    public boolean isInvokeStatic() {
        return opcode == Opcodes.INVOKESTATIC;
    }

    public boolean isInvokeDynamic() {
        return opcode == Opcodes.INVOKEDYNAMIC;
    }

    public int getOpcode() {
        return opcode;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public boolean isResolvedResult() {
        return resolvedResult;
    }

    public void setResolvedResult(boolean resolvedResult) {
        this.resolvedResult = resolvedResult;
    }
}
