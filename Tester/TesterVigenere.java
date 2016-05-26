package Tester;

import VigenereCipher.VigenereCipher;
import edu.duke.FileResource;

public class TesterVigenere {

	public static void main(String[] args) {
		/*
		 * Testing VigenereCipher class
		 */
		String path = "././data/titus-small.txt";
		FileResource resource = new FileResource(path);
		
		int[] array = {1,2,5,1};
		VigenereCipher Obj = new VigenereCipher(array);
		String input = resource.asString();
		System.out.println(input);
		
		String outputCrypth = "";
		outputCrypth = Obj.encrypt(input);
		System.out.println(outputCrypth);
		
		String outputDecrypth = Obj.decrypt(outputCrypth);
		System.out.println(outputDecrypth);
		
		System.out.println(Obj.toString());
	}

}
