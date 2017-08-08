'''
Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time. 

IDEAS:
1.  Keep a separate variable, minElement, in the stack class
    However, this will not work, because it will make pop not constant time
    When we pop the min element, we will have to do a constant-time search to set the new min.
2.  Let the stack class keep one list for storing items and one for storing mins
    This way, when a new element is added, the mins list adds that element if its lower than the last element of mins,
    else, appends the last min again. This way, each element of mins represents the min of the items stack below it 
'''

class stackNode:
    def __init__(self, data):
        self.data = data
    
class stack:
    def __init__(self):
        self.items = []
        self.mins = []

    def isEmpty(self):
        return self.items == []

    def push(self, item):
        self.items.append(item)
        if self.mins == [] or item.data < self.mins[-1]: 
            self.mins.append(item.data)
        else:
            self.mins.append(self.mins[-1])

    def pop(self):
        self.mins.pop()
        return self.items.pop()

    def top(self):
        return self.items[-1]

    def getMin(self):
        return self.mins[-1]


if __name__ == "__main__":
    stax = stack()
    stax.push(stackNode(5))
    stax.push(stackNode(6))
    stax.push(stackNode(7))
    print stax.mins
    print stax.getMin()
    stax.push(stackNode(3))
    print stax.getMin()
    stax.pop()
    print stax.mins
    print stax.getMin()
    #passes tests