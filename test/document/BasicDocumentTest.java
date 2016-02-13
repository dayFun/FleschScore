package document;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BasicDocumentTest {

    private BasicDocument basicDocument;

    @Test
    public void testUCSD_Case_1() throws Exception {
        basicDocument = new BasicDocument("This is a test.  How many???  "
                + "Senteeeeeeeeeences are here... there should be 5!  Right?");

        assertThat(basicDocument.getNumWords(), is(equalTo(13)));
        assertThat(basicDocument.getNumSentences(), is(equalTo(5)));
        assertThat(basicDocument.getNumSyllables(), is(equalTo(16)));
    }

    @Test
    public void testUCSD_Case_2() throws Exception {
        basicDocument = new BasicDocument("");

        assertThat(basicDocument.getNumWords(), is(equalTo(0)));
        assertThat(basicDocument.getNumSentences(), is(equalTo(0)));
        assertThat(basicDocument.getNumSyllables(), is(equalTo(0)));
    }

    @Test
    public void testUCSD_Case_3() throws Exception {
        basicDocument = new BasicDocument("sentence, with, lots, of, commas.!  "
                + "(And some poaren)).  The output is: 7.5.");

        assertThat(basicDocument.getNumWords(), is(equalTo(11)));
        assertThat(basicDocument.getNumSentences(), is(equalTo(4)));
        assertThat(basicDocument.getNumSyllables(), is(equalTo(15)));
    }

    @Test
    public void testUCSD_Case_4() throws Exception {
        basicDocument = new BasicDocument("many???  Senteeeeeeeeeences are");

        assertThat(basicDocument.getNumWords(), is(equalTo(3)));
        assertThat(basicDocument.getNumSentences(), is(equalTo(2)));
        assertThat(basicDocument.getNumSyllables(), is(equalTo(6)));
    }

    @Test
    public void testUCSD_Case_5() throws Exception {
        basicDocument = new BasicDocument("Here is a series of test sentences. Your program should "
                + "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
                + "the correct amount of syllables (example, for example), "
                + "but most of them will.");

        assertThat(basicDocument.getNumWords(), is(equalTo(33)));
        assertThat(basicDocument.getNumSentences(), is(equalTo(3)));
        assertThat(basicDocument.getNumSyllables(), is(equalTo(49)));
    }

    @Test
    public void testUCSD_Case_6() throws Exception {
        basicDocument = new BasicDocument("Segue");

        assertThat(basicDocument.getNumWords(), is(equalTo(1)));
        assertThat(basicDocument.getNumSentences(), is(equalTo(1)));
        assertThat(basicDocument.getNumSyllables(), is(equalTo(2)));
    }

    @Test
    public void testUCSD_Case_7() throws Exception {
        basicDocument = new BasicDocument("Sentence");
        assertThat(basicDocument.getNumSyllables(), is(equalTo(2)));
    }

    @Test
    public void testUCSD_Case_8() throws Exception {
        basicDocument = new BasicDocument("Sentences");
        assertThat(basicDocument.getNumSyllables(), is(equalTo(3)));
    }

    @Test
    public void testUCSD_Case_9() throws Exception {
        basicDocument = new BasicDocument("Lorem ipsum dolor sit amet, qui ex choro "
                + "quodsi moderatius, nam dolores explicari forensibus ad.");

        assertThat(basicDocument.getNumWords(), is(equalTo(15)));
        assertThat(basicDocument.getNumSentences(), is(equalTo(1)));
        assertThat(basicDocument.getNumSyllables(), is(equalTo(32)));
    }
}