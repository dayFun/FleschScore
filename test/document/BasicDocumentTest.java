package document;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BasicDocumentTest {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;

    private BasicDocument basicDocument;

//    @Test
//    public void testWhenNumWordsWhenThereAreZeroWords() throws Exception {
//        basicDocument = new BasicDocument("");
//
//        assertThat(basicDocument.getNumWords(), is(equalTo(ZERO)));
//    }
//
//    @Test
//    public void testWhenNumWordsWhenThereIsOneWords() throws Exception {
//        basicDocument = new BasicDocument("One");
//
//        assertThat(basicDocument.getNumWords(), is(equalTo(ONE)));
//    }
//
//    @Test
//    public void testWhenNumWordsWhenThereAreMultipleWords() throws Exception {
//        basicDocument = new BasicDocument("One two three four five");
//
//        assertThat(basicDocument.getNumWords(), is(equalTo(FIVE)));
//    }
//
//    //Syllables / Words / Sentences
//
//    @Test
//    public void testExampleSentences() throws Exception {
//        basicDocument = new BasicDocument("This is a test.  How many???  "
//                + "Senteeeeeeeeeences are here... there should be 5!  Right?");
//
//        assertThat(basicDocument.getNumSentences(), is(equalTo(FIVE)));
//        assertThat(basicDocument.getNumWords(), is(equalTo(13)));
//
//        basicDocument = new BasicDocument("sentence, with, lots, of, commas.!  "
//                + "(And some poaren)).  The output is: 7.5.");
//
//        assertThat(basicDocument.getNumSentences(), is(equalTo(FOUR)));
//        assertThat(basicDocument.getNumWords(), is(equalTo(11)));
//    }

    @Test
    public void testCountSyllables_Closed() throws Exception {
        basicDocument = new BasicDocument("ask");

        assertThat(basicDocument.getNumSyllables(), is(equalTo(ONE)));
    }

    @Test
    public void testCountSyllables_Open() throws Exception {
        basicDocument = new BasicDocument("no");

        assertThat(basicDocument.getNumSyllables(), is(equalTo(ONE)));
    }

    @Test
    public void testCountSyllables_TwoContiguousVowelsCountAsOne() throws Exception {
        basicDocument = new BasicDocument("rain");

        assertThat(basicDocument.getNumSyllables(), is(equalTo(ONE)));
    }

    @Test
    public void testCountSyllables_ThreeContiguousVowelsCountAsOne() throws Exception {
        basicDocument = new BasicDocument("beautiful");

        assertThat(basicDocument.getNumSyllables(), is(equalTo(THREE)));
    }

    @Test
    public void testCountSyllables_SilentE() throws Exception {
        basicDocument = new BasicDocument("sentence");

        assertThat(basicDocument.getNumSyllables(), is(equalTo(TWO)));
    }

    @Test
    public void testCountSyllables_Consonant_L_E() throws Exception {
        basicDocument = new BasicDocument("able");

        assertThat(basicDocument.getNumSyllables(), is(equalTo(TWO)));
    }

    @Test
    public void testCountSyllables_VowelFollowedByR() throws Exception {
//        basicDocument = new BasicDocument("tune");
//
//        assertThat(basicDocument.getNumSyllables(), is(equalTo(ONE)));
    }


}