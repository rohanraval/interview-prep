
public string multiplyStrings(string s1, string s2) {

	string smaller = (s1.length() < s2.length()) ? s1 : s2;
	string bigger = (s1.length() >= s2.length()) ? s1 : s2;

	int product = 0;
	int carry = 0;

	string temp = "";
	int tempPos = 0;

	for(int i = smaller.length() - 1; i >= 0; i--) {
		for(int j = bigger.length() - 1; j >= 0; j--) {
			int prod = Integer.parseInt(smaller.charAt(i)) * Integer.parseInt(bigger.charAt(i));
			temp.charAt(tempPos) = prod % 10;
			tempPos++;
			carry =
		}

	}


}
