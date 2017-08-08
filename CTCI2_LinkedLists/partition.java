/*
Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions. 
*/
/* SOLUTIONS:
1. Make two lists, before partition and after partition, and add nodes to those. Then merge them, easy with ll.
*/

//OFFICIAL SOLUTION
public void partition(Node node, int x) {
	Node beforeStart = null;
	Node beforeEnd = null;
	Node afterStart = null;
	Node afterEnd = null;
	
	/* Partition list */
	while (node != null) {
		Node next = node.next;
		node.next = null;
		if (node.data < x) {
			if (beforeStart == null) {
				beforeStart = node;
				beforeEnd = beforeStart;
			} else {
				beforeEnd.next = node;
				beforeEnd = node;
			}
		} else {
			if (afterStart == null) {
				afterStart = node;
				afterEnd = afterStart;
			} else {
				afterEnd.next = node;
				afterEnd = node;
			}
		}	
		node = next;
	}
	
	/* Merge before list and after list */
	if (beforeStart == null) {
		return afterStart;
	}
	
	beforeEnd.next = afterStart;
	return beforeStart;
}