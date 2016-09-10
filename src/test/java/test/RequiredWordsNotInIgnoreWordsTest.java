package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sun.jmx.snmp.internal.SnmpSecuritySubSystem;

import CS3213.Alphabetizer;
import CS3213.CircularShift;
import CS3213.RequiredWords;
import CS3213.WordsToIgnore;
import javafx.util.converter.ShortStringConverter;
import sun.print.PSPrinterJob.PluginPrinter;

public class RequiredWordsNotInIgnoreWordsTest {
	
	@Test
	public void testRequiredWordsNotInIgnoreWords(){
	
		List<String> inputs = new ArrayList<String>();
		inputs.add("Pikachu is not a rat");
		
		WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
		wordsToIgnore.addWordToIgnore("pikachu");
	    
	    RequiredWords requiredWords = RequiredWords.getWordsRequired();
	    
	    String[] inputWordToRequire = {"pikachu", "rat"};
	   
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
        
        String[] outputs = alphabetizer.getSortedLines();
        
        assertEquals("Rat pikachu Is Not A", outputs[0]);    
       
	    
	    wordsToIgnore.removeWordToIgnore("pikachu");
	    
	    for (String requireWords: inputWordToRequire){
	    	if(!wordsToIgnore.isWordIgnored(requireWords)){
	    		requiredWords.removeWordToRequire(requireWords);
	    	}
	    }
	    
	    for (String str: outputs){
	    	alphabetizer.removeLines(str);
	    }
	 
	}
}
