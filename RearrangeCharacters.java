package Geeks.String;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/rearrange-the-characters-of-the-string-such-that-no-two-adjacent-characters-are-consecutive-english-alphabets/?ref=rp
 */
public class RearrangeCharacters {
public static void rearrange(String str) {
	String odd="";
	String even = "";
	for(int i=0;i<str.length();i++) {
		if(str.charAt(i)%2==0)
			even+=str.charAt(i);
		else
			odd+=str.charAt(i);
	}
	odd= sort(odd);
	even=sort(even);
	 
	if(check(odd+even))
		System.out.println("result: "+odd+even);
	else if(check(even+odd))
		System.out.println("result: "+even+odd);
	else
		System.out.println("NOT POSSIBLE");
}

public static boolean check(String str) {
	for(int i=0;i+1<str.length();i++) {
		if(Math.abs(str.charAt(i)-str.charAt(i+1))==1)
			return false;
	}
	return true;
}

public static String sort(String input) {
	char [] arr = input.toCharArray();
	Arrays.sort(arr);
	return new String(arr);
}
	public static void main(String[] args) {
		rearrange("aaadcb");

	}

}
