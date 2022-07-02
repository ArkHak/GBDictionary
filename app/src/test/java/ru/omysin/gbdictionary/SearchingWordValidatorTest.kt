package ru.omysin.gbdictionary

import org.junit.Assert.*
import org.junit.Test
import ru.omysin.gbdictionary.test.isCorrectSearchingWord
import ru.omysin.gbdictionary.test.isNotEmptySearchingWord
import ru.omysin.gbdictionary.test.nullSearchingWordForTest

class SearchingWordValidatorTest {
    @Test
    fun searchingWordValidator_InvalidSearchingWord_ReturnsFalse() {
        assertFalse(isCorrectSearchingWord("55"))
    }

    @Test
    fun searchingWordValidator_InvalidSearchingWordSpecialSymbol_ReturnsFalse() {
        assertFalse(isCorrectSearchingWord("w0rd"))
    }

    @Test
    fun searchingWordValidator_CorrectSearchingWord_ReturnsTrue() {
        assertTrue(isCorrectSearchingWord("word"))
    }

    @Test
    fun searchingWordValidator_NotEmptySearchingWord_ReturnsTrue() {
        assertTrue(isNotEmptySearchingWord("word"))
    }

    @Test
    fun searchingWordValidator_EmptySearchingWord_ReturnsFalse() {
        assertFalse(isNotEmptySearchingWord(""))
    }

    @Test
    fun searchingWordValidator_NotNullSearchingWord_ReturnsNotNull() {
        assertNotNull(nullSearchingWordForTest("word"))
    }

    @Test
    fun searchingWordValidator_NullSearchingWord_ReturnsNull() {
        assertNull(nullSearchingWordForTest(""))
    }

}