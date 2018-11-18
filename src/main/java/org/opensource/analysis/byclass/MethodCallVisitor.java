package org.opensource.analysis.byclass;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodCallVisitor extends MethodVisitor {

    private final static Logger logger = LoggerFactory.getLogger(MethodCallVisitor.class);

    public MethodCallVisitor() {
        super(Opcodes.ASM7);
    }

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
