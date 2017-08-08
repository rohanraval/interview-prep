/*
	Algorithm to remove duplicate nodes from a linked list
*/

// With Buffer (using a set)
	//O(n) space, O(n^2) time technically -- but amortized O(n) time

public void removeDups(LinkedListNode n) {
	LinkedListNode prev = null;
	HashSet<Integer> set = new HashSet<Integer>();

	while(n.next != null) {
		if(set.contains(n.value)) {
			prev.next = n.next;
		}
		else {
			set.add(n.value);
			prev = n;
		}
		n = n.next;
	}
}

//Without Buffer
	//O(1) space, O(n^2 time)

public void removeDups(LinkedListNode n) {
	LinkedListNode current = n;
	while(current != null) {
		LinkedListNode runner = current;
		while(runner.next != null) {
			if(runner.next.value == current.value)
				runner.next = runner.next.next;
			else
				runner = runner.next;
		}
		current = current.next;
	}
}
