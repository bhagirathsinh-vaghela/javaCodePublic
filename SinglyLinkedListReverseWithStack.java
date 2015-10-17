class SinglyLinkedListReverseWithStack {
	public static void main(String args[]) {
		Node list = new Node(1);
		for(int i = 2; i <= 10; i++) {
			list.append(i);
		}
		list.printList();
		System.out.println();
		list.reverse();
		list.printList();
	}
}

class Node {
	private Node next = null;
	private int data;

	public Node(int data) {
		this.data = data;
	}

	void append(int data) {
		Node end = new Node(data);
		Node n = this;
		while(n.next != null) {
			n = n.next;	//Traverse to current last node
		}
		n.next = end;
	}

	int size() {
		int count = 1;
		Node n = this;
		while(n.next != null) {
			count++;
			n = n.next;
		}
		return count;
	}

	void printList() {
		Node n = this;
		while(n.next != null) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}

	void reverse() {
		Node list = this;
		Stack stk = new Stack(list.size());		
		while(list.next != null) {
			stk.push(list.data);
			list = list.next;
		}
		stk.push(list.data);

		list = this;
		for(int i = 0; i < stk.getSize(); i++) {			
			list.data = stk.pop();
			list = list.next;	
		}	
	}
}

class Stack {
	private int tos = -1;
	private int[] stk;
	private int size;

	public Stack(int size) {
		stk = new int[size];
		this.size = size;
	}

	void push(int e) {
		if(tos == stk.length-1) {
			System.out.println("Stack Overflow");
			return;
		}
		stk[++tos] = e;
	}

	int getSize() {
		return size;
	}

	void printStack() {
		for(int i : stk) {
			System.out.println(i);
		}
	}

	int pop() {
		if(tos == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return stk[tos--];
	}
}