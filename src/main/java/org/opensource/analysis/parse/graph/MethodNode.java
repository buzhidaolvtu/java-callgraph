package org.opensource.analysis.parse.graph;

import java.util.List;

public interface MethodNode {

    /**
     * 根据method ref发现真实的方法节点，如果不能发现，那么就创造一个虚拟节点
     *
     * @return
     */
    List<MethodNode> findRefNodes();

    List<UnidirectionalMethodEdge> getOutputRefs();

    List<MethodNode> possibleMethodNodes();

    boolean existsMultiImpl();
}
