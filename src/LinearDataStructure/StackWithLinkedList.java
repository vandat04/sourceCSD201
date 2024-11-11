/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinearDataStructure;

/**
 *
 * @author ASUS
 */
class Node{
    int data;
    Node next;
    Node(int new_date){
        this.data = new_date;
        this.next = null;
    }
}


public class StackWithLinkedList {
    Node head;
    StackWithLinkedList(){
        head = null;
    }
    
    boolean isEmpty(){
        return head == null;
    }
    
    void push(int new_data){
        Node new_node = new Node(new_data);
        if(new_node == null){
            System.out.println("Stack Overflow");
            return;
        }
        new_node.next = head;
        head = new_node;
    }
    
    void pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return;
        }
        Node temp = head;
        head = head.next;
        temp = null;
    }
    
    int peek(){
        if(!isEmpty()){
            return head.data;
        } else {
            System.out.println("Stack is empty.");
            return Integer.MIN_VALUE;
        }
    }
    public static void main(String[] args) {
        StackWithLinkedList st = new StackWithLinkedList();
        st.push(13);
        st.push(14);
        st.push(12);
        st.push(16);
        
        System.out.println("Top element is: " + st.peek());
        
        System.out.println("Removing two elements...");
        st.pop();
        st.pop();

        System.out.println("Top element is : " + st.peek());
    }
}

