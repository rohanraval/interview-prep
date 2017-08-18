/* 
Paths with Sum: You are given a binary tree in which each node contains an integer value (which
might be positive or negative). Design an algorithm to count the number of paths that sum to a
given value. The path does not need to start or end at the root or a leaf, but it must go downwards
(traveling only from parent nodes to child nodes). 
*/

/*
BRUTE FORCE SOLUTION: Start at a node and keep track of the sum as you recurse down each subtree.
When you hit the sum that we are looking for, increment the variable that keeps track of pathsWithSum.
Do this for all nodes - O(N log N)
*/

int getPathsWithSum(Node root, int target) {
    //base case
    if (root == null) {
        return 0;
    }

    //counting number of paths with target sum from root node
    int pathsFromNode = numPaths(root, 0, target);

    //do this for both subtrees recursively
    int pathsOnLeft = getPathsWithSum(root.left, target);
    int pathsOnRight = getPathsWithSum(root.right, target);
    
    //return the number of valid paths from this node, plus the number of valid paths from its subtrees
    return pathsFromNode + pathsOnLeft + pathsOnRight;
}

int numPaths(Node n, int sum, int target) {
    //base case
    if (n == null) {
        return 0;
    }
    
    //increment running sum by this node's value
    sum += n.data;

    int totalPaths = 0;
    //if running sum is the target we are looking for, then increment count of valid paths
    if (sum == target) {
        totalPaths++;
    }
    //recursively increment count of valid paths by traversing both subtrees
    totalPaths += numPaths(n.right, sum, target);
    totalPaths += numPaths(n.left, sum, target);

    //return number of valid paths
    return totalPaths;
}
