package org.opensource.analysis.byclass;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.List;

public class ClassCallGraph {

    public static void main(String[] args) throws IOException {
        URL url = Paths.get("/Users/lvtu/workspace/java-callgraph/target/classes").toUri().toURL();
        ClassLoader cl = new URLClassLoader(new URL[]{url});
        InputStream ins = cl.getResourceAsStream("org/opensource/analysis/bysource/SourceCallGraph.class");

        ClassReader cr = new ClassReader(ins);

        ClassVisitor cw = new ClassCallVisitor();
        cr.accept(cw, ClassReader.EXPAND_FRAMES);
    }

}
