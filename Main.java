package Geeks.String;

import java.util.Arrays;

// this class is just for practicing newly learned things in String
public class Main {
	
	public static void charsIndex(String str, String str2) {
		
		// it is sometimes a better idea to take an empty array of the size equal to 
		// total number of ASCII characters
		int [] hash = new int[256];
		int [] hash2 = new int[256];
		
		int len = str.length()>str2.length()?str2.length():str.length();
		
		for(int i=0;i<len;i++) {
			hash[str.charAt(i)]++;
			hash2[str2.charAt(i)]++;
		}
		
		/*
		 * the above code increments the counter by the occurrence of a character within the string
		 */
		
		System.out.println(Arrays.toString(hash)+"\n"+Arrays.toString(hash2));
	}
	
	public static void main(String[] a) {
		charsIndex("bharadwaj", "melenie");
		
	}

}
