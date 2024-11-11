package Tree;

import java.util.Optional;
import java.util.Stack;

class AVLTree {

        class Node {
            int key, height;
            Node left, right;

            Node(int key) {
                this.key = key;
                this.height = 1;
            }
        }

        private Node root;

        // Get height of the node
        private int height(Node node) {
            return node == null ? 0 : node.height;
        }

        // Update height of the node
        private void updateHeight(Node node) {
            node.height = Math.max(height(node.left), height(node.right)) + 1;
        }

        // Get balance factor of the node
        private int getBalance(Node node) {
            return node == null ? 0 : height(node.left) - height(node.right);
        }

        // Right rotation
        private Node rightRotate(Node y) {
            Node x = y.left;
            y.left = x.right;
            x.right = y;
            updateHeight(y);
            updateHeight(x);
            return x;
        }

        // Left rotation
        private Node leftRotate(Node x) {
            Node y = x.right;
            x.right = y.left;
            y.left = x;
            updateHeight(x);
            updateHeight(y);
            return y;
        }

        // Insert a key into the AVL tree
        public void insert(int key) {
            root = insert(root, key);
        }

        private Node insert(Node node, int key) {
            if (node == null) return new Node(key);

            if (key < node.key) {
                node.left = insert(node.left, key);
            } else if (key > node.key) {
                node.right = insert(node.right, key);
            } else {
                return node; // Duplicate keys not allowed
            }

            updateHeight(node);
            return balance(node);
        }

    // Delete a key from the AVL tree
    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) return node;

        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            // Node with one child or no child
            Node replacement = (node.left == null) ? node.right : node.left;

            if (replacement == null) return null; // No child case
            node = replacement; // One child case

            // Node with two children
            Node successor = findMin(node.right);
            node.key = successor.key; // Replace with the successor's key
            node.right = delete(node.right, successor.key); // Delete the successor
        }

        updateHeight(node);
        return balance(node);
    }

    // Find the minimum node
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node balance(Node node) {
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node; // Already balanced
    }

    // Non-recursive inorder traversal
    public void inorder() {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.key + " ");
            current = current.right;
        }
        System.out.println();
    }

    // Non-recursive preorder traversal
    public void preorder() {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.key + " ");

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        System.out.println();
    }

    // Non-recursive postorder traversal
    public void postorder() {
        if (root == null) return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node current = stack1.pop();
            stack2.push(current);

            if (current.left != null) stack1.push(current.left);
            if (current.right != null) stack1.push(current.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().key + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        avl.insert(30);
        avl.insert(20);
        avl.insert(40);
        avl.insert(10);
        avl.insert(25);
        avl.insert(35);
        avl.insert(50);

        System.out.println("Inorder traversal of the AVL tree:");
        avl.inorder();

        System.out.println("Preorder traversal of the AVL tree:");
        avl.preorder();

        System.out.println("Postorder traversal of the AVL tree:");
        avl.postorder();

        System.out.println("Deleting 10:");
        avl.delete(10);
        avl.inorder();

        System.out.println("Deleting 30:");
        avl.delete(30);
        avl.inorder();
    }
}
