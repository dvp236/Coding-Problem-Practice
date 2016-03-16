package linkedlist.problems;

public class FindElement {
	
	
	//Gives the index of Element
	//Time Complexity O(n)
	public int getIndexOfElement(Node head,int data){
		int index=0;
		Node current = head;
		
		//loop over the linked list until the data matches the node data
		while(current.getNext()!=null){
			if(current.getData() == data){
				return index;
			}
			index++;
			current = current.getNext();
		}
		return -1;
	}
	
	//Returns the NthtoLastNode
	//For Ex: getNthToLast(head,0) would return last Node
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
