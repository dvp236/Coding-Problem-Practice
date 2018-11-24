package tree.problems;

import java.util.ArrayList;
import edu.princeton.cs.algs4.Queue;

public class PrintPath {
	TreeNode root;
	
	public void insert(int data) {
		root = insertHelper(root,data);
	}
	
	private TreeNode insertHelper(TreeNode node, int data) {
		if (node == null) return new TreeNode(data);
		if (data > node.data) {
			node.right = insertHelper(node.right, data);
		}else {
			node.left = insertHelper(node.left, data);
		}
		return node;
	}
	
	public int min() {
		return min(root).data;
				
	}
	
	private TreeNode min(TreeNode node) {
		if (node.left == null) return node;
		return min(node.left);
	}
	
	public void getPath(int data) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		boolean haspath = hasPath(root, arr, data);
		if (haspath) {
			//System.out.println(arr);
			for(Integer p : arr) {
				System.out.print(p+"->");
			}
		}
		
	}
	private boolean hasPath(TreeNode node, ArrayList<Integer> arr, int data) {
		if (node == null) return false;
		if (node.data == data) {
			arr.add(node.data);
			return true;
		}
		boolean path = hasPath(node.left, arr, data) || hasPath(node.right, arr, data);
		if (path) {
			arr.add(node.data);
			return true;
		}
		return false;
	}
	
	public void printLevelOdrer() {
		Queue<TreeNode> q = new Queue<TreeNode>();
		q.enqueue(root);
		while (!q.isEmpty()){
			TreeNode node = q.dequeue();
			if (node == null) continue;
			System.out.print(node.data+" ");
			q.enqueue(node.left);
			q.enqueue(node.right);
		}
	}
	public void printInorder() {
		printInHelper(root);
	}
	
	private void printInHelper(TreeNode node) {
		if(node == null) return;
		printInHelper(node.left);
		System.out.print(node.data+" ");
		printInHelper(node.right);
	}
	
	public void printPreSantosh(){
		preordersan(root);
	}
	
	private void preordersan(TreeNode node) {
		if (node == null) return;
		System.out.print(node.data+" ");
		preordersan(node.left);
		preordersan(node.right);
	}
	public static void main(String[] args) {
		PrintPath p = new PrintPath();
		p.insert(5);
		p.insert(3);
		p.insert(1);
		p.insert(7);
		p.insert(6);
		p.insert(0);
		p.insert(2);
		p.insert(8);
		p.insert(9);
		//p.printInorder();
		p.getPath(9);
		System.out.println();
		p.printLevelOdrer();
		System.out.println();
		//p.printPreSantosh();
		
	}
}
