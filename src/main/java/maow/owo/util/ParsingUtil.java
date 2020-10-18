package maow.owo.util;

import maow.owo.OwO;
import maow.owo.util.json.RandomizedLetter;
import maow.owo.util.json.Substitution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParsingUtil {
    private ParsingUtil() {}
    private static int maxCharacters = 0;

    public static String parse(String s, int maxLength, boolean translate) {
        maxCharacters = maxLength;
        if (!translate) {
            s = addAffixes(s);
        }
        for (Substitution sub : OwO.INSTANCE.getSubstitutions()) {
            String value = parseRandomizedLetters(sub.getSubstitute());
            if (s.endsWith(".")) {
                s = s.substring(0, s.length() - 1);
            }
            String regex = sub.isByItself() ? "(?i)\\b(" + sub.getOriginal() + ")\\b" : sub.getOriginal();
            String replaced = s.replaceAll(regex, value);
            if (maxCharacters == 0 || replaced.length() <= maxCharacters) {
                s = replaced;
            }
        }
        return s;
    }

    public static String addAffixes(String s) {
        return addSuffix(addPrefix(s));
    }

    public static String addPrefix(String s) {
        String withAffix = parseRandomizedLetters(getRandomElement(OwO.INSTANCE.getPrefixes())) + " " + s;
        if (withAffix.length() <= maxCharacters || maxCharacters == 0) {
            return withAffix;
        }
        return s;
    }

    public static String addSuffix(String s) {
        String withAffix = s + " " + parseRandomizedLetters(getRandomElement(OwO.INSTANCE.getSuffixes()));
        if (withAffix.length() <= maxCharacters || maxCharacters == 0) {
            return withAffix;
        }
        return s;
    }

    public static String parseRandomizedLetters(String s) {
        List<Integer> indexes = getIndexesOfRandomizedLetters(s);
        List<RandomizedLetter> letters = new ArrayList<>();
        for (Integer index1 : indexes) {
            String letter = Character.toString(s.charAt(index1));
            int minimum = Integer.parseInt(s.substring(index1 + 2, index1 + 3));
            int maximum = Integer.parseInt(s.substring(index1 + 4, index1 + 5));
            RandomizedLetter randomizedLetter = new RandomizedLetter(letter, minimum, maximum);
            letters.add(randomizedLetter);
        }
        for (RandomizedLetter letter : letters) {
            String firstHalf = s.substring(0, s.indexOf(letter.getLetter()) + 1);
            String secondHalf = s.substring(s.indexOf(letter.getLetter()) + 1);
            s = firstHalf + generateRandomAmountOfChars(letter.getLetter(), letter.getMinimum(), letter.getMaximum()) + secondHalf;
        }
        return removeParseLeftovers(s);
    }

    public static List<Integer> getIndexesOfRandomizedLetters(String s) {
        List<Integer> indexes = new ArrayList<>();
        int index = s.indexOf('[');
        while (index >= 0) {
            indexes.add(index - 1);
            index = s.indexOf('[', index + 2);
        }
        return indexes;
    }

    public static String removeParseLeftovers(String s) {
        int start = s.indexOf('[');
        int end = s.indexOf(']');
        while (start >= 0 && end >= 0) {
            s = s.replace(s.substring(start, end + 1), "");
            start = s.indexOf('[', start + 2);
            end = s.indexOf(']', end + 2);
        }
        return s;
    }

    public static String generateRandomAmountOfChars(String letter, int minimum, int maximum) {
        return IntStream.range(minimum, ThreadLocalRandom.current().nextInt(minimum, maximum)).mapToObj(i -> letter).collect(Collectors.joining(""));
    }

    public static String getRandomElement(List<String> strings) {
        return strings.get(ThreadLocalRandom.current().nextInt(0, strings.size()));
    }
}
