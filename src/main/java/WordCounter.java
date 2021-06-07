import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class WordCounter {

    public WordCountResult CountWords(File file) throws FileNotFoundException {
        int sumOfLettersInWords = 0;
        Map<Integer, Integer> countOfEachWordLength = new HashMap<>();

        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(Pattern.compile("[\".?!:;()\\[\\]\\s]+"));

        while (scanner.hasNext()) {
            String data = scanner.next();
            int lettersInWord = data.length();
            sumOfLettersInWords = sumOfLettersInWords + lettersInWord;
            Integer currentCountOfWordLength = countOfEachWordLength.get(lettersInWord);
            int newCountOfWordLength = currentCountOfWordLength == null ? 1 : currentCountOfWordLength + 1;
            countOfEachWordLength.put(lettersInWord, newCountOfWordLength);
        }
        scanner.close();

        int largestCount = 0;
        int totalWordCount = 0;
        Set<Integer> mostFrequentWordLengths = new HashSet<>();
        for (Map.Entry<Integer, Integer> countByWordLength : countOfEachWordLength.entrySet()) {
            Integer countOfWordLength = countByWordLength.getValue();
            totalWordCount = totalWordCount + countOfWordLength;
            if (countOfWordLength == largestCount) {
                mostFrequentWordLengths.add(countByWordLength.getKey());
            } else if (countOfWordLength > largestCount) {
                largestCount = countOfWordLength;
                mostFrequentWordLengths.clear();
                mostFrequentWordLengths.add(countByWordLength.getKey());
            }
        }
        double averageWordCount = sumOfLettersInWords / (double) totalWordCount;

        return new WordCountResult(totalWordCount, averageWordCount, countOfEachWordLength,  new CountWithWordLengths(largestCount, mostFrequentWordLengths));
    }
}
