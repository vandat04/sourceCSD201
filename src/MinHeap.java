package PE;

import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[this.maxSize + 1];
        // Phần tử đầu tiên không sử dụng để thuận tiện tính toán chỉ số
        this.heap[0] = Integer.MIN_VALUE;
    }

    // Phương thức lấy chỉ số cha
    private int parent(int pos) {
        return pos / 2;
    }

    // Phương thức lấy chỉ số con trái
    private int leftChild(int pos) {
        return 2 * pos;
    }

    // Phương thức lấy chỉ số con phải
    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    // Phương thức kiểm tra vị trí có phải lá không
    private boolean isLeaf(int pos) {
        return (pos > size / 2) && (pos <= size);
    }

    // Phương thức hoán đổi hai vị trí
    private void swap(int fpos, int spos) {
        int tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    // Phương thức thêm phần tử vào heap
    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }
        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Search method to find the index of an element
    public int search(int element) {
        for (int i = 1; i <= size; i++) {
            if (heap[i] == element) {
                return i;
            }
        }
        return -1; // Element not found
    }

    // Delete method to remove an element at a specific index
    public void delete(int element) {
        int index = search(element);
        if (index == -1) {
            System.out.println("Element not found in the heap.");
            return;
        }

        // Replace the element to be deleted with the last element
        heap[index] = heap[size--];

        // Restore the heap properties by heapifying up and down
        int parentIndex = parent(index);
        if (index > 1 && heap[index] < heap[parentIndex]) {
            while (index > 1 && heap[index] < heap[parent(index)]) {
                swap(index, parent(index));
                index = parent(index);
            }
        } else {
            minHeapify(index);
        }
    }

    // Phương thức điều chỉnh heap (Heapify) từ vị trí chỉ định
    private void minHeapify(int pos) {
        if (isLeaf(pos)) {
            return;
        }

        if (leftChild(pos) <= size && (heap[pos] > heap[leftChild(pos)]) ||
                (rightChild(pos) <= size && heap[pos] > heap[rightChild(pos)])) {
            if (rightChild(pos) > size || heap[leftChild(pos)] < heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                minHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                minHeapify(rightChild(pos));
            }
        }
    }

    // Phương thức xóa phần tử nhỏ nhất (gốc)
    public int extractMin() {
        int popped = heap[1];
        heap[1] = heap[size--];
        minHeapify(1);
        return popped;
    }

    // Pre-order traversal (Root, Left, Right)
    public void preOrderTraversal(int pos) {
        if (pos > size) return;
        System.out.print(heap[pos] + " ");
        preOrderTraversal(leftChild(pos));
        preOrderTraversal(rightChild(pos));
    }

    // In-order traversal (Left, Root, Right)
    public void inOrderTraversal(int pos) {
        if (pos > size) return;
        inOrderTraversal(leftChild(pos));
        System.out.print(heap[pos] + " ");
        inOrderTraversal(rightChild(pos));
    }

    // Post-order traversal (Left, Right, Root)
    public void postOrderTraversal(int pos) {
        if (pos > size) return;
        postOrderTraversal(leftChild(pos));
        postOrderTraversal(rightChild(pos));
        System.out.print(heap[pos] + " ");
    }

    // Phương thức in heap
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print("Cha: " + heap[i] +
                    " Trái: " + heap[2 * i] +
                    " Phải: " + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] arg) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(15);
        minHeap.insert(20);
        minHeap.insert(30);
        minHeap.insert(10);

        System.out.println("Min-Heap:");
        minHeap.print();
        System.out.println("Phần tử nhỏ nhất là: " + minHeap.extractMin());

        System.out.println("\nTìm và xóa phần tử 20:");
        minHeap.delete(20);
        minHeap.print();

        System.out.println("\nPre-order Traversal:");
        minHeap.preOrderTraversal(1);

        System.out.println("\nIn-order Traversal:");
        minHeap.inOrderTraversal(1);

        System.out.println("\nPost-order Traversal:");
        minHeap.postOrderTraversal(1);
    }
}
