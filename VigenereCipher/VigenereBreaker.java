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
    	FileResource source = new FileResource();
    	String input = source.asString();
    	int[] key = tryKeyLength(input, 5, 'e');
    	VigenereCipher cipher = new VigenereCipher(key);
    	System.out.print(cipher.decrypt(input));
    }
    
}














