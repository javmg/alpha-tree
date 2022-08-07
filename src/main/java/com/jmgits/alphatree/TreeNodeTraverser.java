package com.jmgits.alphatree;

import java.util.LinkedList;
import java.util.List;

public class TreeNodeTraverser {

    public static List<TreeNode> traverseRecursiveAndReturnNodes(TreeNode root) {

        var nodes = new LinkedList<TreeNode>();

        if (root == null) {
            return nodes;
        }

        traverseRecursiveAndReturnNodes(root, nodes);

        return nodes;
    }

    public static List<TreeNode> traverseStackAndReturnNodes(TreeNode root) {

        var nodes = new LinkedList<TreeNode>();

        if (root == null) {
            return nodes;
        }

        TreeNode current = root;
        TreeNode predecessor;

        while (current != null) {

            if (current.getLeft() == null) {
                nodes.add(current);
                current = current.getRight();
            } else {

                predecessor = current.getLeft();
                while (predecessor.getRight() != null && predecessor.getRight() != current) {
                    predecessor = predecessor.getRight();
                }

                if (predecessor.getRight() == null) {
                    predecessor.setRight(current);
                    current = current.getLeft();
                } else {
                    predecessor.setRight(null);
                    nodes.add(current);
                    current = current.getRight();
                }
            }
        }

        return nodes;
    }

    //
    // private

    private static void traverseRecursiveAndReturnNodes(TreeNode node, LinkedList<TreeNode> nodes) {

        if (node == null) {
            return;
        }

        if (node.getLeft() == null) {
            nodes.add(node);
        } else {
            traverseRecursiveAndReturnNodes(node.getLeft(), nodes);
            nodes.add(node);
        }

        traverseRecursiveAndReturnNodes(node.getRight(), nodes);
    }
}
