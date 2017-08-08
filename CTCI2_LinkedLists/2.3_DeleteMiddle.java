/* Algorithm to delete middle node in singly linked list, given access only to that node.
*/

//Solution: Copy data over from next node into current one, over and over
	//O(n/2) time - BAD !!!

void deleteMiddle(Node middle) {
	Node current = middle;
	while(current.next != null) {
		current.value = current.next.value;
		current = current.next;
	}
}

//Better Solution: Copy data over from next node into current one, adjust pointers immediately
	//O(1) time

boolean deleteMiddle(Node middle) {
	if(middle == null | middle.next == null) return false;

	middle.value = middle.next.value;
	middle.next = middle.next.next;
	return true;
}
