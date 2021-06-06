import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordCountResult {
    private int wordCount;
    private double averageWordLength;
    private CountWithWordLengths mostFrequentWordLengthsAndCount;
    private Map<Integer, Integer> countOfEachWordLength;
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.###");

    public WordCountResult(int wordCount, double averageWordLength, Map<Integer, Integer> countOfEachWordLength) {
        this.wordCount = wordCount;
        this.averageWordLength = averageWordLength;
        this.countOfEachWordLength = countOfEachWordLength;
        this.mostFrequentWordLengthsAndCount = calculateMostFrequentWordLengthsAndCount();
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

    private CountWithWordLengths calculateMostFrequentWordLengthsAndCount() {
        int largestCount = 0;
        Set<Integer> mostFrequentWordLengths = new HashSet<>();
        for (Map.Entry<Integer, Integer> countByWordLength : countOfEachWordLength.entrySet()) {
            if (countByWordLength.getValue() == largestCount) {
                mostFrequentWordLengths.add(countByWordLength.getKey());
            } else if (countByWordLength.getValue() > largestCount) {
                largestCount = countByWordLength.getValue();
                mostFrequentWordLengths.clear();
                mostFrequentWordLengths.add(countByWordLength.getKey());
            }
        }

        return new CountWithWordLengths(largestCount, mostFrequentWordLengths);
    }

}
