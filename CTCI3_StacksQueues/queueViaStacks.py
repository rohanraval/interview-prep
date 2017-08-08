'''
Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks. 

IDEAS:
-   Front and back-facing stacks <===|===> Only push to the front one, only pop from the back one.
    Not gonna work because of obvious reasons!
    
-   If we want to pop the oldest element, we have to pop the rest of the list into a
    temp stack, then pop the last element, and put the others back. To optimize for 
    scenarios with many pops in a row, we keep that other list until the next push.
'''

class queueViaStacks:
    def __init__(self):
        self.items = []
        self.temp = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        while(len(self.items)>1):
            self.temp.append(self.items.pop())
        popped = self.items.pop()
        while(len(self.temp)>0):
            self.items.append(self.temp.pop())
        return popped

if __name__ == '__main__':
    q = queueViaStacks()
    q.push(5)
    q.push(6)
    q.push(7)
    print q.items
    print q.temp 
    q.pop()
    print q.items
    print q.temp 
