package linkedlist.problems;

public class ReverseLinkedList {
	public static void printList(Node head){
		Node curr = head;
		while(curr!=null){
			System.out.print(curr.data+ " ");
			curr = curr.next;
		}
	}
	
	public static Node reverse(Node head){
		Node prev = null;
		Node curr = head;
		while(curr != null){
			Node temp = new Node(curr.data);
			temp.next = prev;
			prev = temp;
			curr = curr.next;
		}
		return prev;
	}
	
	
	public static Node revPrac(Node head) {
		Node curr = head;
		Node prev = null;
		while(curr != null) {
			//1->2->3->4
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		} 
		return prev;
	}
	public static void main(String[] args){
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		
		printList(head);
		
//		Node rhead = reverse(head);
//		printList(rhead);
//		
//		Node rh = rev2(head);
//		
//		printList(rh);
		Node rev = revPrac(head);
		printList(rev);
	}
}
