/*
Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
node. Note that the intersection is defined based on reference, not value. That is, if the kth
node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting. 

SOLUTIONS:
1. If the two lists intersect, they will be the same after the intersecting node, because the next pointer of the intersecting node cannot be different.
	e.g. 1->2->3 intersects with 5->6->(1->2->3) at node 1
So traverse to the end of both. If both have the same tail, they intersect.
Now, move the longer list by the difference of their lengths.
Then, traverse each until they intersect, then return.
*/

public class intersection {

	public static void main(String[] args) {
		Node a = new Node(1, new Node(2, new Node(3, null)));
		Node b = new Node(5, new Node(6, a));
		Node c = new Node(7, new Node(8, new Node(9, a)));
		System.out.println(findIntersection(c,b).data);
	}

	public static Node findIntersection(Node list1, Node list2) {
		//1. Run through each list to get length and tails
		int length1 = 0;
		Node tail1 = null;
		Node current = list1;
		while (current.next != null) {
			current = current.next;
			length1++;
		}
		tail1 = current;

		int length2 = 0;
		Node tail2 = null;
		current = list2;
		while (current.next != null) {
			current = current.next;
			length2++;
		}
		tail2 = current;

		//2. If not same tail, return null
		if (tail1 != tail2) return null;

		//3. Advance the longer list by the difference in sizes
		Node longer = (length1 > length2) ? list1 : list2;
		Node shorter = (length1 > length2) ? list2 : list1;

		int difference = Math.abs(length1 - length2);

		for (int i = 0; i < difference; i++) {
			longer = longer.next;
		}

		//4. move both forward until there is an intersection, then return either
		while (longer != shorter) {
			longer = longer.next;
			shorter = shorter.next;
		}
		return longer;
	}

}
