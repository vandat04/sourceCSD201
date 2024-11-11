/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author ASUS
 */
public class pe {

    class Student {

        int id;
        String name;
        String major;
        float score;

        public Student(int id, String name, String major, float score) {
            this.id = id;
            this.name = name;
            this.major = major;
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public float getScore() {
            return score;
        }

        public void setScore(float score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }
    }

    class Node {

        Student data;
        Node left, right;

        public Node(Student data) {
            this.data = data;
            left = right = null;
        }
    }

    class BST {

        Node root;

        BST() {
            root = null;
        }

        public Node insert(Student newStudent) {
            if (root == null) {
                return new Node(newStudent);
            }

            Node current = root;
            while (true) {
                if (newStudent.id < current.data.id) {
                    if (current.left == null) {
                        current.left = new Node(newStudent);
                        break;
                    }
                    current = current.left;
                } else if (newStudent.id > current.data.id) {
                    if (current.right == null) {
                        current.right = new Node(newStudent);
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

        public void inOrder(Node root) {
            if (root == null) {
                return;
            }
            Stack<Node> stack = new Stack<>();
            Node current = root;
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                System.out.println(current.data);
                current = current.right;
            }
        }

        private Node buildBalancedTree(List<Student> values, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (start + end) / 2;
            Node node = new Node(values.get(mid));
            node.left = buildBalancedTree(values, start, mid - 1);
            node.right = buildBalancedTree(values, mid + 1, end);

            return node;
        }
    }
}
