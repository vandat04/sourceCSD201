package LinearDataStructure;


import java.util.Scanner;

class Node2{
    int data;
    Node2 next;
    Node2 pre;

    Node2(int data){
        this.data = data;
        next = null;
        pre = null;
    }
}

public class CDoublyLinkedList {
    private Node2 head;
    private Node2 tail;

    CDoublyLinkedList(){
        head = null;
        tail = null;
    }

    public void add(int data){
        Node2 newNode = new Node2(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            head.next = newNode;
            tail.pre = newNode;
        } else {
            tail.next = newNode;
            newNode.pre = tail;
            newNode.next = head;
            head.pre = newNode;
            tail = newNode;
        }
    }

    public void delete(int data){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        Node2 current = head;
        do{
            if(current.data == data){
                if(current == head && current == tail){
                    head = null;
                    tail = null;
                } else if(current == head){
                    tail.next = head.next;
                    head.next.pre = tail;
                    head = head.next;
                } else if (current == tail){
                    tail.pre.next= head;
                    head.pre = tail.pre;
                    tail = tail.pre;
                } else {
                    current.pre.next = current.next;
                    current.next.pre = current.pre;
                }
                System.out.println("Node with data " + data + "has been deleted");
                return;
            }
            current = current.next;
        } while (current != head);
        System.out.println("Node with data " + data + "not found.");
    }

    public void display(){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }

        Node2 current = head;
        do {
            System.out.println(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public boolean search(int data){
        if(head == null){
            return false;
        }

        Node2 current = head;
        do {
            if(current.data == data){
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    public void sort(){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }

        boolean swapped;
        Node2 current;
        do {
            current = head;
            swapped = false;
            do {
                Node2 nextNode = current.next;
                if (current.data > nextNode.data){
                    swapNodes(current, nextNode);
                    swapped = true;
                }
                current = nextNode;
            } while (current != tail);
        } while (swapped);
    }

    private void swapNodes(Node2 node1, Node2 node2){
        if(node1 == node2){
            return;
        }

        if(node1.next == node2){
            Node2 prevNode1 = node1.pre;
            Node2 nextNode2 = node2.next;

            if(prevNode1 != null)
                prevNode1.next = node2;
            node2.pre = prevNode1;

            node2.next = node1;
            node1.pre = node2;
            node1.next = nextNode2;
            if(nextNode2 != null)
                nextNode2.pre = node1;
        } else {
            Node2 prevNode1 = node1.pre;
            Node2 nextNode1 = node1.next;
            Node2 prevNode2 = node2.pre;
            Node2 nextNode2 = node2.next;

            if(prevNode1 != null) prevNode1.next = node2;
            if(nextNode2 != null) nextNode1.pre = node2;

            node2.pre = prevNode1;
            node2.next = nextNode1;

            if (prevNode2 != null) prevNode2.next = node1;
            if (nextNode2 != null) nextNode2.pre = node1;
            node1.pre = prevNode2;
            node1.next = nextNode2;
        }

        if (node1 == head) {
            head = node2;
        } else if (node2 == head) {
            head = node1;
        }
        if (node1 == tail) {
            tail = node2;
        } else if (node2 == tail) {
            tail = node1;
        }

    }
}
