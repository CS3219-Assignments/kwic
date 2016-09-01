package test;

import static org.junit.Assert.*;

import org.junit.Test;

import CS3213.RequiredWords;

public class RequiredWordsTest {
	
	@Test
	public void testIsWordRequired() {
		RequiredWords requiredWords = RequiredWords.getWordsRequired();

        assertFalse(requiredWords.isWordRequired("the"));

        requiredWords.addWordToRequire("the");
        requiredWords.addWordToRequire("of");
        requiredWords.addWordToRequire("");
        assertTrue(requiredWords.isWordRequired("the"));
        assertTrue(requiredWords.isWordRequired("of"));
        assertTrue(requiredWords.isWordRequired(""));
        assertFalse(requiredWords.isWordRequired("after"));
        assertFalse(requiredWords.isWordRequired("before"));

        requiredWords.addWordToRequire("of"); // add duplicated word
        requiredWords.addWordToRequire("after");
        requiredWords.removeWordToRequire("the");
        requiredWords.removeWordToRequire("");
        assertFalse(requiredWords.isWordRequired("the"));
        assertTrue(requiredWords.isWordRequired("of"));
        assertFalse(requiredWords.isWordRequired(""));
        assertTrue(requiredWords.isWordRequired("after"));
        assertFalse(requiredWords.isWordRequired("before"));
	}

}
