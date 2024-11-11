/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package LinearDataStructure;

/**
 *
 * @author ASUS
 */
public class Queue{
    int rear, front;
    int size;
    int items[];
    
    Queue(int size){
        this.size = size;
        items = new int[size];
        front = -1;
        rear = -1;
    }
    
    boolean isFull(){
        return front == 0 && rear == size - 1;
    }
    
    boolean isEmpty(){
        return front == -1;
    }
    
    void enQueue(int new_element){
        if(isFull()){

            System.out.println("Queue is full.");
        } else {
            if(front == -1)
                front = 0;
            rear++;
            items[rear] = new_element;
            System.out.println("Inserted : " + new_element);
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
                front++;
            }
            System.out.println("Deleted: " + element);
            return element;
        }
    }
    
    void display(){
        
    }
}