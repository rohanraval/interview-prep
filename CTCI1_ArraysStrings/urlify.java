/*
URLify: Write a method to replace all spaces in a string with '%20': 
You may assume that the string has sufficient space at the end to hold the additional characters, 
and that you are given the "true" length of the string.
*/

public String urlify(char[] str, int trueLength) {

	int numSpaces = 0;
	// first pass - get number of spaces
	for (int i=0; i < trueLength; i++) {
		if(str[i] == ' ') 
			numSpaces++;
	}

	//get the new length of char[] (after '%20''s are added)
	totalLength = trueLength + (numSpaces*2);

	str[totalLength] = '\0'; //put a terminator at the end of our char[]

	for(int i = trueLength-1; i >= 0; i--) {
		if(str[i] == ' ') {
			str[totalLength-1] = '0';
			str[totalLength-2] = '2';
			str[totalLength-3] = '%';
			totalLength -= 3;
		}
		else {
			str[totalLength-1] = str[i];
			totalLength -= 1;

		}
	}
	return str; //not sure what return type is expected
}