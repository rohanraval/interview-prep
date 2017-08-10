/*
Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
projects, where the second project is dependent on the first project). All of a project's dependencies
must be built before the project is. Find a build order that will allow the projects to be built. If there
is no valid build order, return an error.
*/

//SOLUTION - BFS Topological Sort: O(N^2) worst-case, close to O(N)

public class Node {
    public ArrayList<Node> outgoing = new ArrayList<Node>();
	public String name;
	public int indegree;
    public int visited = 0; //only used for DFS
	
	public Node(String n, int in) {
		name = n;
        indegree = in;
	}
}

public class buildOrder {

    ArrayList<Node> createBuildOrder(String[] projects, String[][] dependencies) {
        //First, build the graph (a map of String->Node can represent the graph)
        HashMap<String, Node> graph = HashMap<String, Node>();

        //Loop through list of projects and add them to map as Nodes
        for(String project : projects) {
            graph.put(project, new Node(project, 0));
        }
        //Loop through dependencies list and configure dependencies into graph
        for(String[] dep : dependencies) {
            //dep = ["x", "y"] where "y" depends on "x"
            Node parent = graph.get(dep[0]);
            Node child = graph.get(dep[1]);
            child.indegree++;
            parent.outgoing.add(child);
        }

        //Topologically sort the graph to return a list representing a valid build order
        return topologicalSortBFS(graph);
    }

    //BFS topologicalSort algorithm
    ArrayList<Node> topologicalSortBFS(HashMap<String, Node> graph) {
        //create returned list
        ArrayList<Node> result = new ArrayList<Node>();

        //create a queue
        ArrayList<Node> queue = new ArrayList<Node>();

        //go thru map and add all nodes with indegree=0 (independent) to queue
        Set graphEntries = graph.entrySet();
        Iterator it = set.iterator;
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry)it.next();
            Node current = me.getValue();
            if (current.indegree == 0) {
                queue.add(current);
            }
        }

        //go through queue and add to result
        while (!queue.isEmpty()) {
            //dequeue and add to result
            Node current = queue.removeFirst();
            result.add(current);
            
            //remove all outgoing edges for current
            for (Node outgoing : current.outgoing) {
                //set outgoing node's indegree to 0 because current has already been added
                outgoing.indegree--;
                //if this node is now independent, then add to queue
                if (outgoing.indegree == 0) {
                    queue.add(outgoing);
                }
            }
        }

        //if there are still nodes with indegree != 0, then throw error
        Set graphEntries = graph.entrySet();
        Iterator it = set.iterator;
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry)it.next();
            Node current = me.getValue();
            if (current.indegree != 0) {
                throw new RuntimeError("Not a DAG");
            }
        }

        return result;
    }

    //DFS topologicalSort algorithm
    ArrayList<Node> topologicalSortDFS(HashMap<String, Node> graph) {
        //create returned list
        ArrayList<Node> result = new ArrayList<Node>();

        //use a stack 
        ArrayList<Node> stack = new ArrayList<Node>();  

        //Keep track of unvisited nodes
        ArrayList<Node> unvisited = new ArrayList<Node>();
        //add all Nodes to unvisited
        Set graphEntries = graph.entrySet();
        Iterator it = set.iterator;
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry)it.next();
            Node current = me.getValue();
            unvisited.add(current);
        }

        //while there are unvisited nodes, recurse
        while (!unvisted.isEmpty()) {
            visit(unvisited.removeFirst(), unvisited, stack);
        }

        //pop from stack to result
        while (!stack.isEmpty()) {
            result.add(stack.removeFirst()); 
        }
        return result;
    }
    void visit(Node n, ArrayList<Node> unvisited, ArrayList<Node> stack) {
        //if n has been permanently visited (2), return
        if (n.visited == 2) {
            return;
        }
        //if n has been temporarily visited (1), then throw error because this is not a DAG
        if (n.visited == 1) {
            throw new RuntimeError("Not a DAG");
        }
        //if n has not been visited (0), then visit
        if (n.visited == 0) {
            n.visited = 1; //mark n temporarily
            //visit all outgoing
            for (Node m : n.outgoing) {
                visit(m, unvisited, stack);
            }
            //mark n permanently and push to stack
            n.visited = 2;
            unvisited.remove(n);
            stack.addFirst(n);
        }
    }
}
