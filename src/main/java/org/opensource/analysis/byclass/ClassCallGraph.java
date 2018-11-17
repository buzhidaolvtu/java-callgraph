package org.opensource.analysis.byclass;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ClassCallGraph {

    public static void main(String[] args) throws IOException {
        String sFile = "/Users/lvtu/workspace/java-callgraph/target/classes/org/opensource/analysis/bysource/SourceCallGraph.class";
        File file = new File(sFile);
        FileInputStream inputStream = new FileInputStream(file);
        ClassReader cr = new ClassReader(inputStream);

        ClassVisitor cw = new ClassCallVisitor();
        cr.accept(cw, ClassReader.EXPAND_FRAMES);
    }
}
