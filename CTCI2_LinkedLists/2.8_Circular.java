/*	Given a circular linked list, implement an algorithm
	which returns the node at the beginning of the loop.

	Definition of Circular linked list:
	A (corrupt) linked list in which a node's next pointer points to an earlier node.
*/

/*	Approach 1: Use a set to store all nodes of LL.
	as we go through LL, if we have a loop, return.
	O(n) time, O(n) space
*/
void circular(Node head) {
	Set<Node> unique = new Set<Node>();

	while(head != null) {
		if(unqiue.contains(head)) {
			return head;
		}
		else
			unique.add(head);
		head = head.next;
	}
	return null;
}

/*	Book solution:
	Runner Technique --

*/
