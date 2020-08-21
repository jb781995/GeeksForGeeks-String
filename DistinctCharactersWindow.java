package Geeks.String;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
 */
public class DistinctCharactersWindow {
	private static final int chars = 256;
public static void distinctChars(String str) {
	int [] hash = new int[chars];
	int [] result = new int [str.length()];
	String uniqueStr = "";
	for(int i=0;i<str.length();i++)
		hash[str.charAt(i)]++;
	
	//this is the count of unique characters in the given string
    int len=0;
	for(int i=0;i<hash.length;i++) {
		if(hash[i]!=0) {
			len++;
			char ch = (char)i;
			uniqueStr+=ch;
		}
	}
	System.out.println(Arrays.toString(hash)+"\nNumber of unique characters: "+len);
	
	
	System.out.println("unique string: "+uniqueStr);
	
	int start =0, start_len=-1, min_len=Integer.MAX_VALUE, count=0;
	int [] curr_count = new int [chars];
	for(int i=0;i<str.length();i++) {
		curr_count[str.charAt(i)]++;
		
		if(curr_count[str.charAt(i)]==1)
			count++;
		
		if(count == len) {
			System.out.println("Yeah, found all unique chars..\n"+Arrays.toString(curr_count)+"\n");
			while(curr_count[str.charAt(start)]>1) {
				
				if(curr_count[str.charAt(start)]>1) {
					System.out.println("inspecting...    "+str.charAt(start)+", now it'll be decremented by 1");
					curr_count[str.charAt(start)]--;
				}
				start++;
			}
			int len_win = i-start+1;
			if(min_len > len_win) {
				min_len = len_win;
				start_len = start;
			}
		}
	}
	
	
}
	public static void main(String[] args) {
		String str = "aabcbcdbca";
		distinctChars(str);

	}

}
