

import java.util.Comparator;

// Class Data

public class Data {
	String word;
	int freq;
	
	public Data (String item){
		  this.word =item;
		  this.freq=1;
		}
	
	public String getWord() {
        return word;
   }
	
	public void setWord(String newword) {
		this.word= newword;
	    }
	
	public int getFreq() {
		return freq;
	    }
	   
	public void setFreq(int freq2) {
		this.freq = freq2;
	    }
	
	public static Comparator<Data> WordComparator = new Comparator<Data>()
	{ 
	    // Used for sorting in ascending order of word
	    public int compare(Data a, Data b) 
	    { 
	    	String word1 = a.getWord();
	 	    String word2 = b.getWord();
	 	    
	        return (word1).compareTo(word2); //string1.compareTo(string2)
	    } 
	};
}