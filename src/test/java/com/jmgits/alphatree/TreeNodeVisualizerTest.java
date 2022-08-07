package com.jmgits.alphatree;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;

/**
 * Unit testing for {@link TreeNodeVisualizer}
 **/
public class TreeNodeVisualizerTest {

    private final TreeNode root = TreeNodeUtils.createAlphabetTree();

    @Test
    public void testGivenAlphabetTreeWhenVisualizingItsContentThenDoesItRight() {

        try (var outputStream = new ByteArrayOutputStream();
             var printStream = new PrintStream(outputStream, true, UTF_8)) {

            TreeNodeVisualizer.visualize(root, printStream);

            String content = outputStream.toString(UTF_8);

            var expectedContent = Files.readString(Paths.get("src/test/resources/alphaTreeVisual.txt"), UTF_8);

            assertEquals(expectedContent, content);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
