import java.util.Set;

public class CountWithWordLengths {
    private int count;
    private Set<Integer> wordLengths;

    public CountWithWordLengths(int count, Set<Integer> wordLengths) {
        this.count = count;
        this.wordLengths = wordLengths;
    }

    public int getCount() {
        return count;
    }

    public Set<Integer> getWordLengths() {
        return wordLengths;
    }
}
