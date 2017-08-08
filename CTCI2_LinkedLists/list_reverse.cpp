/*

*/

ListNode* reverse(ListNode* head) {
	ListNode * a = head;
	ListNode * b = head -> next;
	ListNode * c = head -> next -> next;

	while(a -> next != null) {
		a -> next = null;
		b -> next = a;
		a = b;
		b = c;
		c = c -> next;
	}

}
