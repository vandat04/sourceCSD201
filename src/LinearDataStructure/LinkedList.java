package LinearDataStructure;


public class LinkedList {
    Node head;

    static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
    }

}
