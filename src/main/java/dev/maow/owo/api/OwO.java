package dev.maow.owo.api;

import dev.maow.owo.util.Options;

public interface OwO {
    String translate(String s);

    String translate(TranslateMode mode, String s);

    Options getOptions();

    OwOProvider getProvider();

    enum TranslateMode {
        PLAIN,
        ALL
    }
}