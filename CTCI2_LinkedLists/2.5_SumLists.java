/* Algorithm that sums the numbers of two lists,
	where each element of a list represents a digit in the number.
	Reverse: digits are listed in reverse order (i.e. 7 -> 2 -> 1 = 127)
	Forward: digits are listed in forward order (i.e. 7 -> 2 -> 1 = 721)
*/

int sumListsReverse (Node a_head, Node b_head) {

	int index = 0;
	int sum = 0;
	while(a_head != null) {
		sum += a_head.value * Math.pow(10, index); // 127 = 1*10^2 + 2*10^1 + 7*10^0
		index++;
		a_head = a_head.next;
	}
	index = 0;
	while(b_head != null) {
		sum += b_head.value * Math.pow(10, index);
		index++;
		b_head = b_head.next;
	}
	return sum;
}
// O(n + m) time where n = digits in a and m = digits in b
// O(1) space

int sumListsForward (Node a_head, Node b_head) {

	int sum = 0;

	//first go through a and get count of elements in a
		//then follow process of reverse, except decrementing a_count
	Node a_pointer = a_head;
	Node a_count = 0;
	while(a_pointer != null) {
		a_count++;
		a_pointer = a_pointer.next;
	}
	while(a_head != null) {
		sum += a.head.value * Math.pow(10, a_count);
		a_count--;
		a_head = a_head.next;
	}

	Node b_pointer = b_head;
	Node b_count = 0;
	while(b_pointer != null) {
		b_count++;
		b_pointer = b_pointer.next;
	}
	while(b_head != null) {
		sum += b.head.value * Math.pow(10, b_count);
		b_count--;
		b_head = b_head.next;
	}
	return sum;
}
//O(n + m) time, but super inefficient because of so many loops
