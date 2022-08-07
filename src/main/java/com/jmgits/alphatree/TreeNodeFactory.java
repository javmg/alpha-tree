package com.jmgits.alphatree;

public class TreeNodeFactory {

    public static TreeNode createNode(char[] array) {

        if (array == null) {
            return null;
        }

        return createNode(array, 0, array.length - 1);
    }

    //
    // private

    private static TreeNode createNode(char[] array, int start, int end) {

        if (start > end) {
            return null;
        }

        var middle = start + (end - start) / 2;

        // the element in the middle will become root
        var root = new TreeNode(array[middle]);

        root.setLeft(createNode(array, start, middle - 1));
        root.setRight(createNode(array, middle + 1, end));

        return root;
    }
}
