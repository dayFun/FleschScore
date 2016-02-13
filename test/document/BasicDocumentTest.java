package document;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BasicDocumentTest {

    private BasicDocument basicDocument;

    @Test
    public void testNumWords_13_Words_UCSD_Case_1() throws Exception {
        basicDocument = new BasicDocument("This is a test.  How many???  "
                + "Senteeeeeeeeeences are here... there should be 5!  Right?");

        assertThat(basicDocument.getNumWords(), is(equalTo(13)));
    }

    @Test
    public void testNumWords_0_Words_UCSD_Case_2() throws Exception {
        basicDocument = new BasicDocument("");

        assertThat(basicDocument.getNumWords(), is(equalTo(0)));
    }

    @Test
    public void testNumWords_11_Words_UCSD_Case_3() throws Exception {
        basicDocument = new BasicDocument("sentence, with, lots, of, commas.!  "
                + "(And some poaren)).  The output is: 7.5.");

        assertThat(basicDocument.getNumWords(), is(equalTo(11)));
    }

    @Test
    public void testNumWords_3_Words_UCSD_Case_4() throws Exception {
        basicDocument = new BasicDocument("many???  Senteeeeeeeeeences are");

        assertThat(basicDocument.getNumWords(), is(equalTo(3)));
    }

    @Test
    public void testNumWords_33_Words_UCSD_Case_5() throws Exception {
        basicDocument = new BasicDocument("Here is a series of test sentences. Your program should "
                + "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
                + "the correct amount of syllables (example, for example), "
                + "but most of them will.");

        assertThat(basicDocument.getNumWords(), is(equalTo(33)));
    }

    @Test
    public void testNumWords_1_Word_UCSD_Case_6_7_8() throws Exception {
        basicDocument = new BasicDocument("Segue");

        assertThat(basicDocument.getNumWords(), is(equalTo(1)));
    }

    @Test
    public void testNumWords_15_Words_UCSD_Case_9() throws Exception {
        basicDocument = new BasicDocument("Lorem ipsum dolor sit amet, qui ex choro "
                + "quodsi moderatius, nam dolores explicari forensibus ad.");

        assertThat(basicDocument.getNumWords(), is(equalTo(15)));
    }

    ////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testNumSentences_5_Sentences_UCSD_Case_1() throws Exception {
        basicDocument = new BasicDocument("This is a test.  How many???  "
                + "Senteeeeeeeeeences are here... there should be 5!  Right?");

        assertThat(basicDocument.getNumSentences(), is(equalTo(5)));
    }

    @Test
    public void testNumSentences_0_Sentences_UCSD_Case_2() throws Exception {
        basicDocument = new BasicDocument("");

        assertThat(basicDocument.getNumSentences(), is(equalTo(0)));
    }

    @Test
    public void testNumSentences_4_Sentences_UCSD_Case_3() throws Exception {
        basicDocument = new BasicDocument("sentence, with, lots, of, commas.!  "
                + "(And some poaren)).  The output is: 7.5.");

        assertThat(basicDocument.getNumSentences(), is(equalTo(4)));
    }

    @Test
    public void testNumSentences_2_Sentences_UCSD_Case_4() throws Exception {
        basicDocument = new BasicDocument("many???  Senteeeeeeeeeences are");

        assertThat(basicDocument.getNumSentences(), is(equalTo(2)));
    }

    @Test
    public void testNumSentences_3_Sentences_UCSD_Case_5() throws Exception {
        basicDocument = new BasicDocument("Here is a series of test sentences. Your program should "
                + "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
                + "the correct amount of syllables (example, for example), "
                + "but most of them will.");

        assertThat(basicDocument.getNumSentences(), is(equalTo(3)));
    }

    @Test
    public void testNumSentences_1_Sentence_UCSD_Case_6_7_8() throws Exception {
        basicDocument = new BasicDocument("Segue");

        assertThat(basicDocument.getNumSentences(), is(equalTo(1)));
    }

    @Test
    public void testNumSentences_15_Sentences_UCSD_Case_9() throws Exception {
        basicDocument = new BasicDocument("Lorem ipsum dolor sit amet, qui ex choro "
                + "quodsi moderatius, nam dolores explicari forensibus ad.");

        assertThat(basicDocument.getNumSentences(), is(equalTo(1)));
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

}