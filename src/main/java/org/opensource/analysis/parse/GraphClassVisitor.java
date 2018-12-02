package org.opensource.analysis.parse;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.opensource.analysis.parse.structure.ClassInfo;
import org.opensource.analysis.parse.structure.MethodInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GraphClassVisitor extends org.objectweb.asm.ClassVisitor {

    private final static Logger logger = LoggerFactory.getLogger(GraphClassVisitor.class);

    private ClassInfo classInfo;

    private GraphClassResolver classResolver;

    public GraphClassVisitor() {
        super(Opcodes.ASM7);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        classInfo = new ClassInfo(access, name, signature, superName, interfaces);
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodInfo methodInfo = new MethodInfo(access, name, descriptor, signature, exceptions);
        classInfo.addMethod(methodInfo);
        return new GraphMethodVisitor(methodInfo);
    }


}
