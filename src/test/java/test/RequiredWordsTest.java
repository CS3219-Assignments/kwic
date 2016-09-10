package test;

import static org.junit.Assert.*;
import org.junit.Test;
import CS3213.RequiredWords;

public class RequiredWordsTest {
	
	@Test
	public void testIsWordRequired() {
		RequiredWords requiredWords = RequiredWords.getWordsRequired();
	
        assertFalse(requiredWords.isWordRequired("Hello"));
       
        requiredWords.addWordToRequire("World");
        requiredWords.addWordToRequire("Great");
        requiredWords.addWordToRequire("");
        assertTrue(requiredWords.isWordRequired("World"));
        assertTrue(requiredWords.isWordRequired("Great"));
        assertTrue(requiredWords.isWordRequired(""));
        assertFalse(requiredWords.isWordRequired("great"));
        assertFalse(requiredWords.isWordRequired("Movie"));
        
        requiredWords.addWordToRequire("great");
        requiredWords.addWordToRequire("after");
        requiredWords.removeWordToRequire("Great");
        requiredWords.removeWordToRequire("");
        assertFalse(requiredWords.isWordRequired("Great"));
        assertTrue(requiredWords.isWordRequired("great"));
        assertFalse(requiredWords.isWordRequired(""));
        assertTrue(requiredWords.isWordRequired("after"));    
	}
}
