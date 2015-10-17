class SinglyLinkedListReverse {
	public static void main(String args[]) {
		Node n = new Node(1);
		n.appendToTail(2);
		n.appendToTail(3);
		n.appendToTail(4);
		n.appendToTail(5);
		n.appendToTail(6);
		n.appendToTail(7);
		n.appendToTail(8);
		n.appendToTail(9);
		n.appendToTail(10);
		Node.printList(n);
		System.out.println();
		Node.printList(Node.reverseList(n));		
	}
}

class Node {
	Node next = null;
	int data;
	static Node newHead = null;

	public Node(int data) {
		this.data = data;
	}

	void appendToTail(int data) {
		Node end = new Node(data);
		Node n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	static void printList(Node n) {
		while(n.next != null) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}

	static Node reverseList(Node n) {		
		if(n.next != null) {
			reverse(n.next);			
			n.next.next = n;
		}
		else {
			newHead = n;
		}
		n.next = null;
		return newHead;
	}

	static void reverse(Node n) {
		if(n.next != null) {
			reverseList(n.next);
			n.next.next = n;
		}
		else {
			newHead = n;
		}
	}
}