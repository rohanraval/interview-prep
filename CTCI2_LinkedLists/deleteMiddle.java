/*
Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node. 
*/
/* SOLUTIONS:
1. Move all the rest of the nodes up.
	1 -> 2 -> 3 -> 4 -> 5
*/

//INITIAL ATTEMPT - DUMB O(N) SOLUTION, YOU DON'T NEED TO TRAVERSE ENTIRE LIST!
	//here, we're moving up all the elements and deleting the last one,
	//but we only really need to move up the next element and delete that one -- O(1)! 
public void deleteMiddle(Node n) {

	while(n.next != null) {
		n.data = n.next.data;
		n = n.next;
	}

	n = null; //doesn't really work - bad idea

}

//OFFICIAL SOLUTION - O(1)
public void deleteMiddle(Node n) {
	n.data = n.next.data; // store the next's data into this one
	n.next = n.next.next; //get rid of the next one
}