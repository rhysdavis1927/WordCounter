import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

public class WordCountResult {
    private int wordCount;
    private double averageWordLength;
    private Map<Integer, Integer> countOfEachWordLength;
    private int mostFrequentWordLengthsCount;
    private Set<Integer> mostFrequentWordLengths;
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.###");

    public WordCountResult(int wordCount, double averageWordLength, Map<Integer, Integer> countOfEachWordLength,
                           int mostFrequentWordLengthsCount, Set<Integer> mostFrequentWordLengths) {
        this.wordCount = wordCount;
        this.averageWordLength = averageWordLength;
        this.countOfEachWordLength = countOfEachWordLength;
        this.mostFrequentWordLengthsCount = mostFrequentWordLengthsCount;
        this.mostFrequentWordLengths = mostFrequentWordLengths;
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

    public int getMostFrequentWordLengthCount() {
        return mostFrequentWordLengthsCount;
    }

    public Set<Integer> getMostFrequentWordLengths() {
        return mostFrequentWordLengths;
    }
}
