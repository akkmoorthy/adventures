package com.adventures.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftVIew {
    public static void main(String args[])
    {
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.right.left=new Node(40);
        root.right.right=new Node(50);

        printLeftMethod1(root, 1);
        System.out.println();
        printLeftMethod2(root);
    }

    static int maxLevel=0;
    public static void printLeftMethod1(Node root,int level){
        if(root==null)
            return;
        if(maxLevel<level){
            System.out.print(root.key+" ");
            maxLevel=level;
        }
        printLeftMethod1(root.left,level+1);
        printLeftMethod1(root.right,level+1);
    }


    public static void printLeftMethod2(Node root){
        if(root==null)
            return;
        Queue<Node > q=new LinkedList<>();q.add(root);
        while(q.isEmpty()==false){
            int count=q.size();
            for(int i=0;i<count;i++){
                Node curr=q.poll();
                if(i==0)
                    System.out.print(curr.key+" ");
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
    }
}