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

class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class BST {
    Node root;

    public BST() {
        root = null;
    }
    
    
    public Node insert (int data) {
        if (root == null) {
            return new Node(data);
        }

        Node current = root;
        while (true) {
            if (data < current.data) {
                if (current.left == null) {
                    current.left = new Node(data);
                    break;
                }
                current = current.left;
            } else if (data > current.data) {
                if (current.right == null) {
                    current.right = new Node(data);
                    break;
                }
                current = current.right;
            } else {
                System.out.println("Binary search tree not allows duplicated value.");
                break;
            }
        }
        return root;
    }
    
    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node root, int key) {
        Node current = root;
        Node parent = null;

        // Tìm nút cần xóa và cha của nó
        while (current != null && current.data != key) {
            parent = current;
            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // Nếu không tìm thấy nút
        if (current == null) {
            System.out.println("Not found the given node.");
            return root; // Hoặc thông báo không tìm thấy
        }
        
        // Trường hợp nút có một con hoặc là lá
        else if (current.left == null || current.right == null) {
            Node replacement = (current.left != null) ? current.left : current.right;

            if (parent == null) {
                // Nút cần xóa là gốc
                return replacement;
            }
            if (parent.left == current) {
                parent.left = replacement; // Thay thế liên kết từ cha
            } else {
                parent.right = replacement; // Thay thế liên kết từ cha
            }
        }
        // Trường hợp nút có hai con
        else {
            // Tìm in-order successor (nút nhỏ nhất trong cây con bên phải)
            Node successorParent = current;
            Node successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Sao chép giá trị của successor vào nút hiện tại
            current.data = successor.data;

            // Xóa successor
            if (successorParent != current) {
                successorParent.left = successor.right; // Cập nhật liên kết
            } else {
                successorParent.right = successor.right; // Cập nhật liên kết
            }
        }

        return root;
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
}
