package LinearDataStructure;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class QueueWithLinkedList {
    Node front;
    Node rear;
    public QueueWithLinkedList(int size){
        front = null;
        rear = null;
    }

    boolean isEmpty(){
        return front == null;
    }

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }


    int dequeue(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return -1;
        } else {
            int element = front.data;
            front = front.next;
            if(front == null)
                rear = null;
            return element;
        }
    }

    void display(){
        if(isEmpty()){
            System.out.println("Underflow.");
        } else {
            Node temp = front;
            System.out.println("Items -> ");
            while(temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
