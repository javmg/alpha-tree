package com.jmgits.alphatree;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.jmgits.alphatree.TreeNodeUtils.ALPHABET;
import static org.junit.Assert.assertEquals;

/**
 * Unit testing for {@link TreeNodeTraverser}
 **/
public class TreeNodeTraverserTest {

    private final TreeNode root = TreeNodeUtils.createAlphabetTree();

    @Test
    public void testGivenAlphabetTreeWhenTraversingRecursiveThenReturnsNodesInOrder() {

        var nodes = TreeNodeTraverser.traverseRecursiveAndReturnNodes(root);

        validateNodesInOrder(nodes);
    }

    @Test
    public void testGivenAlphabetTreeWhenTraversingStackThenReturnsNodesInOrder() {

        var nodes = TreeNodeTraverser.traverseStackAndReturnNodes(root);

        validateNodesInOrder(nodes);
    }

    //
    // private

    private static void validateNodesInOrder(List<TreeNode> nodes) {

        var nodeValues = nodes.stream()
                .map(value -> value.getValue() + "")
                .collect(Collectors.joining());

        assertEquals(ALPHABET, nodeValues);
    }
}
