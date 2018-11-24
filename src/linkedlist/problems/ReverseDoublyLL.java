package linkedlist.problems;

public class ReverseDoublyLL {
	Node head, tail;
	private static class Node {
		Node right = null;
		Node left = null;
		int data;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public void insert(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		tail.right = newNode;
		tail = newNode;
		
	}
	
	public void revList() {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			// 1 - 2 - 3 - 4
			Node next = curr.right;
			curr.right = prev;
			curr.left = next;
			prev = curr;
			curr = curr.left;
			
		}
		Node temp = head;
		head = tail;
		tail = temp;
	}
	

	public void printList() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data+" ");
			curr = curr.right;
		}
	}
	
	public static void main(String[] args) {
		ReverseDoublyLL list = new ReverseDoublyLL();
		for (int i = 0; i < 5; i++) list.insert(i+1);
		list.printList();
		list.revList();
		list.printList();
	}
}
