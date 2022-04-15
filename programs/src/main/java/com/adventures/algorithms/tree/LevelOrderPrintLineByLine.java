package com.adventures.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderPrintLineByLine {


    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        printLevelMethod1(root);
        System.out.println();
        printLevelMethod2(root);
    }

    public static void printLevelMethod1(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (q.size() > 1) {
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.print(curr.key + " ");
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    public static void printLevelMethod2(Node root){
        if(root==null)return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(q.isEmpty()==false){
            int count=q.size();
            for(int i=0;i<count;i++){
                Node curr=q.poll();
                System.out.print(curr.key+" ");
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            System.out.println();
        }
    }
}