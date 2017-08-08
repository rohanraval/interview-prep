"""
Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place? 
"""
""" SOLUTIONS:
1. Rotate = Transpose and then flip all columns. (If counter-clockwise rotation, then flip all rows.) 
	O(N^2) time.

"""
def rotateMatrix(matrix, n):

	# transpose: M(i,j) = M(j,i)
	# switch upper triangle with lower triangle, that determines loop length
	for i in range(n):
		for j in range(0, i):
			#swap M(i,j) with M(j,i)
			temp = matrix[i][j]
			matrix[i][j] = matrix[j][i]
			matrix[j][i] = temp
	
	# OR GO FUNCTIONAL: matrix = map(lambda x: list(x), zip(*matrix))

	# flip columns M(i,j) = M(i, N-1-j)
	for i in range(n):
		for j in range(n//2):
			temp = matrix[i][j]
			matrix[i][j] = matrix[i][n-1-j]
			matrix[i][n-1-j] = temp

	return matrix


if __name__ == '__main__':
	matrix = [ [1,2,3], [4,5,6], [7,8,9] ]
	print rotateMatrix(matrix, 3)