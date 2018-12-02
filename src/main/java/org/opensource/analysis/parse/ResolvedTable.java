package org.opensource.analysis.parse;

import java.util.HashSet;
import java.util.Set;

public class ResolvedTable {

    private Set<String> resolvedClassedSet = new HashSet<>();

    private Set<String> resolvedMethodSet = new HashSet<>();

    public void addClass(String className) {
        resolvedClassedSet.add(className);
    }

    public boolean containsClass(String className) {
        return resolvedClassedSet.contains(className);
    }

    public void addMethod(){

    }

    public boolean containsMethod(){
        return false;
    }

}
