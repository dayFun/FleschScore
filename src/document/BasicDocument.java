package document;

public class BasicDocument extends Document {

    private static final String NUM_WORDS = "[a-zA-Z]+";
    private static final String NUM_SENTENCES = "[^!?.]+";

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
        //TODO: Implement this method.  See the Module 1 support videos
        // if you need help.
        return 0;
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
