    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package LinearDataStructure;

    import java.util.Deque;
    import java.util.Queue;

    /**
     *
     * @author ASUS
     */
    public class Stack{
            private int arr[];
            private int top;
            private int capacity;
            
            Stack(int size){
                arr = new int [size];
                capacity = size;
                top = -1;
            }
            public void push(int element){
                if(isFull()){
                    System.out.println("Overflow");
                    System.exit(1);
                } else {
                    System.out.println("Inserting " + element);
                    arr[++top] = element;
                }
            }
            public int pop(int element){
                if(isEmpty()){
                    System.out.println("Stack is empty.");
                    System.exit(1);
                }
                    return arr[top--];
            }
            public int size(){
                return top + 1;
            }
            public Boolean isFull(){
                return top == capacity - 1;
            }
            public Boolean isEmpty(){
                return top == -1;
            }
            public void printStack(){
                for(int i = 0; i < capacity; i++){
                    System.out.println(arr[i]);
                }
            }
            
       }

