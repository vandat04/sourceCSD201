/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ASUS
 */

class Node{
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }
    
    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left == null) {
                current.left = new Node(data);
                break;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = new Node(data);
                break;
            } else {
                queue.add(current.right);
            }
        }
    }
    
    public int findMin(){
        if(root == null)
            throw new IllegalStateException("Tree is empty");
        
        int min = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            min = Math.min(min, current.data);
            
            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
        return min;
    }
    
    
    public int findMax(){
        if(root == null)
            throw new IllegalStateException("Tree is empty");
        
        int max = Integer.MIN_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            max = Math.max(max, current.data);
            
            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
        return max;
    }
    
   
    public int countNodes(){
        if(root == null)
            return 0;
        
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            count++;
            
            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
        return count;
    }
    
    public int findHeight() {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int nodesAtCurrentLevel = queue.size();
            height++;

            // Process all nodes at the current level
            for (int i = 0; i < nodesAtCurrentLevel; i++) {
                Node current = queue.poll();

                // Enqueue left and right children
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return height;
    }


    
    
}
