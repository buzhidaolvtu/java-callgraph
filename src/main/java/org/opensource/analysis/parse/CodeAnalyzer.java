package org.opensource.analysis.parse;

import java.io.IOException;

public class CodeAnalyzer {

    public static void main(String[] args) throws IOException {
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer();
        ICallGraph callGraph = codeAnalyzer.analyze();
        callGraph.callGraph("org.opensource.analysis.parse.CodeAnalyzer", "analyze");
    }

    public ICallGraph analyze() {
        String cp = "/Users/lvtu/workspace/java-callgraph/target/classes/," +
                "/Users/lvtu/workspace/sandbox-boot-agent/sandbox-boot-loader/target/classes," +
                "/Users/lvtu/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar";

        cp = "/Users/lvtu/workspace/java-callgraph/target/classes/";
        GraphClassResolver graphClassResolver = new GraphClassResolver(cp);
        graphClassResolver.resolveAllClasses();
        return new ClassMethodGraph(graphClassResolver);
    }


}
