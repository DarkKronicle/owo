package maow.owo;

import maow.owo.util.IOUtil;
import maow.owo.util.ParsingUtil;
import maow.owo.util.json.Defaults;
import maow.owo.util.json.Substitution;

import java.util.*;

public class OwO {
    private OwO() {
        refreshDefaults();
    }

    public static final OwO INSTANCE = new OwO();

    private final List<Substitution> SUBSTITUTIONS = new ArrayList<>();
    private final List<String> PREFIXES = new ArrayList<>();
    private final List<String> SUFFIXES = new ArrayList<>();

    private void refreshDefaults() {
        Defaults defaults = IOUtil.readResourceToDefaults("defaults.json");
        if (defaults != null) {
            SUBSTITUTIONS.addAll(Arrays.asList(defaults.getSubstitutions()));
            PREFIXES.addAll(Arrays.asList(defaults.getPrefixes()));
            SUFFIXES.addAll(Arrays.asList(defaults.getSuffixes()));
        }
    }

    public String owo(String s, int maxLength) {
        return ParsingUtil.parse(s, maxLength, false);
    }
    public String owo(String s) {
        return owo(s, 0);
    }

    public String translate(String s, int maxLength) {
        return ParsingUtil.parse(s, maxLength, true);
    }
    public String translate(String s) {
        return translate(s, 0);
    }

    public List<Substitution> getSubstitutions() { return this.SUBSTITUTIONS; }

    public List<String> getPrefixes() { return this.PREFIXES; }
    public List<String> getSuffixes() { return this.SUFFIXES; }

    public void addSubstitution(Substitution substitution) { this.SUBSTITUTIONS.add(substitution); }
    public void addSubstitution(String original, String substitute, boolean byItself) { this.SUBSTITUTIONS.add(new Substitution(original, substitute, byItself)); }

    public void addPrefix(String prefix) { this.PREFIXES.add(prefix); }
    public void addSuffix(String suffix) { this.SUFFIXES.add(suffix); }

    public void addFromJson(String path) {
        Defaults defaults = IOUtil.readFileToDefaults(path);
        if (defaults != null) {
            SUBSTITUTIONS.addAll(Arrays.asList(defaults.getSubstitutions()));
            PREFIXES.addAll(Arrays.asList(defaults.getPrefixes()));
            SUFFIXES.addAll(Arrays.asList(defaults.getSuffixes()));
        }
    }
}
