package org.opensource.analysis.parse;

public interface ICallGraph {

    void callGraph(String className, String method);

    void search(String className, String method);

}
