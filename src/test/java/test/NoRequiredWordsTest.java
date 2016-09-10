package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import CS3213.Alphabetizer;
import CS3213.CircularShift;
import CS3213.RequiredWords;
import CS3213.WordsToIgnore;

public class NoRequiredWordsTest {
	
	@Test
	public void testNoRequiredWords(){
	
		List<String> inputs = new ArrayList<String>();
		inputs.add("Harry Potter and the Goblet of fire");
		
		WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
		wordsToIgnore.addWordToIgnore("and");
	    wordsToIgnore.addWordToIgnore("of");
	    
	    RequiredWords requiredWords = RequiredWords.getWordsRequired();
	    
	    String[] inputWordToRequire = {};
	   
	    for (String requireWords: inputWordToRequire){
	    	if(!wordsToIgnore.isWordIgnored(requireWords)){
	    		requiredWords.addWordToRequire(requireWords);
	    	}
	    }
	    
	    Alphabetizer alphabetizer = new Alphabetizer();
        for (String str : inputs) {
        	
            CircularShift shifter = new CircularShift(str);
            alphabetizer.addLines(shifter.getCircularShifts());
        }
        
        String[] output = alphabetizer.getSortedLines();
        
        assertTrue(output.length == 5);
        assertEquals("Fire Harry Potter and The Goblet of", output[0]);
        assertEquals("Goblet of Fire Harry Potter and The", output[1]);
        assertEquals("Harry Potter and The Goblet of Fire", output[2]);
        assertEquals("Potter and The Goblet of Fire Harry", output[3]);
        assertEquals("The Goblet of Fire Harry Potter and", output[4]);
	}
}
