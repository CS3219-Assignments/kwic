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

public class NoRequireWordsTest {
	
	@Test
	public void TestNoRequireWords(){
	
		List<String> inputs = new ArrayList<String>();
		inputs.add("Harry Potter and the Goblet of fire");
		
		WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
		wordsToIgnore.addWordToIgnore("the");
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
        assertEquals("And the Goblet of Fire Harry Potter", output[0]);
        assertEquals("Fire Harry Potter And the Goblet of", output[1]);
        assertEquals("Goblet of Fire Harry Potter And the", output[2]);
        assertEquals("Harry Potter And the Goblet of Fire", output[3]);
        assertEquals("Potter And the Goblet of Fire Harry", output[4]);
	}
	
}
