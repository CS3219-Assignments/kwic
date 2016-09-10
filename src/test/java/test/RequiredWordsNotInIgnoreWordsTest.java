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

public class RequiredWordsNotInIgnoreWordsTest {
	
	@Test
	public void testRequiredWordsNotInIgnoreWords(){
	
		List<String> inputs = new ArrayList<String>();
		inputs.add("Harry Potter and the Goblet of fire");
		
		WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
		wordsToIgnore.addWordToIgnore("potter");
	    wordsToIgnore.addWordToIgnore("harry");
	    
	    RequiredWords requiredWords = RequiredWords.getWordsRequired();
	    
	    String[] inputWordToRequire = {"potter", "fire"};
	   
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
        
        assertEquals("Fire harry potter And The Goblet Of", output[0]);    
	}
}
