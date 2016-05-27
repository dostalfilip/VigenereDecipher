package Tester;

import java.util.HashSet;

import VigenereCipher.VigenereBreaker;
import edu.duke.FileResource;

public class Tester_UnknownLanguage_UnknownKeyLength {

	/*
	 * 	Finally, it is time to expand your program so that it can crack messages in other languages.
	 *	To accomplish this, you need to write two new methods and modify two methods you have
	 *	already written.
	 */
	public static void main(String[] args) {
		/*
		 * testing mostCommonCharIn method
		 */
		VigenereBreaker breaker = new VigenereBreaker();
		FileResource fr = new FileResource("././Dictionaries/English");
		HashSet<String> dic = breaker.readDictionary(fr);
		System.out.println(breaker.mostCommonCharIn(dic));
	}

}
