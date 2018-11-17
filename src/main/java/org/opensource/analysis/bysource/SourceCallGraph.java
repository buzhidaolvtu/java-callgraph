package org.opensource.analysis.bysource;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr4.java.JavaLexer;
import org.antlr4.java.JavaParser;

import java.io.IOException;
import java.nio.charset.Charset;

public class SourceCallGraph {

    public static void main(String[] args) throws IOException {
        String sFile = "/Users/lvtu/workspace/java-callgraph/src/main/java/org/opensource/analysis/CallGraph.java";
        CharStream cs = CharStreams.fromFileName(sFile, Charset.forName("utf-8"));
        JavaLexer lexer = new JavaLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
        JavaParser.CompilationUnitContext tree = parser.compilationUnit(); // parse a compilationUnit
        int hashCode = cs.hashCode();
        System.out.println(hashCode);
        MethodVisitor methodVisitor = new MethodVisitor();
        tree.accept(methodVisitor);
    }
}
