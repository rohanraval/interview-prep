/*
List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists). 

APPROACH: create an array of LL's. keep track of depth using a count during recursion thru tree,
and push to the LL in the array at that count.
*/

// DFS SOLUTION (recursive)
ArrayList<LinkedList<Node>> listOfDepthsRootDFS(Node root) {
    ArrayList<LinkedList<Node>> list = new ArrayList<LinkedList<Node>>();
    int count = 0;
    return listOfDepths(root, list, count);
}
ArrayList<LinkedList<Node>> listOfDepthsDFS(Node n, ArrayList<LinkedList<Node>> list, int depth) {
    //base case
    if(n == null) {
        return list;
    }
    //if we're at a new depth, create a new LL and append it to lists
    if(list.length == depth) {
        list.add(new LinkedList<Node>());
    }
    //add the current node to the LL that's at the index of the depth in lists
    list.get(depth).add(n);

    //recurse for left and right children, incrementing depth
    list = listOfDepthsDFS(n.left, list, depth++);
    list = listOfDepthsDFS(n.right, list, depth++);
    
    return list;
} 

//BFS SOLUTION 
ArrayList<LinkedList<Node>> listOfDepthsBFS(Node root) {
    ArrayList<LinkedList<Node>> list = new ArrayList<LinkedList<Node>>();

    //acts as queue
    LinkedList<Node> queue = new LinkedList<Node>();

    if(root != null) {
        queue.add(root); //add root to queue
    }
    //go thru queue and keep adding levels
    while(!queue.isEmpty()) {
        //add entire previous level (queue) to result set
        result.add(queue);

        //set parents to be the previous level, and unset the queue
        LinkedList<Node> parents = queue;
        queue = new LinkedList<Node>();

        //visit the next level
        for(Node parent : parents) {
            //add entire next level to queue (if not null)
            if (parent.left != null)
                queue.add(parent.left);
            if (parent.right != null)
                queue.add(parent.right);
        }
    }
    return result;
}