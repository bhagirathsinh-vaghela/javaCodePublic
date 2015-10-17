class SinglyLinkedList {
	public static void main(String args[]) {
		Node n1 = new Node(1);
		n1.appendToTail(2);
		n1.appendToTail(3);
		n1.appendToTail(4);
		n1.appendToTail(5);
		n1.appendToTail(6);
		n1.appendToTail(7);
		n1.appendToTail(8);
		n1.appendToTail(9);
		n1.appendToTail(10);
		Node.printList(n1);
		System.out.println();
		Node n2 = n1.reverseList(n1);
		Node.printList(n2);
		// System.out.println(n2.data);
		// Node n2 = n1.temp;
		// Node.printReverseList(n2);
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

	static void printReverseList(Node n) {
		while(n.data != 1) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}

	Node reverseList(Node n) {		
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

	void reverse(Node n) {
		if(n.next != null) {
			reverseList(n.next);
			n.next.next = n;
		}
		else {
			newHead = n;
		}
	}

	public Node deleteNode(int data) {
		Node n = this;
		if(n.data == data) {
			return n.next;
		}
		else {
			while(n.next != null) {
				if(n.next.data == data) {
					n.next = n.next.next;
				}
				n = n.next;
			}
			return this;
		}
	}
}