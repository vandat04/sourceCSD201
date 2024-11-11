package PE;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[this.maxSize + 1];
        // Phần tử đầu tiên không sử dụng để thuận tiện tính toán chỉ số
        this.heap[0] = Integer.MAX_VALUE;
    }

    // Lấy chỉ số cha
    private int parent(int pos) {
        return pos / 2;
    }

    // Lấy chỉ số con trái
    private int leftChild(int pos) {
        return 2 * pos;
    }

    // Lấy chỉ số con phải
    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    // Kiểm tra vị trí có phải là lá không
    private boolean isLeaf(int pos) {
        return (pos > size / 2) && (pos <= size);
    }

    // Hoán đổi hai vị trí
    private void swap(int fpos, int spos) {
        int tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    // Thêm phần tử vào heap
    public void insert(int element) {
        if (size >= maxSize) {
            return; // Nếu heap đã đầy, không thêm phần tử mới
        }
        heap[++size] = element; // Thêm phần tử vào cuối
        int current = size;

        // Duy trì tính chất của MaxHeap
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Điều chỉnh heap (Heapify) từ vị trí chỉ định
    private void maxHeapify(int pos) {
        if (isLeaf(pos)) {
            return; // Nếu là lá, không làm gì cả
        }

        // Kiểm tra và hoán đổi nếu cần
        if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
            if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    // Xóa phần tử lớn nhất (gốc)
    public int deleteMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap trống");
        }
        int popped = heap[1]; // Lưu giá trị lớn nhất
        heap[1] = heap[size--]; // Đưa phần tử cuối lên gốc
        maxHeapify(1); // Điều chỉnh heap
        return popped;
    }

    // Cập nhật phần tử tại vị trí chỉ định
    public void update(int pos, int newValue) {
        if (pos < 1 || pos > size) {
            throw new IndexOutOfBoundsException("Vị trí không hợp lệ");
        }

        int oldValue = heap[pos];
        heap[pos] = newValue; // Cập nhật giá trị mới

        // Nếu giá trị mới lớn hơn, di chuyển lên
        if (newValue > oldValue) {
            while (pos > 1 && heap[pos] > heap[parent(pos)]) {
                swap(pos, parent(pos));
                pos = parent(pos);
            }
        } else {
            // Nếu giá trị mới nhỏ hơn, di chuyển xuống
            maxHeapify(pos);
        }
    }

    // Xóa một phần tử tại vị trí chỉ định
    public void delete(int pos) {
        if (pos < 1 || pos > size) {
            throw new IndexOutOfBoundsException("Vị trí không hợp lệ");
        }

        // Thay thế bằng phần tử cuối cùng
        heap[pos] = heap[size--];
        maxHeapify(pos); // Điều chỉnh heap
    }

    // In heap
    // public void print() {
    // for (int i = 1; i <= size / 2; i++) {
    // System.out.print("Cha: " + heap[i] +
    // " Trái: " + heap[2 * i] +
    // " Phải: " + heap[2 * i + 1]);
    // System.out.println();
    // }
    // }
    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.println(heap[i]);
        }
    }

    public static void main(String[] arg) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(30);
        maxHeap.insert(10);

        System.out.println("Max-Heap:");
        maxHeap.print();

        System.out.println("Phần tử lớn nhất là: " + maxHeap.deleteMax());

        // // Insert tasks into the heap
        // System.out.println("Inserting tasks into the MaxHeap:");
        // for (MaxHeap task : tasks) {
        // maxHeap.insert(task);
        // System.out.println("Inserted: " + task);
        // }

        // Cập nhật phần tử tại vị trí 2
        System.out.println("Cập nhật vị trí 2 thành 25");
        maxHeap.update(2, 25);
        maxHeap.print();

        // Xóa phần tử tại vị trí 1
        System.out.println("Xóa phần tử tại vị trí 1");
        maxHeap.delete(1);
        maxHeap.print();
    }
}