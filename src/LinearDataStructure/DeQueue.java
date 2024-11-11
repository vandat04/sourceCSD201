package LinearDataStructure;

public class DeQueue {
    int rear, front;
    int size;
    int []items;

    DeQueue(int size){
        this.size = size;
        items = new int[size];
        rear = -1;
        front = -1;
    }

    boolean isFull(){
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    boolean isEmpty(){
        return front == -1;
    }

    void insertFront(int item) throws RuntimeException{
        if(isFull()){
            throw new RuntimeException("Overflow");
        }

        if(front == -1){
            front = 0;
            rear = 0;
        } else if (front == 0){
            front = size - 1;
        } else {
            front = front - 1;
        }
        items[front] = item;
    }

    void insertRear(int item) throws RuntimeException{
        if(isFull()){
            throw new RuntimeException("Overflow");
        }

        if(front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == size - 1){
            rear = 0;
        } else {
            rear = rear + 1;
        }
        items[rear] = item;
    }

    int removeFront() throws RuntimeException{
        if(isEmpty()){
            throw new RuntimeException("Underflow");
        }

        int item = items[front];

        if(front == rear){
            front = -1;
            rear = -1;
        } else if (front == size - 1){
            front = 0;
        } else {
            front = front + 1;
        }
        return item;
    }

    int removeRear() throws RuntimeException{
        if(isEmpty()){
            throw new RuntimeException("Underflow");
        }

        int item = items[rear];

        if(front == rear){
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear = rear - 1;
        }
        return item;
    }

    int getFront() throws RuntimeException{
        if(isEmpty()){
            throw new RuntimeException("Underflow");
        }
        return items[front];
    }

    int getRear() throws RuntimeException{
        if(isEmpty()){
            throw new RuntimeException("Underflow");
        }
        return items[rear];
    }
}


