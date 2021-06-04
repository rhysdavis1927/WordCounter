import java.io.File;
import java.io.FileNotFoundException;

public class WordCounterApp {

    public static void main(String[] args) {
        File file = new File("filename.txt");
        try {
            WordCountResult result = new WordCounter().CountWords(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
