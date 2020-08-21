package Geeks.String;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
 */
public class AdjacentCharAreNotSame {
  public static void rearrange(String str) {
	  int [] count = new int[26];
	  int n = str.length();
	  for(int i=0;i<str.length();i++)
		  count[str.charAt(i)-'a']++;
	  
	  System.out.println(Arrays.toString(count));
	  
	  PriorityQueue<Key> priority = new PriorityQueue<>(new KeyComparator());
	  int val = 0;
	  int counter = 0;
	 for(char c= 'a';c<='z';c++) {
		 val =  c - 'a';
		 if(count[val]>0) {
			 System.out.println(++counter);
			 priority.add(new Key(count[val], c));
		 }
	 }
	 
	 System.out.println(priority.size());
	 
	 // now str will be used to store result
	 str= "";
	// work as the previous visited element 
     // initial previous element be. ( '#' and 
     // it's frequency '-1' ) 
     Key prev = new Key(-1, '#');
     
     while(priority.size()!=0) {
    	 Key k = priority.peek();
    	 priority.poll();
    	 str+=k.character;
    	 System.out.println("str NOW:"+str);
    	 
    	 if(prev.freq>0)
    		 priority.add(prev);
    	 
    	 (k.freq)--;
    	 prev = k;
   }
     System.out.println("string result: "+str);
     if(n!=str.length())
    	 System.out.println("NOT VALID");
     else
    	 System.out.println("VALID");
  }
	public static void main(String[] args) {
		rearrange("aarbcd");

	}

}
