package org.opensource.analysis.parse;

import java.io.IOException;

public class CodeAnalyzer {

    public static void main(String[] args) throws IOException {
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer();
        ICallGraph analyze = codeAnalyzer.analyze();
        analyze.callGraph("", "");
        analyze.search("", "");
    }

    public ICallGraph analyze() {
        String cp = "/Users/lvtu/workspace/java-callgraph/target/classes/,/Users/lvtu/workspace/sandbox-boot-agent/sandbox-boot-loader/target/classes,/Users/lvtu/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar";
        GraphClassResolver graphClassResolver = new GraphClassResolver(cp);
        graphClassResolver.resolveAllClasses();
        return new ClassMethodGraph(graphClassResolver);
    }


}
