package Geeks.String;

import java.util.Comparator;

public class KeyComparator implements Comparator<Key>{
  public int compare(Key k1, Key k2) {
	  if(k1.freq < k2.freq)
		  return 1;
	  else if(k1.freq > k2.freq)
		  return -1;
	  return 0;
		  
  }
}
