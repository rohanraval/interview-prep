/*
	Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
*/
/*
	Solution 1: 
	- An array where the index of the array represents the ASCII value of a letter. 
	- Go thru s1 and increment the counts in the array of all letters present in s1.
	- Go thru s2 and decrement the counts in the array of all letters present in s2,
		if we have to decrement past 0, then return false.

*/

public boolean checkPermutation(String s, String t) {
	if (s.length() != t.length) return false; //

	int[] count = new int[128]; //ascii rep

	// loop thru s
	for(int i=0; i < s.length(); i++ ) {
		int index = (int)s.charAt(i);
		count[index]++;
	}
	//loop thru t
	for(int i=0; i < t.length; i++ ) {
		int index = (int)t.charAt(i);
		count[index]--;
		if(count[index] < 0)
			return false;
	}
	return true;
}