package com.jmgits.alphatree;

public class TreeNodeSearcher {

    public static TreeNode search(char value, TreeNode root) {

        if (root == null) {
            return null;
        }

        int nextDirection = value - root.getValue();

        if (nextDirection == 0) {
            return root;
        }

        var nextNode = nextDirection < 0 ?
                root.getLeft() :
                root.getRight();

        return search(value, nextNode);
    }
}
