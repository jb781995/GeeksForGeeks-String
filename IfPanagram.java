package Geeks.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/missing-characters-make-string-pangram/
 */
public class IfPanagram {
  public static String missingCharacters(String str) {
	  List<Integer> characters = new ArrayList<Integer>();
	  int[] present = new int[26];
	  String result = "";
	  str = str.toLowerCase();
	  for(int i=0;i<str.length();i++) {
		  if(str.charAt(i)>='a' && str.charAt(i)<='z') {
			  present[str.charAt(i)-'a'] = str.charAt(i);
		  }
	  }

	  
	for(int i=0;i<present.length;i++) {
		if(present[i] == 0)
			characters.add(i+'a');
	}
		/*
		 * for(Integer i : characters) result+=Character.toString(i);
		 */
	
	if(characters.size()>=2)
		result = "might be a LIPOGRAM";
	else if(characters.size()==1)
		result = "PANGRAMMATIC LIPOGRAM";
	else
		result = "PANGRAMMATIC";
	
	return result;
	
  }
	public static void main(String[] args) {
	/*
	 * "The quick brown fox jumps over the dog"; 
	 */
System.out.println(missingCharacters("The quick brown fox jumps"));
	}

}
