package tree.problems;

/**
 * 
 * @author dharmik
 * Generate a Binary Tree with minimum height 
 * from the given sorted array of unique element
 * 
 */
public class MinimalTree {
	public TreeNode generateMinimalTree(int[] a){
		TreeNode root = generateMinimalTree(a,0,a.length-1);
		return root;
	}
	
	private static TreeNode generateMinimalTree(int[] a, int start, int end){
		if(start >= end){
			return null;
		}
		int mid = (start + end)/2;
		TreeNode root = new TreeNode(a[mid]);
		root.left = generateMinimalTree(a, start, mid-1);
		root.right = generateMinimalTree(a, mid+1, end);
		return root;
	}
}
