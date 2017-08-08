/*
	convert string to int
	Input = '123'
	Output = 123
*/

int str2int(String str) {
	int result = 0;
	for(int i = 0; i < str.length(); i++) {
		result = result * 10 + (charAt(i) - (int)'0');
	}
}

//result = 0 * 10 + 1 = 1, = 1 * 10 +
