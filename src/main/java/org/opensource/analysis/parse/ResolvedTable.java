package org.opensource.analysis.parse;

import org.opensource.analysis.parse.structure.ClassInfo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ResolvedTable {

    private Set<String> resolvedClassesSet = new HashSet<>();

    private Set<String> resolvedMethodSet = new HashSet<>();

    private Map<String, ClassInfo> resolvedClassesMap = new HashMap<>();

    public void addClass(ClassInfo classInfo) {
        resolvedClassesMap.put(classInfo.getName(), classInfo);
    }



    public boolean containsClass(String className) {
        return resolvedClassesSet.contains(className);
    }

    public void addMethod() {

    }

    public boolean containsMethod() {
        return false;
    }

    public Set<String> getResolvedClassesSet() {
        return resolvedClassesSet;
    }

    public void setResolvedClassesSet(Set<String> resolvedClassesSet) {
        this.resolvedClassesSet = resolvedClassesSet;
    }

    public Set<String> getResolvedMethodSet() {
        return resolvedMethodSet;
    }

    public void setResolvedMethodSet(Set<String> resolvedMethodSet) {
        this.resolvedMethodSet = resolvedMethodSet;
    }

    public Map<String, ClassInfo> getResolvedClassesMap() {
        return resolvedClassesMap;
    }

    public void setResolvedClassesMap(Map<String, ClassInfo> resolvedClassesMap) {
        this.resolvedClassesMap = resolvedClassesMap;
    }
}
