/*
Palindrome: Implement a function to check if a linked list is a palindrome. 
*/
/* SOLUTIONS:
1. Palindrome means string is the same forwards and backwards.
	So reverse and compare. 
	Check if forwards ll is the same as backwards ll.
	Implement methods isEqual() and reverse() to do so.
2. 
*/

public class isPalindrome {

	public static void main(String[] args) {
		Node a = new Node(1, new Node(2, new Node(1, null)));
		System.out.println(isPalindrome(a));
	}

	public static boolean isPalindrome(Node a) {
		return isEqual(a, reverseAndClone(a));
	}

	public static boolean isEqual(Node a, Node b) {
		while(a!=null && b!=null) {
			if(a.data != b.data) {
				return false;
			}
			a = a.next;
			b = b.next;
		}
		return (a==null)&&(b==null);
	}

	public static Node reverseAndClone(Node a) {
		Node head = null;

		while(a != null) {
			Node newNode = new Node(a.data, head);
			head = newNode;
			a = a.next;
		}
		return head;
	}

	public static Node reverse(Node a) {
		Node prev = null;
		Node curr = a;
		Node next = null;

		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}