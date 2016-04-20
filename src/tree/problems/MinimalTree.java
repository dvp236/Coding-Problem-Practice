package tree.problems;

/**
 * 
 * @author dharmik
 * Generate a Binary Tree with minimum height 
 * from the given sorted array of unique element
 * 
 */
public class MinimalTree {
	
	//A good strategy can be to pick the middle element of array and
	//make it root element, since the array is sorted.
	
	public TreeNode generateMinimalTree(int[] a){
		TreeNode root = generateMinimalTree(a,0,a.length-1);
		return root;
	}
	
	//Creating recursive function to generate a tree
	private static TreeNode generateMinimalTree(int[] a, int start, int end){
		if(start >= end){
			return null;
		}
		//Create root node from the mid element
		int mid = (start + end)/2;
		TreeNode root = new TreeNode(a[mid]);
		
		//generate left subtree with values less than mid element and right subtree vice versa
		root.left = generateMinimalTree(a, start, mid-1);
		root.right = generateMinimalTree(a, mid+1, end);
		return root;
	}
}
