package com.adventures.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	Node root;

	public void printInorder(Node root) {
		if (root == null) {
			return;
		}

		printInorder(root.left);
		System.out.println(root.key + " ");

		printInorder(root.right);
	}

	public void printPreorder(Node root) {
		if (root == null) {
			return;
		}

		System.out.println(root.key + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}

	public void printPostorder(Node root) {
		if (root == null) {
			return;
		}

		printPostorder(root.left);
		printPostorder(root.right);
		System.out.println(root.key + " ");
	}

	/* function to print level order traversal of tree */
	void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	/*
	 * Compute the "height" of a tree -- the number of nodes along the longest path
	 * from the root node down to the farthest leaf node.
	 */
	int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at the given level */
	void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.key + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}
	
	/* Given a binary tree. Print its nodes in level order
    using array for implementing queue  */
   void printLevelOrderUsingQueue() 
   {
       Queue<Node> queue = new LinkedList<Node>();
       queue.add(root);
       while (!queue.isEmpty()) 
       {

           /* poll() removes the present head.
           For more information on poll() visit 
           http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
           Node tempNode = queue.poll();
           System.out.print(tempNode.key + " ");

           /*Enqueue left child */
           if (tempNode.left != null) {
               queue.add(tempNode.left);
           }

           /*Enqueue right child */
           if (tempNode.right != null) {
               queue.add(tempNode.right);
           }
       }
   }
}