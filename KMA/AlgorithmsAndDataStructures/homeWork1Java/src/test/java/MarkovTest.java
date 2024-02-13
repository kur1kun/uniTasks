import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarkovTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private InputStream originalIn;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        originalIn = System.in;
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void firstMarkovTest() throws IOException {
        String input = "1\n|||||||||||||";
        String expectedOutput = "||||\n"; // Adjusted to include newline character
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);

        Markov.main(new String[]{});

        String actualOutput = outputStream.toString();

        // Normalize line separators
        expectedOutput = expectedOutput.replaceAll("\\R", "\n");
        actualOutput = actualOutput.replaceAll("\\R", "\n");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void secondMarkovTest() throws IOException {
        String input = "1\n||";
        String expectedOutput = "\n"; // Adjusted to include newline character
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);

        Markov.main(new String[]{});

        String actualOutput = outputStream.toString();

        // Normalize line separators
        expectedOutput = expectedOutput.replaceAll("\\R", "\n");
        actualOutput = actualOutput.replaceAll("\\R", "\n");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void thirdMarkovTest() throws IOException {
        String input = "2\n|||||||||||||";
        String expectedOutput = "13\n"; // Adjusted to include newline character
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);

        Markov.main(new String[]{});

        String actualOutput = outputStream.toString();

        // Normalize line separators
        expectedOutput = expectedOutput.replaceAll("\\R", "\n");
        actualOutput = actualOutput.replaceAll("\\R", "\n");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void fourthMarkovTest() throws IOException {
        String input = "2\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||";
        String expectedOutput = "70\n"; // Adjusted to include newline character
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);

        Markov.main(new String[]{});

        String actualOutput = outputStream.toString();

        // Normalize line separators
        expectedOutput = expectedOutput.replaceAll("\\R", "\n");
        actualOutput = actualOutput.replaceAll("\\R", "\n");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void fifthMarkovTest() throws IOException {
        String input = "2\n|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||";
        String expectedOutput = "211\n"; // Adjusted to include newline character
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);

        Markov.main(new String[]{});

        String actualOutput = outputStream.toString();

        // Normalize line separators
        expectedOutput = expectedOutput.replaceAll("\\R", "\n");
        actualOutput = actualOutput.replaceAll("\\R", "\n");

        assertEquals(expectedOutput, actualOutput);
    }
}
