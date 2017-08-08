/*
List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists). 

APPROACH: create an array of LL's. keep track of depth using a count during recursion thru tree,
and push to the LL in the array at that count.
*/

LinkedList<Node>[] listOfDepthsRoot(Node root) {
    LinkedList<Node>[] list = new LinkedList<Node>[];
    int count = 0;
    return listOfDepths(root, list, count);
}

LinkedList<Node>[] listOfDepths(Node n, LinkedList<Node>[] list, int depth) {
    if(n == null) {
        return list;
    }

    if(list.length == depth) {
        list[depth] = new LinkedList<Node>();
    }
    list[depth].add(n);

    list = listOfDepths(n.left, list, depth++);
    list = listOfDepths(n.right, list, depth++);
    return list;
} 