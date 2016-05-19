package linkedlist.problems;

/**
 * 
 * @author dharmik patel
 * Detect if the Linked List has a loop.
 * If it has a loop than return intersecting node
 * if it has no loop than return null
 * Ex: Assume this is input.
 * Input: A -> B -> C -> D -> E -> F-> C
 * Output: C 
 *
 */
public class LoopDetection {
	//we will use runner method here
	public Node getInterSectingNode(Node head){
		Node slow = head;
		Node fast = head;
		//check if collision is there
		while(fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			//collision detected 
			if(fast == slow){
				break;
			}
		}
		//if no collision then return null
		if(fast == null || fast.getNext() == null){
			return null;
		}
		//fast is exactly K places away to intersecting node
		//so is head.
		slow = head;
		//move to intersecting node
		while(slow != fast){
			slow = slow.getNext();
			fast = fast.getNext();
		}
		
		return fast;
		
		
	}

}
