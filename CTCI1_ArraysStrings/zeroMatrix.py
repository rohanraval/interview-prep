"""
Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to O. 
"""
""" SOLUTIONS:
1. Go thru and record (x,y) of each zero in matrix. Then go through this and set appropriate
	rows and cols to zero.
"""

#S1
def zeroMatrix(matrix):

	listOfZeroes = []

	for m in range(len(matrix)):
		for n in range(len(matrix[m])):
			if matrix[m][n] == 0:
				listOfZeroes.append((m,n))

	for (x,y) in listOfZeroes:
		#nullify rows by going thru each column of that row and deleting
		for col in range(len(matrix[0])):
			matrix[x][col] = 0
		#nullify cols by going thru each row of that col and deleting
		for row in range(len(matrix)):
			matrix[row][y] = 0
				
	print listOfZeroes
	return matrix

# OFFICIAL SOLUTION: separates listOfZeroes into two lists, rows and cols, instead of list of tuples

if __name__ == '__main__':
	print zeroMatrix( [ [1,2,3], [4,5,6], [7,8,0] ] )