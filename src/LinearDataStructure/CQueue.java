/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinearDataStructure;

/**
 *
 * @author ASUS
 */
public class CQueue{
    int size;
    int front, rear;
    int items[];
    public CQueue(int size){
        this.size = size;
        front = -1;
        rear = -1;
        items = new int[size];
    }

    boolean isFull(){
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    boolean isEmpty(){
        return front == -1;
    }

    void enQueue(int element){
        if(isFull()){
            System.out.println("Queue is full");
        } else {
            if(front == -1)
                front = 0;
            rear = (rear + 1) % size;
            items[rear] = element;
            System.out.println("Inserted " + element + " at " + rear);
        }
    }
    int deQueue(){
        int element;
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        } else {
            element = items[front];
            if(front == rear){
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return element;
        }
    }

    void display(){
        int i;
        if(isEmpty()){
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front -> " + front);
            System.out.print("Item -> ");
            for(i = front; i != rear; i = (i + 1) % size){
                System.out.print(items[i] + " ");
            }
            System.out.println(items[i]);
            System.out.println("Rear -> " + rear);
        }
    }
    public static void main(String[] args) {

        CQueue q = new CQueue(5);

        // Fails because front = -1
        q.deQueue();

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // Fails to enqueue because front == 0 && rear == SIZE - 1
        q.enQueue(6);

        q.display();

        int elem = q.deQueue();

        if (elem != -1) {
            System.out.println("Deleted Element is " + elem);
        }
        q.display();

        q.enQueue(7);

        q.display();

        // Fails to enqueue because front == rear + 1
        q.enQueue(8);
    }

}