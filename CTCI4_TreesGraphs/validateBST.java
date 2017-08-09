/*
Validate BST: Implement a function to check if a binary tree is a binary search tree.
*/

//NOTE: For a tree to be a BST, it is *NOT* enough for: left <= current < right
    //we need ALL nodes on LEFT <= current, and ALL nodes on RIGHT > current

//SOLUTION 1 -- O(N) time, O(log N) space
    //recurse thru left and right, each time checking against a RANGE of (min, max)
boolean validateBST (Node root) {
    if (root == null) return true;
    return validate(root, null, null); //at first, range is infinite
}

boolean validate (Node n, int min, int max) {
    //Base Case
    if (root == null) return true;

    //if n is out of bounds, return false
    if ((min!=null && n.data <= min) || (max!=null && n.data > max)) {
        return false;
    } else {
        return true;
    }
    //validate left by setting current as its max, and right by setting current as its min
    return validate(n.left, min, n.data) && validate(n.right, n.data, min);
}
