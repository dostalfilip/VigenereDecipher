package Tester;

import java.io.FileReader;

import CaesarCipher.CaesarCipher;
import CaesarCipher.CaesarCracker;
import edu.duke.*;

public class TesterCaesar {
	
	/*
	 * Testing CaesarCipher.class and CaesarBreaker.class
	 */

	public static void main(String[] args) {
	/*
	 * Test CaesarCipher	
	 */
		String path = "././data/titus-small.txt";
		FileResource resource = new FileResource(path);
		CaesarCipher OBJ  = new CaesarCipher(8);
		String encrypth = OBJ.encrypt(resource.asString());
		System.out.println(encrypth);
		System.out.println(OBJ.decrypt(encrypth));

	/*
	 * Test CaesarCracker	
	 */
		CaesarCracker BREAK = new CaesarCracker();
		int key = BREAK.getKey(encrypth);
		System.out.println(key);
		System.out.println(BREAK.decrypt(encrypth));
		
	/*
	 * Test Decrypth lusiadas_key17.txt	
	 * CaesarCrack class uses constructor with parameter (most used letter at analphabet)
	 */
		CaesarCracker BREAK2 = new CaesarCracker('a');
		FileResource resource2 = new FileResource("././data/oslusiadas_key17.txt");
		System.out.println(
				BREAK2.getKey(
						resource2.asString()));
		System.out.println(
				BREAK2.decrypt(
						resource2.asString()));
	}

}
