package Tree;

import AdvantageDSA.*;
import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    // Insert a new element into the heap
    public void insert(int value) {
        if (size == capacity) increaseCapacity();
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    // Get the maximum element (root of the heap) without removing it
    public int peek() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return heap[0];
    }

    // Remove and return the maximum element (root of the heap)
    public int poll() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        int root = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = 0; // Clear reference to removed element
        size--;
        heapifyDown(0);
        return root;
    }

    // Delete an element at a specific index
    public void delete(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        heap[index] = heap[size - 1];
        heap[size - 1] = 0; // Clear reference to removed element
        size--;

        // Determine direction of heapify based on new value at index
        if (index > 0 && heap[index] > heap[parent(index)]) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }
    }

    // Build heap from an existing array
    public void buildHeap(int[] array) {
        size = array.length;
        capacity = size;
        heap = Arrays.copyOf(array, capacity);

        // Start heapifying from the last non-leaf node
        for (int i = parent(size - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // Heapify up to maintain the max-heap property
    private void heapifyUp(int i) {
        int temp = heap[i];
        while (i > 0 && temp > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = temp;
    }

    // Heapify down to maintain the max-heap property
    private void heapifyDown(int i) {
    while (true) {
        int greatest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[greatest]) {
            greatest = left;
        }

        if (right < size && heap[right] < heap[greatest]) {
            greatest = right;
        }

        // Nếu `smallest` không thay đổi, heap đã hợp lệ
        if (greatest == i) {
            break;
        }

        // Hoán đổi và cập nhật chỉ số `i` để tiếp tục duy trì heap
        swap(i, greatest);
        i = greatest;
        }
    }

    // Swap elements in the heap array
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Increase the capacity of the heap array
    private void increaseCapacity() {
        capacity *= 2;
        heap = Arrays.copyOf(heap, capacity);
        System.out.println("Heap capacity increased to " + capacity);
    }

    // Print heap elements
    public void printHeap() {
        System.out.println("Heap array: " + Arrays.toString(Arrays.copyOf(heap, size)));
    }
}
