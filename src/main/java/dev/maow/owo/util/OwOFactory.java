package dev.maow.owo.util;

import dev.maow.owo.api.OwO;
import dev.maow.owo.impl.StandardOwO;
import dev.maow.owo.api.OwOProvider;

/**
 * An implementation of {@link OwOProvider} that supplies
 * an instance of {@link OwO} in the form of a {@link StandardOwO}.
 * <p>
 * This implementation allows for supplying an instance of {@link Options} to the {@code OwO}.
 *
 * @author Maow
 * @version %I%
 * @since 2.0.0
 */
public final class OwOFactory implements OwOProvider {
    private OwOFactory() {}

    public static final OwOFactory INSTANCE = new OwOFactory();

    public OwO create(Options options) {
        return new StandardOwO(options, this);
    }

    @Override
    public OwO create() {
        return create(Options.defaults());
    }
}