import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class WordCounterTest {


    @Test
    public void wordCountOfExampleFileMatchesProvidedValue() throws FileNotFoundException {
        WordCountResult result = new WordCounter().CountWords(new File("src/test/resources/example.txt"));

        assertEquals(9, result.getWordCount());
    }

    @Test
    public void averageWordLengthOfExampleMatchesProvidedValue() throws FileNotFoundException {
        WordCountResult result = new WordCounter().CountWords(new File("src/test/resources/example.txt"));

        assertEquals("4.556", result.getAverageWordLength());
    }

    @Test
    public void countOfEachWordLengthMatchesProvidedValues() throws FileNotFoundException {
        WordCountResult result = new WordCounter().CountWords(new File("src/test/resources/example.txt"));

        Map<Integer, Integer> countOfEachWordLength = result.getCountOfEachWordLength();

        Map<Integer, Integer> expected = new HashMap<Integer, Integer>();
        expected.put(1, 1);
        expected.put(2, 1);
        expected.put(3, 1);
        expected.put(4, 2);
        expected.put(5, 2);
        expected.put(7, 1);
        expected.put(10, 1);
        assertEquals(expected, countOfEachWordLength);
    }

    @Test
    public void highestWordLengthCountMatchesProvidedValue() throws FileNotFoundException {
        WordCountResult result = new WordCounter().CountWords(new File("src/test/resources/example.txt"));

        assertEquals(2, result.getMostFrequentWordLengthCount());
    }

    @Test
    public void wordLengthsOfHighestWordLengthCountMatchesProvidedValue() throws FileNotFoundException {
        WordCountResult result = new WordCounter().CountWords(new File("src/test/resources/example.txt"));

        HashSet<Integer> expected = new HashSet<Integer>();
        expected.add(4);
        expected.add(5);
        assertEquals(expected, result.getMostFrequentWordLengths());
    }

    @Test
    public void wordCountOfCorrectlyHandlesPunctuation() throws FileNotFoundException {
        WordCountResult result = new WordCounter().CountWords(new File("src/test/resources/punctuation.txt"));

        Map<Integer, Integer> expectedCounts = new HashMap<Integer, Integer>();
        expectedCounts.put(1, 1);
        expectedCounts.put(2, 1);
        expectedCounts.put(3, 2);
        expectedCounts.put(4, 1);
        expectedCounts.put(8, 1);
        expectedCounts.put(11, 2);
        assertEquals(expectedCounts, result.getCountOfEachWordLength());
        assertEquals(8, result.getWordCount());
        assertEquals("5.375", result.getAverageWordLength());
    }
}
