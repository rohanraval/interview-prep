'''
Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
(that is, pop ( ) should return the same values as it would if there were just a single stack). 

IDEAS:
-   create a list of stacks(lists) that has a threshold input.
    push will push to top stack or create new one. pop will pop from top stack.
    create a list of sizes for each substack
'''

class SetOfStacks:
    def __init__(self, threshold):
        self.threshold = threshold
        self.stacks = [[]]
        self.sizes = [0]

    def top(self):
        return self.stacks[-1][-1]

    def push(self, item):
        if self.sizes[-1] < self.threshold:
            self.stacks[-1].append(item)
            self.sizes[-1]+=1
        else:
            self.stacks.append([item])
            self.sizes.append(1)
    
    def pop(self):
        self.stacks[-1].pop()
        self.sizes[-1]-=1
        if self.stacks[-1] == []:
            self.stacks.pop()
            self.sizes.pop()


if __name__ == '__main__':
    s = SetOfStacks(2)
    s.push(1)
    s.push(2)
    s.push(3)
    s.push(4)
    s.push(5)
    print s.stacks
    print s.sizes
    print s.top()
    s.pop()
    print s.top()
    print s.stacks
    print s.sizes
    #passes tests