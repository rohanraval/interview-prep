/*
Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
to create a binary search tree with minimal height. 

SOLUTION: recursive! go through left and right and keep splitting up array
*/

Node minimalTreeRoot(int[] elements) {
    return minimalTree(elements, 0, elements.length-1);
}

Node minimalTree(int[] elements, int start, int end) {
    if(end < start) {
        return null;
    }
    int mid = (start+end)/2;

    Node n = new Node();
    n.left = minimalTree(elements, start, mid-1);
    n.right = minimalTree(elements, mid+1, end);
    n.data = elements[mid];
    return n;
}
