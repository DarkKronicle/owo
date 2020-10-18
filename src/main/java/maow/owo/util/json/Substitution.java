package maow.owo.util.json;

public class Substitution {
    private final String original;
    private final String substitute;
    private final boolean byItself;

    public Substitution(String original, String substitute, boolean byItself) {
        this.original = original;
        this.substitute = substitute;
        this.byItself = byItself;
    }

    public String getOriginal() {
        return original;
    }
    public String getSubstitute() {
        return substitute;
    }
    public boolean isByItself() {
        return byItself;
    }
}
