/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

import AdvantageDSA.*;
import java.util.Stack;

/**
 *
 * @author ASUS
 */
class Node<T> {

    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TraversalBT {

    public void postOrderV2(Node root) {
        if (root == null) {
            return;
        }

        postOrderV2(root.left);
        postOrderV2(root.right);
        System.out.print(root.data + " ");
    }

    public void postOrder(Node root) {
        if (root == null) {
            throw new NullPointerException("Tree is empty.");
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }

            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }
    
    public void inOrderV2(Node root){
        if(root == null)
            return;
        inOrderV2(root.left);
        System.out.print(root.data + " ");
        inOrderV2(root.right);
    }
    
    public void inOrder(Node root){
        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }
    
    public void preOrder(Node root){
        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.data + " ");
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
    }
    
    public void preOrderV2(Node root){
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preOrderV2(root.left);
        preOrderV2(root.right);
    }
}
