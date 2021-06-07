import java.text.DecimalFormat;
import java.util.Map;

public class WordCountResult {
    private int wordCount;
    private double averageWordLength;
    private Map<Integer, Integer> countOfEachWordLength;
    private CountWithWordLengths mostFrequentWordLengthsAndCount;
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.###");

    public WordCountResult(int wordCount, double averageWordLength, Map<Integer, Integer> countOfEachWordLength,
                           CountWithWordLengths mostFrequentWordLengthsAndCount) {
        this.wordCount = wordCount;
        this.averageWordLength = averageWordLength;
        this.countOfEachWordLength = countOfEachWordLength;
        this.mostFrequentWordLengthsAndCount = mostFrequentWordLengthsAndCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public String getAverageWordLength() {
        return decimalFormat.format(averageWordLength);
    }

    public Map<Integer, Integer> getCountOfEachWordLength() {
        return countOfEachWordLength;
    }

    public CountWithWordLengths getMostFrequentWordLengthsAndCount() {
        return mostFrequentWordLengthsAndCount;
    }
}
