"""
Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards.
A permutation is a rearrangement of letters.
The palindrome does not need to be limited to just dictionary words.
"""
"""
Solutions:
1. Get all permutations of string - O(N!). Go thru and check whether each are palindromes.
	If one of them is, then true. WORST CASE
2. For it to possibly be a palindrome (permutated), it has to have symmetrical letters.
	So if string is even length, then it has to have an even count for all letters.
	If string odd in length, then it has to have an even count for all letters except one.
"""

#Solution 2 TRY
from collections import Counter

def palindromePermutation(string):

	counter = Counter()

	for i in string:
		counter[i]+=1

	values = list(dict(counter).values())

	#FUNCTIONAL PROGRAMMING APPROACH
	odd_values = list(filter( lambda x: x%2 != 0 , values )) #filter out all the evens, incl. zeroes

	if len(string) % 2 == 0:
		return len(odd_values) == 0
	else:
		return len(odd_values) == 1

if __name__ == '__main__':
	print palindromePermutation("abcabcqe")


# OTHER APPROACHES
""" 
odd = 0
for v in values:
	if (len(string)%2 == 0) && (v%2 != 0):
		return false
	if v%2 != 0:
		odd+=1

if len(string)%2 == 0:
	return true
if odd == 1:
	return true
"""
# MORE READABLE, LESS CORRECT SYNTAX
"""
odd = 0
if( len(string) % 2 == 0 ):
	return false for v in values if(v%2 != 0)
	return true
else:
	odd+=1 for v in values if (v%2 != 0)
	return odd == 1
"""