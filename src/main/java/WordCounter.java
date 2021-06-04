import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class WordCounter {

    public WordCountResult CountWords(File file) throws FileNotFoundException {
        int wordCount = 0;
        int sumOfLettersInWords = 0;
        int mostFrequentWordLengthsCount = 0;
        Set<Integer> mostFrequentWordLengths = new HashSet<Integer>();
        Map<Integer, Integer> countOfEachWordLength = new HashMap<Integer, Integer>();

        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(Pattern.compile("[.?!]?\\s+"));

        while (scanner.hasNext()) {
            String data = scanner.next();
            wordCount++;
            int lettersInWord = data.length();
            sumOfLettersInWords = sumOfLettersInWords + lettersInWord;
            Integer currentCountOfWordLength = countOfEachWordLength.get(lettersInWord);
            int newCountOfWordLength = currentCountOfWordLength == null ? 1 : currentCountOfWordLength + 1;
            countOfEachWordLength.put(lettersInWord, newCountOfWordLength);

            if (newCountOfWordLength == mostFrequentWordLengthsCount) {
                mostFrequentWordLengths.add(lettersInWord);
            }
            else if (newCountOfWordLength > mostFrequentWordLengthsCount){
                mostFrequentWordLengthsCount = newCountOfWordLength;
                mostFrequentWordLengths.clear();
                mostFrequentWordLengths.add(lettersInWord);
            }

        }
        scanner.close();
        return new WordCountResult(wordCount, sumOfLettersInWords / (double) wordCount, countOfEachWordLength, mostFrequentWordLengthsCount, mostFrequentWordLengths);
    }
}