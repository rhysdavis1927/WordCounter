import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class WordCounterApp {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("WordCounter must be supplied with a file to analyse. Expected usage: java -jar WordCounter-1.0.0.jar src\\test\\resources\\example.txt");
        } else {
            File file = new File(args[0]);
            try {
                WordCountResult result = new WordCounter().CountWords(file);
                System.out.println("Word count = " + result.getWordCount());
                System.out.println("Average word length = " + result.getAverageWordLength());
                for (Map.Entry<Integer, Integer> countsByWordLength : result.getCountOfEachWordLength().entrySet()) {
                    System.out.println("Number of words of length " + countsByWordLength.getKey() + " is " + countsByWordLength.getValue());
                }
                CountWithWordLengths mostFrequentWordLengthsAndCount = result.getMostFrequentWordLengthsAndCount();
                System.out.println("The most frequently occurring word length is " + mostFrequentWordLengthsAndCount.getCount()
                        + ", for word lengths of " + getListOfWordLengthsString(mostFrequentWordLengthsAndCount));
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }
    }

    private static String getListOfWordLengthsString(CountWithWordLengths countWithWordLengths) {
        List<String> wordCounts = countWithWordLengths.getWordLengths().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        if (wordCounts.size() == 1) {
            return wordCounts.get(0);
        }

        return wordCounts.stream()
                .limit(wordCounts.size() - 1)
                .collect(Collectors.joining(", ", "", " & "))
                .concat(wordCounts.get(wordCounts.size() - 1));
    }
}
