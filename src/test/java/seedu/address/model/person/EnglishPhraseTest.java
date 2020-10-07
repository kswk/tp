package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class EnglishPhraseTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new EnglishPhrase(null));
    }

    @Test
    public void constructor_invalidPhone_throwsIllegalArgumentException() {
        String invalidPhone = "";
        assertThrows(IllegalArgumentException.class, () -> new EnglishPhrase(invalidPhone));
    }

    @Test
    public void isValidPhone() {
        // null English phrase
        assertThrows(NullPointerException.class, () -> EnglishPhrase.isValidEnglishPhrase(null));

        // invalid English Phrase
        assertFalse(EnglishPhrase.isValidEnglishPhrase("")); // empty string
        assertFalse(EnglishPhrase.isValidEnglishPhrase(" ")); // spaces only
        assertFalse(EnglishPhrase.isValidEnglishPhrase("999")); // numeric only
        assertFalse(EnglishPhrase.isValidEnglishPhrase("^")); // only non-alphabet characters
        assertFalse(EnglishPhrase.isValidEnglishPhrase("peter*")); // contains non-alphabet characters

        // valid English Phrase
        assertTrue(EnglishPhrase.isValidEnglishPhrase("peter jack")); // alphabets only
        assertTrue(EnglishPhrase.isValidEnglishPhrase("Capital Tan")); // with capital letters
        assertTrue(EnglishPhrase.isValidEnglishPhrase("David Roger Jackson Ray Jr 2nd")); // long English phrases
    }
}
