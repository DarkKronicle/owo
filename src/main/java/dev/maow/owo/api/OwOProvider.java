package dev.maow.owo.api;

import dev.maow.owo.util.Options;
import dev.maow.owo.util.OwOFactory;

/**
 * Provides an instance of {@link OwO}.
 * <p>
 * An {@code OwO} will keep this provider and allow access to it
 * using the {@link OwO#getProvider()} method.
 *
 * @author Maow
 * @version %I%
 * @see OwOFactory
 * @since 2.0.0
 */
public interface OwOProvider {
    /**
     * Returns an instance of {@link OwO} without a specified {@link Options}.
     * <p>
     * Supplying an {@code Options} instance is based on the provider's implementation.
     * One such example is {@link OwOFactory#create(Options)}.
     *
     * @return an instance of {@code OwO}
     */
    OwO create();
}