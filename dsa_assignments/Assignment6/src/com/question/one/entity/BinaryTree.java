package com.question.one.entity;

public class BinaryTree {
	private BTnode root;
	
	
	public BinaryTree() {
		insertElement();
	}
	public void inOrder() {
		inOrder(root);
		System.out.println();
	}
	
	public void postOrder() {
		
		postOrder(root);
		System.out.println();
	}
	
	public void preOrder() {
		
		preOrder(root);
		System.out.println();
	}
	
	public void nodeCount() {
		System.out.println("Num of nodes are: " +nodeCount(root));
	}
	
	private void inOrder(BTnode root) {
		if(root == null) return;
		if(root.left != null) inOrder(root.left);
		System.out.print(root.element+ " ");
		if(root.right != null) inOrder(root.right);
	}
	
	private int nodeCount(BTnode root) {
		if(root == null) return 0;
		return 1 + nodeCount(root.left) + nodeCount(root.right);
		//System.out.print(root.element+ " ");
		 
	}
	public void leafCount() {
		System.out.println("leaf node count : " + leafCount(root));
		 
	}
	
	private int leafCount(BTnode root) {
		if(root == null) return 0;
			if(root.left == null && root.right == null) {
				return 1;
			}
	   
			return  leafCount(root.left) + leafCount(root.right);
		 
	}
	
	public void valueCount(int value) {
		System.out.println("No of elements: " + valueCount(root, value));
	}
	
	private int valueCount(BTnode root,int value) {
		if(root == null) return 0;
	
		if(value == root.element) return 1;
		return valueCount(root.right,value) + valueCount(root.left,value);
		 
	}
	
	
	private void postOrder(BTnode root) {
		if(root == null) return;
		if(root.left != null) postOrder(root.left);
		if(root.right != null) postOrder(root.right);
		System.out.print(root.element+ " ");
	}
	private void preOrder(BTnode root) {
		if(root == null) return;
		System.out.print(root.element+ " ");
		
		if(root.left != null) preOrder(root.left);	
		if(root.right != null) preOrder(root.right);
		
	}
	
	private void insertElement() {
		root = new BTnode(5);
		BTnode n2 = new BTnode(4);
		BTnode n3 = new BTnode(3);
		BTnode n4 = new BTnode(2);
		BTnode n5 = new BTnode(1);
		BTnode n6 = new BTnode(6);
		root.left = n2;
		root.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
	}
	
}
