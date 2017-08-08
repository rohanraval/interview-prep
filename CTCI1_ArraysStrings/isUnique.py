"""
Is Unique: Implement an algorithm to determine if a string has all unique characters.
"""
"""
Solutions:
1. Use a list of size x, where x represents all possible allowed char's.
	Go through the chars of the string. 
	For each char, find the corresponding index of its ascii val and flip it.
	If we try to flip a flipped bit, return false.
	O(N) time, O(1) space.
2. Compare every char with every other char. O(N^2)
3. Use hashmap. First pass, store all into hashmap based on ascii (hash function).
	If collision, return false. Too similar to 1. O(N) time, O(1) space
"""

# Solution 1
def isUnique(string, maxAllowed):

	if len(string) > maxAllowed
		return False

	listOfChars = [0 for _ in range(maxAllowed)]
	for char in string:
		if listOfChars[ord(char)] == 1:		# ord(char) returns Unicode value of char
			return False
		listOfChars[ord(char)] = 1

	return True
