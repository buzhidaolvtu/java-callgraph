package org.opensource.analysis.parse;

import org.objectweb.asm.ClassReader;

public class GraphClassResolver {

    private ClassLoader classLoader;

    private ClassReader classReader;

    private ResolvedTable resolvedTable;

    public void resolveClass(String className){
        if(resolvedTable.containsClass(className)){
            return;
        }

    }
}
