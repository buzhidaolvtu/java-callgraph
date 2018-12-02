package org.opensource.analysis.parse;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.opensource.analysis.parse.structure.MethodInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GraphMethodVisitor extends MethodVisitor {

    private final static Logger logger = LoggerFactory.getLogger(GraphMethodVisitor.class);

    public GraphMethodVisitor() {
        super(Opcodes.ASM7);
    }

    private MethodInfo methodInfo;

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        if (name.equals("<init>") || owner.startsWith("java")) {
            super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
            return;
        }
        logger.info("-> {}.{}", owner, name);
    }

    @Override
    public void visitCode() {
        super.visitCode();
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        super.visitMaxs(maxStack, maxLocals);
    }
}
