/*
Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list. 
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem. 
*/
/* SOLUTIONS:
1. 	For reverse: Go thru and multiply digit by 10^x every iteration, where x is determined by position.
		7->1->6 = 617 = 7*10^0 + 1*10^1 + 6*10^3
	For forward: Go thru and add digit to an accumulated result * 10 and store that back into result to get an int from an LL.
		7->1->6 = 716 = 10*[10*[(10*0)+7]+1]+6

*/
public class sumLists {

	public static void main(String[] args) {
		Node a = new Node(6, new Node(1, new Node(7, null)));
		Node b = new Node(2, new Node(9, new Node(5, null)));

		System.out.println(reverseSumList(a,b));
		System.out.println(forwardSumList(a,b));
	}

	public static int reverseSumList(Node a, Node b) {
		int result = 0;
		int count = 0;
		while(a != null) {
			result += a.data * Math.pow(10,count);
			count++;
			a = a.next;
		}
		count = 0;
		while(b != null) {
			result += b.data * Math.pow(10,count);
			count++;
			b = b.next;
		}
		return result;
	}

	public static int forwardSumList(Node a, Node b) {
		int resultA = 0;
		while(a != null) {
			resultA = (resultA*10) + a.data;
			a = a.next;
		}
		int resultB = 0;
		while(b != null) {
			resultB = (resultB*10) + b.data;
			b = b.next;
		}
		return resultA + resultB;
	}
}
