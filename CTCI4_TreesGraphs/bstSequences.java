/*
BST Sequences: A binary search tree was created by traversing through an array from left to right
and inserting each element. Given a binary search tree with distinct elements, print all possible
arrays that could have led to this tree.
*/

//SOLUTION - two different recursive functions, one to manage and one to weave sequences together

//recursively goes thru the tree and weaves subtrees to create a list of all possible combinations
ArrayList<LinkedList<Integer>> bstSequences (Node node) {
    ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

    if (node == null) {
        result.add(new LinkedList<Integer>()); //why?
        return result;
    }

    LinkedList<Integer> prefix = new LinkedList<Integer>();
    prefix.add(node.data);

    //left and right subtrees recursion
    ArrayList<LinkedList<Integer>> leftList = bstSequences(node.left);
    ArrayList<LinkedList<Integer>> rightList = bstSequences(node.right);

    for (LinkedList<Integer> left : leftList) {
        for (LinkedList<Integer> right : rightList) {
            ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
            weave(left, right, prefix, weaved);
            result.addAll(weaved);
        }
    }

    return result;
}

//takes two lists and returns a list of all possible combinations while maintaining the relative orders
void weave (LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix, ArrayList<LinkedList<Integer>> results) {
    //Base case - one of the lists are empty
    if (first.size() != 0 || second.size() != 0) {
        //add prefix, then first and second lists to results
        LinkedList<Integer> result = new LinkedList<Integer>();
        result.addAll(prefix);
        result.addAll(first);
        result.addAll(second);
        results.add(result);
        return;
    }

    //Recurse for first
    int firstHead = first.removeFirst(); //pop from first list
    prefix.addLast(firstHead); //add to prefix
    weave(first, second, prefix, results); //recurse
    prefix.removeLast(); //remove from prefix
    first.addFirst(firstHead); //push back to first

    //Recurse for second
    int secondHead = second.removeFirst();
    prefix.addLast(secondHead);
    weave(first, second, prefix, results);
    prefix.removeLast();
    second.addFirst(secondHead);
}
