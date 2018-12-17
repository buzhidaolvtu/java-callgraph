package org.opensource.analysis.parse.graph;

import java.util.List;

/**
 * 多态节点,因为面向对象：封装，继承，多态的特性，可以理解为所有的节点都是多态节点
 */
public class PolymorphismNode extends AbstractMethodNode {

    private List<MethodNode> possibleNodes;

    @Override
    public List<MethodNode> findRefNodes() {
        return super.findRefNodes();
    }

    @Override
    public List<UnidirectionalMethodEdge> getOutputRefs() {
        return super.getOutputRefs();
    }

    @Override
    public List<MethodNode> possibleMethodNodes() {
        return possibleNodes;
    }

    @Override
    public boolean existsMultiImpl() {
        return true;
    }
}
