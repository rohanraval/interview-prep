/*
First Common Ancestor: Design an algorithm and write code to find the first common ancestor
of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.
*/

//Note: if we can assume that we are given link to parent, then we can solve like #2.7 (Intersection)

//SOLUTION 1 - With Link to Parent
Node firstCommonAncestor (Node a, Node b) {

    //find depth difference of a and b (from root)
    int difference = depth(a) - depth(b);
    Node deep = difference >= 0 : a ? b;
    Node shallow = difference >= 0 : b ? a;

    //move shallow node up by difference in depth
    for (int i = 0; i < Math.abs(difference); i++) {
        if (shallow.parent == null) {
            return null;
        }
        shallow = shallow.parent;
    }

    //move both up until they collide
    while (shallow != deep) {
        if (shallow == null || deep == null) {
            return null;
        }
        shallow = shallow.parent;
        deep = deep.parent;
    }
    
    //return the intersecting node (common ancestor)
    return shallow;
}

int depth (Node n) {
    int depth = 0;
    while (n != null) {
        n = n.parent;
        depth++;
    }
    return depth;
}
