'''
 Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). The stack supports the following operations: push, pop, peek, and isEmpty. 
'''

def sort (s1):
    s2 = stack()
    while !s1.isEmpty():
        temp = s1.pop()
        while (!s2.isEmpty()) and (s2.peek() > temp):
            s1.push(s2.pop())
        s2.push(temp)
        
    while !s2.isEmpty():
        s1.push(s2.pop())
