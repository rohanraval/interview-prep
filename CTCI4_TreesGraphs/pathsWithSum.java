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

/*
OPTIMAL SOLUTION: Instead of recomputing the O(log N) sums from every node, do it from the top level,
then store the running sum in a hashtable to compare against target.

As we visit each node:
1. Track its runningSum. We'll take this in as a parameter and immediately increment it by node.value.
2. Look up runningSum - targetSum in the hash table. The value there indicates the total number. Set
totalPaths to this value.
3. If runningSum == targetSum, then there's one additional path that starts at the root. Increment
totalPaths.
4. Add runningSum to the hash table (incrementing the value if it's already there).
5. Recurse left and right, counting the number of paths with sum targetSum.
6. After we're done recursing left and right, decrement the value of runningSum in the hash table. This is
essentially backing out of our work; it reverses the changes to the hash table so that other nodes don't
use it (since we're now done with node). 
*/

int getPathsWithSum(Node root, int target) {
    return numPaths(root, target, 0, new HashMap<Integer, Integer>());
}

int numPaths(Node n, int target, int runningSum, HashMap<Integer, Integer> pathCount) {
    //base case
    if (n == null) {
        return 0;
    }

    //count paths with sum ending at current node
    runningSum += node.data;
    int sum = runningSum - targetSum;
    int totalPaths = pathCount.getOrDefault(sum, 0);

    //if runningSum = target, then one additional path starts at root
    if (runningSum == target) {
        totalPaths++;
    }

    //increment pathCount
    int newCount = pathCount.getOrDefault(runningSum, 0) + 1;
    pathCount.put(runningSum, newCount);

    //recurse
    totalPaths += numPaths(node.left, target, runningSum, pathCount);
    totalPaths += numPaths(node.right, target, runningSum, pathCount);  

    //decrement pathCount  
    int newCount = pathCount.getOrDefault(runningSum, 0) - 1;
    pathCount.put(runningSum, newCount);

    return totalPaths;
}
