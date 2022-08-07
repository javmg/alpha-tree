package com.jmgits.alphatree;

import java.io.PrintStream;

public class TreeNodeVisualizer {

    public static void visualizeInConsole(TreeNode root) {

        visualizeRoot(root, null, "", System.out);
    }

    public static void visualize(TreeNode root, PrintStream printStream) {

        visualizeRoot(root, null, "", printStream);
    }

    public static void visualizeRoot(TreeNode node, TreeNode parent, String indent, PrintStream printStream) {

        if (node == null) {
            return;
        }

        var currentIndent = indent + " ";

        if (parent == null) {
            visualizeLeaf(node, currentIndent, " ", "+", " ", printStream);
            return;
        }

        if (parent.getRight() == node) {
            visualizeLeaf(node, currentIndent, " ", "|+", "|", printStream);
            return;
        }

        visualizeLeaf(node, currentIndent, "|", "|+", " ", printStream);
    }

    private static void visualizeLeaf(TreeNode node, String indent, String indentSuffix1, String indentSuffix2, String indentSuffix3, PrintStream printStream) {
        visualizeRoot(node.getLeft(), node, indent + indentSuffix3, printStream);
        printStream.print(indent + indentSuffix2 + node.getValue() + "\n");
        visualizeRoot(node.getRight(), node, indent + indentSuffix1, printStream);
    }
}
