"""
String Rotation: Assume you have a method isSubstring which checks if one word is a substring
of another. Given two strings, S1 and S2, write code to check if S2 is a rotation of S1 using only one
call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat"). 
"""
""" SOLUTIONS:
Hints:
	- If a string is a rotation of another, then it's a rotation at a particular point.
	- We are essentially asking if there's a way of splitting the first string into two parts, x and
	y, such that the first string is xy and the second string is yx. 
	-  think about what happens when you concatenate the string to itself.

1. Concatenate the string to itself. The other string should be a substring of that. 
	s1 can be split into two substrings, x and y, s.t. s1 = x+y
	If s2 is a rotation of s1, then s2 = y+x
	Now, s1+s1 = (x+y)+(x+y) = x+(y+x)+y = x+s2+y
	Therefore, we only need to check if s2 is a substring of s1, because 
	only if it's a rotation then it will be in that form.
"""

#Sol.1
def isSubstring(a, b):	#assume this is given; checks if a is substring of b
	return a in b

def stringRotation(s1, s2):
	return isSubstring(s2, s1+s1)

if __name__ == '__main__':
	print stringRotation('waterbottle', 'erbottlewat')