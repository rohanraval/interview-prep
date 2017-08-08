/* Given input of brackets (paren, square, curly, etc) validate whether it has correct matching
 	ie. [{([])}] is valid but [{([}])} is NOT
*/

#include <iostream>
#include <stack>
using namespace std;

bool validate_paren(char* input, int input_length) {

	stack<char> myStack;

	for(int i = 0; i < input_length; i++) {
		if(input[i] == '(' || input[i] == '[' || input[i] == '{' ) {
			myStack.push(input[i]);
		}
		else if (input[i] == ')' || input[i] == ']' || input[i] == '}' ) {
			if(myStack.empty())
				return false;
			else if( matching (input[i], myStack.pop() ) {
				
			}
		}
	}

}

int main() {
	cout << "Please enter string:"
	string s;
	cin << s;
	bool isValid = validate_paren(s.c_str(), s.length);
	return 0;
}
