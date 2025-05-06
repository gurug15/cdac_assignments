package com.question.one;

import com.question.one.entity.BinaryTree;

public class One {
	
	
		
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
	
		bt.preOrder();
		bt.inOrder();
		bt.postOrder();
		bt.nodeCount();
		bt.leafCount();
		bt.valueCount(7);

	}

}
