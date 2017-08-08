""" 
URLify: Write a method to replace all spaces in a string with '%20': 
You may assume that the string has sufficient space at the end to hold the additional characters, 
and that you are given the "true" length of the string.
"""
"""
Solutions:
1. use python replace function - NOT AN IN-PLACE SOLUTION
2. use python enumerate on string (which is a char[]) to make it into a (k,v) dict.
	Create a string. Then go through and add each v to the string, and if it's a 
	space, then add '%20' instead of v - NOT AN IN-PLACE SOLUTION
3. start from end, for-loop back and replace - keep two 'pointers', 
	runner from back and one at last acutal letter
"""

# solution 3
	# param string: char[]
	# param trueLength: int
def urlify(string, trueLength):

	totalLength = len(string)

	for i in reversed(range(trueLength)):
		if string[i] == ' ':
			string[totalLength-3:totalLength] = '%20'
			totalLength -= 3
		else:
			string[totalLength] = string[i]
			totalLength -= 1

	return string