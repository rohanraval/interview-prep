/* Algorithm to partition List around value x,
	such that all nodes >= x come after all nodes < x
*/

//Solution: create two linked lists, one for elements >= x and one for < x

Node partition(int x, Node head) {
	Node gte_head = null;
	Node lt_head = null;

	Node curr = head;
	Node gte_curr = gte_head;
	Node lt_curr = lt_head;

	while(curr != null) {
		if(curr.value > x || curr.value == x) {
			gte_curr.next = curr;
			gte_curr = gte_curr.next;
		}
		else {
			lt_curr.next = curr;
			lt_curr = lt_curr.next;
		}
		curr = curr.next;
	}

	Node merger_head = null;
	Node merger_curr = merger_head;
	Node n_lt = lt_head.next;
	Node n_gte = gte_head.next;

	while(n_lt != null) {
		merger_curr = n_lt;
		merger_curr = merger_curr.next;
	}
	while(n_gte != null) {
		merger_curr = n_gte;
		merger_curr = merger_curr.next;
	}

	return merger_head.next; //merger_head.next is the head of the list containing all numbers
}
