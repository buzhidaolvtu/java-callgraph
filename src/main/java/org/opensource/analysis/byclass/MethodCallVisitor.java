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

    public MethodCallVisitor(int api) {
        super(api);
    }

    public MethodCallVisitor(int api, MethodVisitor methodVisitor) {
        super(api, methodVisitor);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        if (name.equals("<init>") || owner.startsWith("java")) {
            super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
            return;
        }
        logger.info("-> {}.{}", owner, name);
    }
}
