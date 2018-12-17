package org.opensource.analysis.parse.graph;

import java.util.List;

public abstract class AbstractMethodNode implements MethodNode{

    @Override
    public List<MethodNode> findRefNodes() {
        return null;
    }

    @Override
    public List<UnidirectionalMethodEdge> getOutputRefs() {
        return null;
    }

    @Override
    public List<MethodNode> possibleMethodNodes() {
        return null;
    }

    @Override
    public boolean existsMultiImpl() {
        return false;
    }
}
