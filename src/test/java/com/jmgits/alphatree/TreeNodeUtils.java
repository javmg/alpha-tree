package com.jmgits.alphatree;

public class TreeNodeUtils {

    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static TreeNode createAlphabetTree() {

        var alphabet = ALPHABET.toCharArray();

        return TreeNodeFactory.createNode(alphabet);
    }
}
