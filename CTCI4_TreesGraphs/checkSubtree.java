/*
Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an
algorithm to determine if T2 is a subtree of T1. 
*/

//SOLUTION 1 - recursive, O(N+M)?
boolean checkSubtree(Node root1, Node root2) {
    //if both are null, then true
    if (root1 == null && root2 == null) {
        return true;
    }
    //if only one of them is null then false
    if (root1 == null || root2 == null) {
        return false;
    }

    //if the nodes match, then go into each's subtrees and check
    if (root1.data == root2.data) {
        return checkSubtree(root1.left, root2.left) && checkSubtree(root1.right, root2.right);
    }
    //if nodes don't match, then keep going deeper into root1's subtree to look for root2
    else {
        return checkSubtree(root1.left, root2) || checkSubtree(root1.right, root2);
    }
}

//ALTERNATE SOLUTION: compare the pre-order traversals of both and see if one string is contained within the other