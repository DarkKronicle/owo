package dev.maow.owo.util;

import java.util.*;

final class OptionsUtil {
    private OptionsUtil() {
        throw new UnsupportedOperationException();
    }

    static Options getDefaultOptions() {
        return new Options(
                -1,
                new SubstitutionsBuilder()
                        .add("r", "w")
                        .add("l", "w")
                        .add("hi", "hai")
                        .add("fuck", "fwuck")
                        .add("no", "nu")
                        .add("has", "haz")
                        .add("have", "haz")
                        .add("says", "sez")
                        .add("you", "uu")
                        .add("the", "da")
                        .build(),
                Arrays.asList(
                        "<3",
                        "0w0",
                        "H-hewwo??",
                        "Hi!",
                        "Hai!",
                        "OWO",
                        "OwO",
                        "UwU"
                ),
                Arrays.asList(
                        "( ͡° ᴥ ͡°)",
                        "(இωஇ )",
                        "(๑•́ ₃ •̀๑)",
                        "(• o •)",
                        "(●´ω｀●)",
                        "(◠‿◠✿)",
                        "(✿ ♡‿♡)",
                        "(❁´◡`❁)",
                        "(　'◟ ')",
                        "(人◕ω◕)",
                        "(；ω；)",
                        "(｀へ´)",
                        "._.",
                        ":3",
                        ":D",
                        ":P",
                        ";-;",
                        ";3",
                        ";_;",
                        "<{^v^}>",
                        ">_<",
                        ">_>",
                        "UwU",
                        "XDDD",
                        "^-^",
                        "^_^",
                        "x3",
                        "x3",
                        "xD",
                        "ÙωÙ",
                        "ʕʘ‿ʘʔ",
                        "ㅇㅅㅇ",
                        "fwendo",
                        "（＾ｖ＾）"
                )
        );
    }

    static class SubstitutionsBuilder {
        private final Map<String, String> substitutions
                = new HashMap<>();

        SubstitutionsBuilder add(String original, String substitution) {
            substitutions.put(original, substitution);
            return this;
        }

        Map<String, String> build() {
            return substitutions;
        }
    }
}