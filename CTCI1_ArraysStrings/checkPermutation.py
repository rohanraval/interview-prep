"""
Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
"""
"""
Solutions:
1. For each element in string 2, check if it is in string 1. account for multiple instances
	of the same char. NOT OPTIMAL - O(N^2), possibly more.
2. Hashmap - give each char a bin in the map. If multiple instances, link it.
3. OPTIMIZED 1. For each in string2, check if in string1. If so, remove from string1.
	If one of them empty before the other, then not a permutation.
4. SORT BOTH. Then compare.
"""

# Solution 3
	# O(NX) , where N and X are the lengths of the strings = O(N^2) for same length
def permutation(string1, string2):
	if (string1 == "" and string2 != "") or (string2 == "" and string1 != ""):
		return False

	for char in string2:
		if string1 == "":
			return False
		if string1.contains(char):
			string1.replace(char, "")

		return string1 == "" and string2 != "" 
#doesnt work for uneven sizes - but permuations have to be same size!
# not sure if this solution is correct.... EDGE CASE CHECK!

""" Solution 5: 
	- An array where the index of the array represents the ASCII value of a letter. 
	- Go thru s1 and increment the counts in the array of all letters present in s1.
	- Go thru s2 and decrement the counts in the array of all letters present in s2,
		if we have to decrement past 0, then return false.
"""
from collections import Counter

def permutation(string1, string2):
	if len(string1) != len(string2):
		return False

	counter = Counter()  # or counter = []*128
	for i in string1:
		counter[i]+=1

	for j in string2:
		counter[j]-=1
		if counter[j] < 0:
			return False

	return True
