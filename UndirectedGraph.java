class UndirectedGraph {
	public static void main(String args[]) throws IOException {
		ArrayList<Node<Integer>> nodes = new ArrayList<Node<Integer>>();
		Node<Integer> n1 = new Node<Integer>(1);
		nodes.add(n1);
		for(int i = 2; i < 11; i++) {
			Node<Integer> n = new Node<Integer>(i);
			n1.addAdjacentNode(n);
			nodes.add(n);
		}
		nodes.get(0).printAdjacents();
		nodes.get(1).printAdjacents();
	}
}

class Node<T> {
	ArrayList<Node<T>> adjacents;
	// Node next = null;
	T data;

	public Node(T data) {
		this.data = data;
		adjacents = new ArrayList<Node<T>>();
	}

	public Node(T data, ArrayList<Node<T>> adjacents) {
		this.data = data;
		this.adjacents = adjacents;
	}

	void addAdjacentNode(Node<T> n) {
		if(this.adjacents.contains(n)) {
			return;
		}
		else {
			this.adjacents.add(n);
			n.addAdjacentNode(this);
		}
	}

	void printAdjacents() {
		System.out.println("Adjacents of Node (" + this.data + ") is:");
		System.out.print("{");
		for(int i = 0; i < adjacents.size(); i++) {
			if(i != adjacents.size()-1) {
				System.out.print(adjacents.get(i).data + ",");
			}
			else {
				System.out.print(adjacents.get(i).data);
			}
		}
		System.out.println("}");
	}
}