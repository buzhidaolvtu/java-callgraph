package org.opensource.analysis.byclass;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ClassCallVisitor extends ClassVisitor {

    public ClassCallVisitor() {
        super(Opcodes.ASM7);
    }

    public ClassCallVisitor(int api) {
        super(api);
    }

    public ClassCallVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        return new MethodCallVisitor();
    }


}
