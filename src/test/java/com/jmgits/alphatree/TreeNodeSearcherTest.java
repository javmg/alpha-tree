package com.jmgits.alphatree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Unit testing for {@link TreeNodeSearcher}
 **/
public class TreeNodeSearcherTest {

    private final TreeNode root = TreeNodeUtils.createAlphabetTree();

    @Test
    public void testGivenAlphabetTreeWhenSearchUnknownValueThenReturnsNull() {

        var node = TreeNodeSearcher.search('1', root);

        assertNull(node);
    }

    @Test
    public void testGivenAlphabetTreeWhenSearchKnownValueThenReturnsIt1() {

        var node = TreeNodeSearcher.search('A', root);

        assertEquals('A', node.getValue());
    }

    @Test
    public void testGivenAlphabetTreeWhenSearchKnownValueThenReturnsIt2() {

        var node = TreeNodeSearcher.search('Z', root);

        assertEquals('Z', node.getValue());
    }

    @Test
    public void testGivenAlphabetTreeWhenSearchKnownValueThenReturnsIt3() {

        var node = TreeNodeSearcher.search('P', root);

        assertEquals('P', node.getValue());
    }
}
