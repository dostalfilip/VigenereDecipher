package VigenereCipher;

import java.util.*;

import CaesarCipher.CaesarCracker;
import edu.duke.*;
/***
 * 
 * @author Filip Dostal
 *
 */
public class VigenereBreaker {
	/**
	 * 
	 * @param message representing the encrypted message.
	 * @param whichSlice indicating the index the slice should start from.
	 * @param totalSlices indicating the length of the key.
	 * @return 	String consisting of every totalSlices the character from message,
				starting at the whichSlice the character.
	 */
    public String sliceString(String message, int whichSlice, int totalSlices) {
        String output = "";	
        String input = message.substring(whichSlice); // cut begining
        
        /*
         * cut per the lenght of key
         */
        while(input.length() > totalSlices){
        	output += input.charAt(0);
        	input = input.substring(totalSlices);
        }
        
        // add last letter
        output += input.charAt(0);
        return output;
    }

    /**
     * 
     * @param encrypted that represents the encrypted message
     * @param klength that represents the key length
     * @param mostCommon that indicates the most common character in the language of the message
     * @return find the shift for each index in the key
     */
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cracker = new CaesarCracker(mostCommon);
        for(int i = 0; i < klength; i++){
        	key[i] = cracker.getKey(sliceString(encrypted, i, klength));
        }
        return key;
    }
    /**
     * This void method should put everything together.
     */
    public void breakVigenere () {
		FileResource decrypt = new FileResource();
		FileResource dictionary = new FileResource("././Dictionaries/English");
		VigenereBreaker Obj = new VigenereBreaker();
		System.out.println(Obj.breakForLanguage(decrypt.asString(),
				Obj.readDictionary(dictionary)));
    }
    
    /**
     * 
     * @param fr FileResource
     * @return HashSet of word from dictionary
     */
    public HashSet<String> readDictionary(FileResource fr){
    	HashSet<String> dictionary = new HashSet<String>();
    	for(String n : fr.words()){
    		dictionary.add(n);
    	}
    	return dictionary;
    }

    /**
     * 
     * @param message String
     * @param dictionary a HashSet of Strings dictionary
     * @return the integer count of how many valid words it found.
     */
    public int countWords(String message, HashSet<String> dictionary){
    	int output = 0;
    	String[] temp = message.split("\\W");
    	for(String n : temp){
    		if(dictionary.contains(n)){
    			output++;
    		}
    	}
    	return output;
    }
    
    /**
     * 	This method should figure out which decryption gives the largest count of real
	 *	words, and return that String decryption.
     * 
     * @param encrypted
     * @param dictionary
     * @return
     */
    public String  breakForLanguage(String encrypted, HashSet<String> dictionary){
    	String decryption = "";
    	int mostWords = 0;
    	char mostCommon = mostCommonCharIn(dictionary);

    	for(int i = 1 ; i <= 100 ; i++){
    		VigenereCipher ObjDecrypt = new VigenereCipher(tryKeyLength(encrypted,i,Character.toLowerCase(mostCommon)));
    		String temp = ObjDecrypt.decrypt(encrypted);
    		if(countWords(temp,dictionary) > mostWords){
    			decryption = temp;
    			mostWords = countWords(temp,dictionary);
    		}
    	}
    	return decryption;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){
    	HashMap<Character, Integer> myMap = new HashMap<Character, Integer>(); 
    	hashIntialization(myMap);
    	/*
    	 * Lambda in action
    	 */
    	dictionary.forEach(ch -> counter(ch,myMap));
    	
    	int top = 0;
    	char output = 0;
    	for(char n : myMap.keySet()){
    		int curr = myMap.get(n);
    		if(curr > top){
    			top = curr;
    			output = n;
    		}
    	}
    	
    	return output;
    }
    
    /**
     * initialization of anaplhabet
     * @param myMap
     */
    private void hashIntialization(HashMap<Character, Integer> myMap){
    	String analphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	for(int i = 0 ; i < analphabet.length() ; i++){
    		myMap.put(analphabet.charAt(i), 0);
    	}
    }
    
    /**
     * This method count each letter in word, add them to the hash map
     * @param word string
     * @param myMap HashMap
     */
	private void counter(String word, HashMap<Character, Integer> myMap ){
		word = word.toUpperCase();
		for(int i = 0; i < word.length(); i++){
			char curr = word.charAt(i);
			if(myMap.containsKey(curr)){
				myMap.put(curr, myMap.get(curr) + 1 );
		
			}
		}
	}

	
	public String breakForAllLanguages(String encrypted, HashMap<String,HashSet<String>> languages){
		String[] toProceed = new String[languages.size()];
		ArrayList<String> dictioKey = new ArrayList<String>();
		for(String key : languages.keySet()){
			dictioKey.add(key);
		}

		for(int i = 0; i<languages.size(); i++){
			toProceed[i] = breakForLanguage(encrypted,languages.get(dictioKey.get(i)));
			
		}
		/*
		 * Find the best output
		 */
		int top = 0;
		String output = "";
		for(int find = 0; find < languages.size(); find++){
			if(countWords(toProceed[find],languages.get(dictioKey.get(find))) > top){
				top = countWords(toProceed[find],languages.get(dictioKey.get(find)));
				output = toProceed[find];
			}
		}
		
		return output;
	}
}























