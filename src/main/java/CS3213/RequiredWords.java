package CS3213;

import java.util.HashSet;

public class RequiredWords {
		private HashSet<String> _requiredWords;
	    private static RequiredWords _instance;
	    
	    private RequiredWords() {
	        this._requiredWords = new HashSet<String>();
	    }

	    public static RequiredWords getWordsRequired() {
	        if (_instance == null) {
	        	_instance = new RequiredWords();
	        }

	        return _instance;
	    }
	    
	    public void addWordToRequire(String word) {
	       // assert(word != null);
	        //this._requiredWords.add(word);
	    }

	    public void removeWordToRequire(String word) {
	        //assert(word != null);
	        //this._requiredWords.remove(word);
	    }

	    public boolean isWordRequired(String word) {
	       // assert(word != null);
	        return this._requiredWords.contains(word);
	    }

	    public boolean isEmpty(){ return _requiredWords.size() == 0; }
}
