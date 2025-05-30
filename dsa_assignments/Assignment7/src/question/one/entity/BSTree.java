package question.one.entity;

import java.util.LinkedList;
import java.util.Queue;

public class BSTree {
	private BTNode root;
	
	public BSTree() {
		
	}
	
	public int height() {
		return height(root);
	}
	
	public int heightQ() {
		 Queue<BTNode> q = new LinkedList<>();
		 if(root==null) return 0;
		 	q.add(root);
		 
		 int count = -1;
		 while(!q.isEmpty()) {
			 int level = q.size();
			 count++;
			 for(int i=0;i<level;i++) {
			 BTNode current = q.poll();
			 if(current.left != null) {
				 q.add(current.left);
			 }
			 if(current.right != null) {
				 q.add(current.right);
			 }
			 }
		 }
		 
		 return count;
	}
	
	public int smallestInBST() {
		
		BTNode current = root;
		if(root == null) return 0;
		while(current.left != null) {
			current = current.left;
		}
		
		return current.value;
	}
	
	
	private int height(BTNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 0;
	
		
		return 1 + Integer.max((root.left!=null)?height(root.left):0, (root.right!=null)?height(root.right):0);
		
	}
	
	public int largestInBST() {
		if(root == null) return 0;
		BTNode current = root;
		while(current.right != null) {
			current = current.right;
		}
		
		return current.value;
	} 
	
	
	public void insert(int ele) {
		BTNode node = new BTNode(ele);
		if(root == null) {
			root = node;
			System.out.println(ele + " Inserted at root");
			return;
		}
		BTNode current = root;
		while(current != null) {
			if(current.value>ele) {
				if(current.left == null) {
				current.left = node;
				System.out.println(ele + " Inserted at left to "+ current.value);
				return;
				}
				current = current.left;
			}else {
				if(current.right == null) {
					current.right = node;
					System.out.println(ele + " Inserted at right of "+ current.value);
					return;
				}
				current = current.right;
			}
		}
		
	}
	
	public void delete(int element) {
		BTNode parent = null;
		BTNode current = root;
		while(current != null) {
			if(current.value == element) break;
			parent = current;
			
			if(element<current.value) {
				current = current.left;
			}else {
				current = current.right;
			}	
		}
		
		if(current == null) {
			System.out.println("No element Found");
			return;
		}
		
		if(current.left == null && current.right == null) {
			if(parent.left.value == element) {
				parent.left = null;
			}else {
				parent.right = null;
			}
			return;
		}
		
		if(current.left == null) {
			if(parent.left.value == element) {
				parent.left = current.right;
			}else {
				parent.right= current.right;
			}
			return;
		}
		
		if(current.right == null) {
			if(parent.left.value == element) {
				parent.left = current.left;
			}else {
				parent.right = current.left;
			}
			return;
		}
		
		
		current.value = inOrderPred(current).value;
		deleteInOrderPred(current, inOrderPred(current));
		
		
	}
	private void deleteInOrderPred(BTNode iopParent, BTNode iOP) {
	    // If iOP is a leaf node, simply remove it
	    if (iOP.left == null && iOP.right == null) {
	        if (iopParent.left == iOP) {
	            iopParent.left = null;
	        } else {
	            iopParent.right = null;
	        }
	    }
	    // If iOP has a left child, bypass iOP by linking parent to the child
	    else if (iOP.left != null) {
	        if (iopParent.left == iOP) {
	            iopParent.left = iOP.left;
	        } else {
	            iopParent.right = iOP.left;
	        }
	    }
	}
	
	private BTNode inOrderPred(BTNode current) {
		if(current == null) return current;
		BTNode iOP = current.left;
		while(iOP.right != null) {
			iOP = iOP.right;
		}
		
		return iOP;
	}

}
