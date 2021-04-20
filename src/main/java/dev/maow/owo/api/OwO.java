package dev.maow.owo.api;

import dev.maow.owo.util.Options;

import java.util.Optional;

/**
 * Provides plaintext -> owospeak conversion utilities.
 * <p>
 * An instance of {@code OwO} is typically initialized by a {@link OwOProvider}
 * and stores an instance of {@link Options}.
 * <p>
 * It is possible for the {@code Options} instance to be null,
 * in this event, subclasses of {@code OwO} should use the instance returned by {@link Options#defaults()}.
 *
 * @author Maow
 * @version %I%
 * @see dev.maow.owo.util.OwOFactory
 * @since 2.0.0
 */
public interface OwO {
    /**
     * Translates the string and returns the new string.
     * <p>
     * An implementation of {@code OwO} is not guaranteed to implement this method,
     * but it is recommended, as this is meant for defaulting to a specific {@link TranslateMode}.
     *
     * @param s the string to be translated
     * @return a translated version of the target string
     */
    String translate(String s);

    /**
     * Translates the string and returns the new string.
     *
     * @param mode the mode, which decides how this string is translated.
     * @param s the string to be translated
     * @return a translated version of the target string
     */
    String translate(TranslateMode mode, String s);

    /**
     * Returns this {@code OwO} instance's {@link Options}.
     * <p>
     * This has the possibility to be null based on the implementation of the {@code OwO}.
     *
     * @return an optional instance of {@code Options}
     */
    Optional<Options> getOptions();

    /**
     * Returns this {@code OwO} instance's {@link OwOProvider}.
     * <p>
     * In a standard implementation, this should not be null.
     *
     * @return an instance of {@code OwOProvider}
     */
    OwOProvider getProvider();

    /**
     * Stores the modes used by {@link OwO#translate(TranslateMode, String)}.
     * <p>
     * These affect how the string is translated.
     */
    enum TranslateMode {
        /**
         * Do not include prefixes or suffixes.
         * <p>
         * This is known as a "plain translation," as it only does substitutions.
         */
        PLAIN,

        /**
         * Perform all transformations, including prefixes or suffixes.
         */
        ALL
    }
}