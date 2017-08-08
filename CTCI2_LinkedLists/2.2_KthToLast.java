/*
	Algorithm that returns Kth to last element of a Linked List.
*/

Node kthToLast(Node head, int k) {

	//2 runners, one k ahead of other
	Node a = head;
	Node b = head;

	//make b to be k nodes ahead of a
	for(int i = 0; i < k; i++) {
		b = b.next;
		if(b == null) return null;
	}

	//iterate until b reaches end
		// at this point, a will be kth to last element
	while(b.next != null) {
		a = a.next;
		b = b.next;
	}
	return a;
}

// Time: O(n) where n is # of nodes in list
// Space: O(1)
