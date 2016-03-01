package linkedlist.problems;

public class FindElement {
	
	public int getIndexOfElement(Node head,int data){
		int index=0;
		Node current = head;
		while(current.getNext()!=null){
			index++;
			current = current.getNext();
		}
		return index;
	}
	
	public Node getNthToLast(Node head, int n){
		Node first = head;
		Node second = head;
		
		for(int i=0;i<n;i++){
			first = first.getNext();
		}
		
		while(first != null){
			second = second.getNext();
			first = first.getNext();
		}
		return second;
		
	}

}
