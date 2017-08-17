/*
Random Node: You are implementing a binary tree class from scratch which, in addition to
insert, find, and delete, has a method getRandomNode() which returns a random node
from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
for getRandomNode, and explain how you would implement the rest of the methods. 
*/

/* BRUTE FORCE SOLUTION - Traverse entire tree, copying all nodes into array. 
    Then return the node at a random index in that array. O(N) time, O(N) space. 
*/

/* OPTIMAL SOLUTION - Modify the Node class to track the 'size' (# of nodes in its subtree).
    Each node from the root should have an equal prob of being returned, so getRandomNode recursively
    generates a random number less than the size of this Node. 
    If that number is less than the left subtree's size, then we recurse for the left subtree.
    If it is equal to the left subtree's size, then we return the current node.
    If it is greater than the left subtree's size, then we recurse for the right subtree.
    This way, the probability of each node is equal. 
    This runs in O(log N) time, since it doesn't have to visit every node in the tree.

*/

class Node {
    private int data;
    public Node left;
    public Node right;
    private int size = 0; //new field to track size

    //constructor
    public Node (int data) {
        this.data = data;
        this.size = 1;
    }

    //get random node
    Node getRandomNode() {
        int leftSize = (this.left == null) ? 0 : this.left.size;
        int random = (int)(Math.random() * size); //get a random # in the range of this tree's size

        if (random < leftSize) {
            return this.left.getRandomNode();
        } else if (random == leftSize) {
            return this;
        } else {
            return this.right.getRandomNode();
        }
    }
}