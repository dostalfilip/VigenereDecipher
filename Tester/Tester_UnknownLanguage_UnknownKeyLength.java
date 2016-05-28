package Tester;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

import VigenereCipher.VigenereBreaker;
import edu.duke.DirectoryResource;
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
		/*
		VigenereBreaker breaker = new VigenereBreaker();
		FileResource fr = new FileResource("././Dictionaries/English");
		HashSet<String> dic = breaker.readDictionary(fr);
		System.out.println(breaker.mostCommonCharIn(dic));
		*/
		/*
		 * testing breakForAllLanguages method
		 */
		VigenereBreaker breaker = new VigenereBreaker();
		FileResource encrypted = new FileResource("././Data/athens_keyflute.txt");
		
		HashMap<String,HashSet<String>> languages = new HashMap<String,HashSet<String>>();
		DirectoryResource dic = new DirectoryResource();
		for(File input : dic.selectedFiles()){
			FileResource temp = new FileResource(input);
			HashSet<String> tempHashSet = new HashSet<String>();
			for(String t : temp.words() ){
				tempHashSet.add(t);
			}
			//System.out.println(input.toString().substring(94)); // test
			languages.put(input.toString().substring(94), tempHashSet);
		}
		
		String finish = breaker.breakForAllLanguages(encrypted.asString(), languages);
		System.out.print(finish);
	}

}
