package dev.maow.owo.util;

import java.util.*;

/**
 * An immutable class that stores instances of different options present in {@link dev.maow.owo.api.OwO}.
 * <p>
 * This class is immutable in the way that when an option is changed, a new instance of {@code Options} is created.
 * <p>
 * This class also has a default set of options accessible by {@link Options#defaults()}.
 *
 * @author Maow
 * @version %I%
 * @since 2.0.0
 */
public class Options {
    private static Options defaultOptions;

    private final int maxLength;
    private final Map<String, String> substitutions;
    private final List<String> prefixes;
    private final List<String> suffixes;

    public Options(int maxLength,
                   Map<String, String> substitutions,
                   List<String> prefixes,
                   List<String> suffixes) {
        this.maxLength = maxLength;
        this.substitutions = substitutions;
        this.prefixes = prefixes;
        this.suffixes = suffixes;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public Options setMaxLength(int maxLength) {
        return new Options(
                maxLength,
                new HashMap<>(substitutions),
                new ArrayList<>(suffixes),
                new ArrayList<>(prefixes)
        );
    }

    public Map<String, String> getSubstitutions() {
        return substitutions;
    }

    public Options addSubstitution(String original, String substitution) {
        final Map<String, String> newSubstitutions
                = new HashMap<>(substitutions);
        newSubstitutions.put(original, substitution);
        return new Options(
                maxLength, newSubstitutions,
                new ArrayList<>(prefixes),
                new ArrayList<>(suffixes)
        );
    }

    public List<String> getPrefixes() {
        return prefixes;
    }

    public Options addPrefix(String prefix) {
        final List<String> newPrefixes = new ArrayList<>();
        newPrefixes.add(prefix);
        return new Options(
                maxLength,
                new HashMap<>(substitutions),
                newPrefixes,
                new ArrayList<>(suffixes)
        );
    }

    public List<String> getSuffixes() {
        return suffixes;
    }

    public Options addSuffix(String suffix) {
        final List<String> newSuffixes = new ArrayList<>();
        newSuffixes.add(suffix);
        return new Options(
                maxLength,
                new HashMap<>(substitutions),
                new ArrayList<>(prefixes),
                newSuffixes
        );
    }

    public static Options defaults() {
        return (defaultOptions == null)
                ? defaultOptions = OptionsUtil.getDefaultOptions()
                : defaultOptions;
    }
}