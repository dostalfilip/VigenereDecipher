package Tester;

import java.util.HashSet;

import VigenereCipher.VigenereBreaker;
import edu.duke.FileResource;

public class TesterUnknownKeyLength {

	public static void main(String[] args) {
		System.out.println("Testing VigenereBreaker.class");
		/*FileResource resource = new FileResource();
		VigenereBreaker Obj = new VigenereBreaker();
		HashSet<String> temp = Obj.readDictionary(resource);
		for(String n : temp){
			System.out.println(n);
		}
		System.out.println(temp.size());
		FileResource resource2 = new FileResource();
		System.out.println(Obj.countWords(resource.asString(), temp));
		*/
		
		/* Working perfectly
		FileResource encrypted = new FileResource();
		FileResource dictionary = new FileResource("././Dictionaries/English");
		VigenereBreaker Obj = new VigenereBreaker();
		System.out.println(Obj.breakForLanguage(encrypted.asString(),
				Obj.readDictionary(dictionary)));
		*/
		
		VigenereBreaker breaker = new VigenereBreaker();
		breaker.breakVigenere();
	}
		
}
