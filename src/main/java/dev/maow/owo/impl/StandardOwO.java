package dev.maow.owo.impl;

import dev.maow.owo.api.OwO;
import dev.maow.owo.api.OwOProvider;
import dev.maow.owo.util.Options;
import dev.maow.owo.util.OwOFactory;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

/**
 * A standard implementation of {@link OwO} provided by {@link OwOFactory}.
 * <p>
 * This class should NOT be instantiated directly.
 * Instances should be created using the {@link OwOFactory#create} method.
 *
 * @author Maow
 * @version %I%
 * @since 2.0.0
 */
public class StandardOwO implements OwO {
    private static final Random RANDOM = new Random();

    private final Options options;
    private final OwOProvider provider;

    public StandardOwO(Options options, OwOProvider provider) {
        this.options = (options == null)
                ? Options.defaults()
                : options;
        this.provider = provider;
    }

    @Override
    public String translate(String s) {
        return translate(TranslateMode.PLAIN, s);
    }

    @Override
    public String translate(TranslateMode mode, String s) {
        return (mode == TranslateMode.PLAIN)
                ? plainTranslate(s)
                : allTranslate(s);
    }

    private String allTranslate(String s) {
        s = plainTranslate(s);
        return (RANDOM.nextInt(2) == 1)
                ? prefix(s)
                : suffix(s);
    }

    private String plainTranslate(String s) {
        final Map<String, String> subs =
                options.getSubstitutions();
        for (String key : subs.keySet())
            if (s.contains(key)) {
                final String seb = subs.get(key);
                s = s.replace(key, seb);
            }
        return s;
    }

    private String prefix(String s) {
        final String result = rand(options.getPrefixes()) + ' ' + s;
        return (under(result)) ? result : s;
    }

    private String suffix(String s) {
        final String result = s + ' ' + rand(options.getSuffixes());
        return (under(result)) ? result : s;
    }

    @Override
    public Optional<Options> getOptions() {
        return Optional.of(options);
    }

    @Override
    public OwOProvider getProvider() {
        return provider;
    }

    private String rand(List<String> list) {
        return list.get(RANDOM.nextInt(list.size()));
    }

    private boolean under(String s) {
        final int length = options.getMaxLength();
        if (length == -1) return true;
        return s.length() < length;
    }
}