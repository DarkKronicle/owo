package maow.owo.util.json;

public class RandomizedLetter {
    private final String letter;
    private final int minimum;
    private final int maximum;

    public RandomizedLetter(String letter, int minimum, int maximum) {
        this.letter = letter;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public String getLetter() {
        return letter;
    }
    public int getMinimum() {
        return minimum;
    }
    public int getMaximum() {
        return maximum;
    }
}
