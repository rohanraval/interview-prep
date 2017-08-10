/*
Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
binary search tree. You may assume that each node has a link to its parent. 
*/

/* SOLUTION 1
    successor(n) is the leftmost node of n's right subtree.
    If no right subtree, then...
        If n is the left child of n->parent, then the successor is n->parent
        If n is the right child of n->parent, then go up until n is left child of n->parent
*/
Node successor (Node n) {
    if (n == null) return null;

    //if n has a right subtree get its leftmost child
    if (n.right != null) {
        n = n.right; //use the right subtree

        //loop until you get to the leftmost child
        while (n.left != null) {
            n = n.left;
        }
        return n;
    } 
    //if no right subtree, loop upwards until n is a left child
    else {
        while (n.parent != null && n != n.parent.left) {
            n = n.parent;
        }
        return n.parent; //if n.parent is null, that means we've reached the end
    }
}
