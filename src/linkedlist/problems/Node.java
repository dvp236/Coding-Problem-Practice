package linkedlist.problems;

public class Node {
	public int data;
	public Node next;
	
	public Node(int data){
		this.data = data;
		this.next = null;
	}
	public Node getNext(){
		return next;
	}
	public void setNext(Node node){
		this.next=node;
	}
	public int getData(){
		return data;
	}
	

}
