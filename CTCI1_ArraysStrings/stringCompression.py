"""
String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z). 
"""
""" SOLUTIONS:
1. Go thru string, keep a 'letter' and 'count' var, that reset when letter changes 
	and upon change, add themselves to a list of "compressions" (i.e. ["a3", "b2",...])
	Then join the list to a string. -- O(N)
"""

def stringCompression(string):
	letter = string[0]
	count = 1
	compressions = []
	for c in string[1:]:
		if letter == c:
			count+=1
		else:
			compressions.append(letter + str(count))
			letter = c
			count = 1
	compressions.append(letter + str(count))

	compressed = "".join(compressions)
	return compressed if len(compressed) < string else string

# OFFICIAL SOLUTION
# better handling of edge cases by using index looping rather than char looping, and no letter var
"""
	compressed = []
    counter = 0

    for i in range(len(string)):
        if i != 0 and string[i] != string[i - 1]:
            compressed.append(string[i - 1] + str(counter))
            counter = 0
        counter += 1

    # add last repeated character
    compressed.append(string[-1] + str(counter))

    # returns original string if compressed string isn't smaller
    return min(string, ''.join(compressed), key=len)
"""

if __name__ == '__main__':
	print stringCompression("aabcccccaaa")

