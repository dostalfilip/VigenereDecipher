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

    	for(int i = 1 ; i <= 100 ; i++){
    		VigenereCipher ObjDecrypt = new VigenereCipher(tryKeyLength(encrypted,i,'e'));
    		String temp = ObjDecrypt.decrypt(encrypted);
    		if(countWords(temp,dictionary) > mostWords){
    			decryption = temp;
    			mostWords = countWords(temp,dictionary);
    		}
    	}
    	return decryption;
    }
}

























