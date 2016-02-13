package document;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A naive implementation of the Document abstract class.
 *
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class BasicDocument extends Document {

    private static final String NUM_WORDS_REGEX = "([a-zA-Z]+)";
    private static final String NUM_SENTENCES_REGEX = "[\\.!?]+";
    private static final String NUM_VOWELS_REGEX = "[aeiouAEIOU]+";
    private static final String SILENT_E_REGEX = ".+[aeiouAEUIOU][^aeiouAEIOU][eE]";
    private static final String SILENT_E_EXCEPTION_REGEX = ".+[cClLrRsSvV][eE]";

    public BasicDocument(String text) {
        super(text);
    }

    @Override
    public int getNumWords() {
        return getTokens(NUM_WORDS_REGEX).size();
    }

    @Override
    public int getNumSentences() {
        return getTokens(NUM_SENTENCES_REGEX).size();
    }

    @Override
    public int getNumSyllables() {
        System.out.println();
        int numVowels = 0;

        List<String> words = getTokens(NUM_WORDS_REGEX);
        for (String word : words) {
            System.out.println("Syllable Count Before " + word + ": " + numVowels);
            numVowels += getAllVowelsInWord(word);
            System.out.println("Syllable Count After " + word + ": " + numVowels);
            System.out.println();
        }

        return numVowels;
    }


    private int getAllVowelsInWord(String word) {
        int numSyllables = 0;
        Pattern vowelSplitter = Pattern.compile(NUM_VOWELS_REGEX);
        Matcher matcher = vowelSplitter.matcher(word);

        while (matcher.find()) {
            numSyllables++;
        }

        if(wordEndsInSilentE(word) || silentEException(word)) {
            System.out.println("Word ends in silent E!");
            numSyllables--;
        }

        return numSyllables;
    }

    private boolean wordEndsInSilentE(String word) {
        Pattern silentEPattern = Pattern.compile(SILENT_E_REGEX);
        Matcher matcher = silentEPattern.matcher(word);

        return matcher.matches();
    }

    private boolean silentEException(String word) {
        Pattern silentEPattern = Pattern.compile(SILENT_E_EXCEPTION_REGEX);
        Matcher matcher = silentEPattern.matcher(word);

        return matcher.matches();
    }

    public static void main(String[] args) {
//        testCase(new BasicDocument("This is a test.  How many???  "
//                        + "Senteeeeeeeeeences are here... there should be 5!  Right?"),
//                16, 13, 5);
//        testCase(new BasicDocument(""), 0, 0, 0);
        testCase(new BasicDocument("sentence, with, lots, of, commas.!  "
                + "(And some poaren)).  The output is: 7.5."), 15, 11, 4);
//        testCase(new BasicDocument("many???  Senteeeeeeeeeences are"), 6, 3, 2);
//        testCase(new BasicDocument("Here is a series of test sentences. Your program should "
//                + "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
//                + "the correct amount of syllables (example, for example), "
//                + "but most of them will."), 49, 33, 3);
//        testCase(new BasicDocument("Segue"), 2, 1, 1);
//        testCase(new BasicDocument("Sentence"), 2, 1, 1);
//        testCase(new BasicDocument("Sentences?!"), 3, 1, 1);
//        testCase(new BasicDocument("Lorem ipsum dolor sit amet, qui ex choro quodsi moderatius, nam dolores explicari forensibus ad."),
//                32, 15, 1);


    }

}
