"""
One Away: There are three types of edits that can be performed on strings: 
INSERT a character, REMOVE a character, or REPLACE a character. 
Given two strings, write a function to check if they are one edit (or zero edits) away. 
"""
""" SOLUTIONS:
1. FUNCTIONAL! filter out the common ones from both strings.
	If there is one (or 0) char remaining in either (or both), then return true.
	O(N^2) time -- sucks :(
2. OFFICIAL SOLUTION. explained and implemented below.
"""
def oneAway(s1, s2):
	# if lengths equal, then check if it's one replace away
	if len(s1) == len(s2):	
		return is_replace(s1, s2)
	# if s1 is one smaller than s2, then see if s1 is one insert away from s2
	elif (len(s1) + 1) == len(s2):
		return is_insert(s1, s2)
	# if s1 is one bigger than s2, then see if s2 is one insert away from s1
	elif (len(s2) - 1) == len(s2):
		return is_insert(s2, s1)
	# else they are more than one edit away
	return False

# checks if a and b are different in only one character
def is_replace(a, b):
	# Go thru both strings in one loop; keep a boolean flag that is set when there's a difference. 
	# If it tries to get set again, then there's more than one difference.
	different = False

	# go thru two strings in parallel
	# zip returns list of tuples -- zip(a,b) = [ (a[i], b[i]) for i in min(a,b) ]
	for c1, c2 in zip(a, b):	# can also be done by index: for i in range(len(a)) using a[i], b[i]
		if c1 != c2:
			if different:
				return False
			different = True 
	return True

# Can one char be inserted into a to get b? ( len(a) < len(b) by 1 char )
def is_insert(a, b):
	# Go thru both strings in one loop; keep a boolean flag that is set when there's a difference.
	# If it tries to get set again, then there's more than one difference.
	different = False

	# Go thru both strings in parallel
	i = 0
	j = 0
	while i < len(a) and j < len(b):
		# if both pointers are equal, then increment both
		if a[i] == b[i]:
			i+=1
			j+=1
		# if one of them is different, check whether different flag has already been raised
			# if so, then this is not the first place where they are different, so return False
			# else, increment the second string's pointer and raise the different flag
		else:
			if different:
				return False
			else:
				j+=1
				different = True
	return True
