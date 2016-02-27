package linkedlist.problems;

import java.util.HashSet;

/**
 * 
 * @author dharmik
 * Write a method to remove duplicate values from unsorted list
 *
 */
public class RemoveDuplicates {
	
	//Time Complexity O(N) as it loops through N nodes
	public void removeDuplicates(Node head){
		
		//Taking HashSet to store the data of list
		HashSet<Integer> hset= new HashSet<Integer>();
		Node currentNode=head;
		Node prevNode=null;
		
		//iterate through the linkedlist
		while(currentNode != null){
			
			//Check if the data is already present in the set
			if(hset.contains(currentNode.getData())){
				
				//if present just attach the previous node to next coming node
				prevNode.setNext(currentNode.getNext());
				
			}else{
				
				//add the new value in the HashSet
				hset.add(currentNode.getData());
				prevNode = currentNode;
			}
			
			currentNode = currentNode.getNext();
		}
		
	}
}
