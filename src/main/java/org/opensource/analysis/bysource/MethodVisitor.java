package org.opensource.analysis.bysource;

import org.antlr4.java.JavaBaseVisitor;
import org.antlr4.java.JavaParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodVisitor extends JavaBaseVisitor {

    private final static Logger logger = LoggerFactory.getLogger(MethodVisitor.class);

    @Override
    public Object visitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        logger.info("visitMethodDeclaration:{}", ctx.getText());
        return super.visitMethodDeclaration(ctx);
    }

    @Override
    public Object visitMethodModifier(JavaParser.MethodModifierContext ctx) {
        return super.visitMethodModifier(ctx);
    }

    @Override
    public Object visitMethodHeader(JavaParser.MethodHeaderContext ctx) {
        logger.info("visitMethodHeader:{}", ctx.getText());
        return super.visitMethodHeader(ctx);
    }

    @Override
    public Object visitMethodName(JavaParser.MethodNameContext ctx) {
        return super.visitMethodName(ctx);
    }

    @Override
    public Object visitMethodDeclarator(JavaParser.MethodDeclaratorContext ctx) {
        return super.visitMethodDeclarator(ctx);
    }

    @Override
    public Object visitMethodBody(JavaParser.MethodBodyContext ctx) {
        logger.info("visitMethodBody:{}", ctx.getText());
        return super.visitMethodBody(ctx);
    }

    @Override
    public Object visitMethodInvocation(JavaParser.MethodInvocationContext ctx) {
        logger.info("visitMethodInvocation:{}", ctx.getText());
        return super.visitMethodInvocation(ctx);
    }

    @Override
    public Object visitInterfaceMethodDeclaration(JavaParser.InterfaceMethodDeclarationContext ctx) {
        return super.visitInterfaceMethodDeclaration(ctx);
    }

    @Override
    public Object visitInterfaceMethodModifier(JavaParser.InterfaceMethodModifierContext ctx) {
        return super.visitInterfaceMethodModifier(ctx);
    }

    @Override
    public Object visitMethodReference(JavaParser.MethodReferenceContext ctx) {
        logger.info("visitMethodReference:{}", ctx.getText());
        return super.visitMethodReference(ctx);
    }

    @Override
    public Object visitMethodReference_lf_primary(JavaParser.MethodReference_lf_primaryContext ctx) {
        return super.visitMethodReference_lf_primary(ctx);
    }

    @Override
    public Object visitMethodReference_lfno_primary(JavaParser.MethodReference_lfno_primaryContext ctx) {
        return super.visitMethodReference_lfno_primary(ctx);
    }

    @Override
    public Object visitMethodInvocation_lf_primary(JavaParser.MethodInvocation_lf_primaryContext ctx) {
        return super.visitMethodInvocation_lf_primary(ctx);
    }

    @Override
    public Object visitMethodInvocation_lfno_primary(JavaParser.MethodInvocation_lfno_primaryContext ctx) {
        return super.visitMethodInvocation_lfno_primary(ctx);
    }


}
