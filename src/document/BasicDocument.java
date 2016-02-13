package document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicDocument extends Document {

    private static final String NUM_WORDS = "[a-zA-Z]+";
    private static final String NUM_SENTENCES = "[^!?.]+";
    private static final String NUM_VOWELS_REGEX = "[aeiouy]+";
    private static final String MAGIC_E_REGEX = "[aeiou][^aeiou]e\\z";
    private static final String MAGIC_E_EXCEPTION_REGEX = ".+[clrsv]e\\z";

    public BasicDocument(String text) {
        super(text);
    }

    @Override
    public int getNumWords() {
        return getTokens(NUM_WORDS).size();
    }

    @Override
    public int getNumSentences() {
        return getTokens(NUM_SENTENCES).size();
    }

    @Override
    public int getNumSyllables() {
        int numSyllables = 0;
        String[] words = getText().toLowerCase().replaceAll("[^a-zA-z ]", "").split("\\s+");

        for (String word : words) {
            numSyllables += getNumVowelsInWord(word);

            if (wordContainsMagicE(word) || magicEException(word)) {
                numSyllables--;
            }
        }

        return numSyllables;
    }

    private int getNumVowelsInWord(String word) {
        int numVowels = 0;

        Pattern pattern = Pattern.compile(NUM_VOWELS_REGEX);
        Matcher matcher = pattern.matcher(word);

        while (matcher.find()) {
            numVowels++;
        }

        return numVowels;
    }

    private boolean wordContainsMagicE(String word) {
        Pattern pattern = Pattern.compile(MAGIC_E_REGEX);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    private boolean magicEException(String word) {
        Pattern pattern = Pattern.compile(MAGIC_E_EXCEPTION_REGEX);
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    public static void main(String[] args) {
        testCase(new BasicDocument("This is a test.  How many???  "
                        + "Senteeeeeeeeeences are here... there should be 5!  Right?"),
                16, 13, 5);
        testCase(new BasicDocument(""), 0, 0, 0);
        testCase(new BasicDocument("sentence, with, lots, of, commas.!  "
                + "(And some poaren)).  The output is: 7.5."), 15, 11, 4);
        testCase(new BasicDocument("many???  Senteeeeeeeeeences are"), 6, 3, 2);
        testCase(new BasicDocument("Here is a series of test sentences. Your program should "
                + "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
                + "the correct amount of syllables (example, for example), "
                + "but most of them will."), 49, 33, 3);
        testCase(new BasicDocument("Segue"), 2, 1, 1);
        testCase(new BasicDocument("Sentence"), 2, 1, 1);
        testCase(new BasicDocument("Sentences?!"), 3, 1, 1);
        testCase(new BasicDocument("Lorem ipsum dolor sit amet, qui ex choro quodsi moderatius, nam dolores explicari forensibus ad."),
                32, 15, 1);


    }

}
