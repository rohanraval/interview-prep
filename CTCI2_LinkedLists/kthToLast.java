/*
Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list. 
*/
/* SOLUTIONS:
1. Runner Technique - Slow pointer is k behind the fast pointer. When fast reaches end,
	slow is at kth to last. Return slow.
*/

//first attempt - revised, correct now -- O(N)
public Node kthToLast(Node n, int k) {
	for(i = 0; i < k; i++) {
		if (n == null) return null;
		n = n.next;
	}
	Node slow = n;
	while(n != null) {
		n = n.next;
		slow = slow.next;
	}
	return slow;
}

//official solution using recursion - LEARN HOW THIS WORKS!
public static int printKthToLast(LinkedListNode head, int k) {
	if (head == null) {
		return 0;
	}
	int index = printKthToLast(head.next, k) + 1;
	if (index == k) {
		System.out.println(k + "th to last node is " + head.data);
	}
	return index;
}
