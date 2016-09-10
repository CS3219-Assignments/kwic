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
		inputs.add("Catching a pokemon call pikachu is very good");
		
		WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
		wordsToIgnore.addWordToIgnore("is");
	    wordsToIgnore.addWordToIgnore("very");
	    
	    RequiredWords requiredWords = RequiredWords.getWordsRequired();
	    
	    String[] inputWordToRequire = {"is", "pikachu"};
	   
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
        
        assertTrue(output.length == 1);
        assertEquals("Pikachu is very Good Catching A Pokemon Call", output[0]);    
	}
}
