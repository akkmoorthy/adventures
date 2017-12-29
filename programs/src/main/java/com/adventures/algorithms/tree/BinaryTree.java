package com.adventures.algorithms.tree;

class Node {
	int key;
	Node left;
	Node right;

	Node(int key) {
		this.key = key;
		left = right = null;
	}
}

public class BinaryTree {

	Node root;

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		/*create root*/
		tree.root = new Node(1);

		/* following is the tree after above statement
		 
        1
      /   \
    null  null     */
		
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		
		/* 2 and 3 become left and right children of 1
        	1
      	  /   \
     	2      3
   		/    \    /  \
 	 null null null null  */

		tree.root.left.left = new Node(4);
		tree.root.right.right = new Node(5);
		
		/* 4 becomes child of 2 and 5 becomes child of 3
    	1
  	  /   \
 	2      3
		/    \    /  \
	 null null null null  */

	}
}