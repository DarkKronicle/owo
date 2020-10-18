package maow.owo.util.json;

public class Defaults {
    private final Substitution[] substitutions;
    private final String[] prefixes;
    private final String[] suffixes;

    public Defaults(Substitution[] substitutions, String[] prefixes, String[] suffixes) {
        this.substitutions = substitutions;
        this.prefixes = prefixes;
        this.suffixes = suffixes;
    }

    public Substitution[] getSubstitutions() {
        return substitutions;
    }
    public String[] getPrefixes() {
        return prefixes;
    }
    public String[] getSuffixes() {
        return suffixes;
    }
}
