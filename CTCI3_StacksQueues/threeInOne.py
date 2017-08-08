'''
Three in One: Describe how you could use a single array to implement three stacks. 

IDEAS:
- Single array for single stack:
	Push to end of array, and pop from end of array (constant time).
	Here, the end of the array is the top.
- Can allocate the first third of array to first stack, second third to second stack,...
	Need to keep an array containing the three stacks, and an array containing the sizes of each.
	However, this is less flexible. What if one stack is much bigger than others?
- Can make array 'wrap around' so that, e.g. if elements are popped from the first	
	array, we can let the other two use that space. 
'''
'''FIXED-SIZE SOLUTION'''
class multiStack:
	def __init__(self, stackSize):
		self.stackSize = stackSize; #size of each stack
		self.numStacks = 3; #number of stacks (can be variable)
		self.array = [0]*(self.stackSize * self.numStacks) #array containing the stacks
		self.sizes = [0]*(self.stackSize) #keep track of the sizes of each stack in the array

	def push(self, item, stackNum):
		if self.sizes[stackNum] < self.stackSize:
			self.array[(self.stackSize*stackNum)+(self.sizes[stackNum])] = item
			self.sizes[stackNum]+=1
		else:
			raise Exception('stack full!')
	
	def pop(self, stackNum):
		if isEmpty(stackNum):
			raise Exception('stack empty!')
		else:
			value = self.array[(self.stackSize*stackNum)+(self.sizes[stackNum])]
			self.array[(self.stackSize*stackNum)+(self.sizes[stackNum])] = 0
			self.sizes[stackNum]-=1
			return value

	def top(self, stackNum):
		if isEmpty(stackNum):
			raise Exception('stack empty!')
		else:
			return self.array[(self.stackSize*stackNum)+(self.sizes[stackNum])]

	def isEmpty(stackNum):
		return self.sizes[stackNum] == 0

'''
FLEXIBLE (WRAP-AROUND) SOLUTION
- too complex for interview
'''