/*
Remove Dups: Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed? 
*/
/* SOLUTIONS:
1. No Buffer, Brute Force - go thru each combo. O(N^2) time
2. Hash table, single pass. Go thru list, store into hashtable. if exists, then remove. Uses buffer!
*/

//SOLN 2 (Assuming singly linked list)
public ListNode removeDups(ListNode n) {
	HashSet<String> set = new HashSet<String>(); //could also use a HashMap <String, String>

	while(n.next != null) {
		if(set.contains(n.next.data)) {
			n.next = n.next.next;
		} else {
			set.add(n.next.data);
		}
		n = n.next;
	}
	return n;
}

//Assuming doubly linked list, another method
public ListNode removeDups(ListNode n) {
	HashSet<String> set = new HashSet<String>();

	while(n != null) {
		if(set.contains(n.data)) {
			n.next.prev = n.prev;
			n.prev.next = n.next;
		} else {
			set.add(n.data);
		}
		n = n.next;
	}
}

//OFFICIAL SOLN (doubly linked)
public static void deleteDups(LinkedListNode n) {
	HashSet<Integer> set = new HashSet<Integer>();
	LinkedListNode previous = null;
	while (n != null) {
		if (set.contains(n.data)) {
			previous.next = n.next;
		} else {
			set.add(n.data);
			previous = n;
		}
		n = n.next;
	}
}