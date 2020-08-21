package Geeks.String;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 */
public class SmallestWindows {
	private static final int no_of_chars = 256;
  public static String smallestWindow(String str, String pat) {
	  int len1 = str.length();
	  int len2 = pat.length();
	  
	  int hash_pat [] = new int[no_of_chars];
	  int hash_str [] = new int[no_of_chars];
	  
	  //to store the count of characters in pattern at the index according to the ASCII code
	  for(int i=0;i<pat.length();i++)
		  hash_pat[pat.charAt(i)]++;
	  
	 int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;
	 int count =0 ;
	 for(int j=0;j<len1;j++) {
		 // to store the count of characters in string at the index according to the ASCII code
		 hash_str[str.charAt(j)]++;
		 
		// If string's char matches with pattern's char 
         // then increment count 
		 if(hash_pat[str.charAt(j)]!=0 && hash_str[str.charAt(j)]<= hash_pat[pat.charAt(j)])
			 count++;
		 
		 // if all characters are matched
		 if(count == len2){
			 // if occurrence of a character in string is more than occurrence of the same character in
			 // pattern, then reduce it. also check if the current character from the string occurs in 
			 // pattern. if NO, then remove it
			 while(hash_str[str.charAt(start)]> hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)]==0) {
				 if(hash_str[str.charAt(start)]> hash_pat[str.charAt(start)])
					 //reduce the extra occurrences count from the hash_str
					 hash_str[str.charAt(start)]--;
				 start++;
			 }
			 
			 int len_win = j- start+1;
			 if(min_len > len_win) {
				 min_len = len_win;
				 start_index = start;
			 }
		 }
		 
	 }
	 
	 // if no window found
	 if(start_index ==-1) {
		 System.out.println("No window found");
		 return "";
	 }
	 
	 return str.substring(start_index, start_index+min_len);
		 
	  
  }
	public static void main(String[] args) {
		String str= "this is a test";
		String pat = "tsit";
		smallestWindow(str,pat);
	}

}
