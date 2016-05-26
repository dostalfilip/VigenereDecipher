package Tester;

import VigenereCipher.VigenereBreaker;
import edu.duke.FileResource;

public class TesterVigenereBreaker {
	/**
	 * TesterVigenereBreaker.class
	 * testing methods:
	 * 		sliceString
	 * 		tryKeyLength
	 * 		breakVigenere
	 */
	public static void main(String[] args) {
		System.out.println("Testing VigenereBreaker.class");
		/*
		 * Testing sliceString method
		 */
		//VigenereBreaker Obj = new VigenereBreaker();
		//String input = "abcdefghijklm";
		//System.out.println(Obj.sliceString(input, 3, 4));
		
		/*
		 * Testing  theKeyLenght method
		 */
		/*VigenereBreaker Obj = new VigenereBreaker();
		String key = "flute";
		String path = "././data/athens_keyflute.txt";
		FileResource resource = new FileResource(path);
		//System.out.println(resource.asString());
		String input2 = resource.asString();
		int[] output = Obj.tryKeyLength(input2, key.length(), 'e');
		String print = "{ ";
		for(int n : output){
			print += Integer.toString(n) + ", ";
		}
		print += "}";
		System.out.println(print);
		*/
		
		/*
		 * Testing breakVigenere method
		 */
		
		VigenereBreaker obj = new VigenereBreaker();
		obj.breakVigenere();
		
		
		
		
		
		
		
		
	}

}
