package org.opensource.analysis.parse.graph;

import com.google.common.collect.Lists;

import java.util.List;

public class VirtualMethodNode extends AbstractMethodNode {

    @Override
    public List<MethodNode> findRefNodes() {
        return Lists.newArrayList();
    }


}
