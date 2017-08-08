'''
Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
to create a binary search tree with minimal height. 

SOLUTION:
1. Recursive - make a minimal subtree from left and right of array, recursively
PROCESS:
1. Insert into the tree the middle element of the array.
2. Insert (into the left subtree) the left subarray elements.
3. Insert (into the right subtree) the right subarray elements. 
4. Recurse.
'''

def createMinimalSubtree(elements) {
    root = elements[len(elements)/2]
    root.left = createMinimalSubtree(elements[0, len(elements)/2])
    root.right = createMinimalSubtree(elements[(len(elements)/2)+1:])
}
