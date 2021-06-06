import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class WordCounter {

    public WordCountResult CountWords(File file) throws FileNotFoundException {
        int wordCount = 0;
        int sumOfLettersInWords = 0;
        Map<Integer, Integer> countOfEachWordLength = new HashMap<>();

        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(Pattern.compile("[\".?!:;)\\]]?\\s+[\"(\\[]?"));

        while (scanner.hasNext()) {
            String data = scanner.next();
            wordCount++;
            int lettersInWord = data.length();
            sumOfLettersInWords = sumOfLettersInWords + lettersInWord;
            Integer currentCountOfWordLength = countOfEachWordLength.get(lettersInWord);
            int newCountOfWordLength = currentCountOfWordLength == null ? 1 : currentCountOfWordLength + 1;
            countOfEachWordLength.put(lettersInWord, newCountOfWordLength);
        }
        scanner.close();
        return new WordCountResult(wordCount, sumOfLettersInWords / (double) wordCount, countOfEachWordLength);
    }
}
