/*
Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one. 

*/

//SOLUTION 1 -- O(N log N)
    //Recursive function computes height of each subtree while also checking if node is balanced.
boolean checkBalanced (Node root) {
    //Base Case
    if(root == null) {
        return true;
    }
    //get height difference for node's subtrees
    int heightDiff = getHeight(root.right) - getHeight(root.left);
    //if height difference is greater than 1, then unbalanced
    if (Math.abs(heightDiff) > 1) {
        return false;
    } else {
    //else recurse and check whether subtrees are balanced
        return checkBalanced(root.right) && checkBalanced(root.left);
    }
}
int getHeight (Node n) {
    //Base Case throws -1 if null
    if(root == null) {
        return -1;
    } 
    //return the height of the subtree that's greater, add one for the current node
    return Math.max(getHeight(root.right), getHeight(root.left))+1;
}

//SOLUTION 2 -- O(N)
    //Instead of getting the height of both subtrees at every single node, we can
    //avoid repitition by recursively checking the height of each subtree from the root
    //If there is an imbalance, and error code (Integer.MIN_VAL) is propagated up
boolean checkBalanced (Node root) {
    return getHeight(root) != Integer.MIN_VALUE;
}
int getHeight (Node n) {
    //Base Case
    if (n == null) {
        return -1;
    }
    int leftHeight = getHeight(n.left);
    if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //if error, propagate up

    int rightHeight = getHeight(n.right);
    if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //if error, propagate up

    int heightDiff = rightHeight - leftHeight;

    if (Math.abs(heightDiff) > 1) {
        return Integer.MIN_VALUE; //if this node is the one that's imbalanced, return error
    } else {
        return Math.max(leftHeight, rightHeight) + 1; //if no error, return the actual height
    }

}