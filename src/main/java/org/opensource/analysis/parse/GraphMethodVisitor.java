package org.opensource.analysis.parse;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.opensource.analysis.parse.structure.MethodInfo;
import org.opensource.analysis.parse.structure.MethodrefInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GraphMethodVisitor extends MethodVisitor {

    private final static Logger logger = LoggerFactory.getLogger(GraphMethodVisitor.class);

    private MethodInfo methodInfo;

    public GraphMethodVisitor(MethodInfo methodInfo) {
        super(Opcodes.ASM7);
        this.methodInfo = methodInfo;
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        methodInfo.addMethodRef(new MethodrefInfo(opcode,owner, name, descriptor, isInterface));
    }
}
