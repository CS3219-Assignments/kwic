package test;

import CS3213.Alphabetizer;
import CS3213.CircularShift;
import CS3213.RequiredWords;
import CS3213.WordsToIgnore;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
	
	@Test
	public void TestRequireWordsNotInIgnoreWords(){
	
		List<String> inputs = new ArrayList<String>();
		inputs.add("Harry Potter and the Goblet of fire");
		
		WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
		wordsToIgnore.addWordToIgnore("the");
	    wordsToIgnore.addWordToIgnore("of");
	    
	    RequiredWords requiredWords = RequiredWords.getWordsRequired();
	    
	    String[] inputWordToRequire = {"the", "fire"};
	   
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
        assertEquals("Fire Harry Potter And the Goblet of", output[0]);    
	}
}
