/*
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes.
*/
enum State { Unvisited, Visited, Visiting; } 

boolean search(Graph g, Node x, Node y) {
    //if they are the same then return true
    if (x == y)
        return true;

    //create a queue
    LinkedList<Node> queue = new LinkedList<Node>;

    //set all Nodes in Graph to Unvisited
    for(n : g.getNodes()) {
        n.state = State.Unvisited;
    }

    //add x to the queue and create a tracker Node n
    Node n;
    x.state = State.Visiting;
    queue.add(x);

    //go through the queue
    while(!queue.isEmpty()) {
        //dequeue the first element of the queue
        n = queue.removeFirst();
        if(n != null) {
            //go through all the adjacent elements for that element
            for(Node m : n.getAdjacent()) {
                //only go into that element if it's unvisited
                if(m.state == State.Unvisited) {
                    if(m == y)
                        return true;
                    else {
                        m.state = State.Visiting;
                        queue.add(m);
                    }
                }
            }
        }
        n.state = State.Visited;
    }
}
