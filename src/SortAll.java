package MySort;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

class Sorting {

    void merge(int[] a, int low, int mid, int high) {
        int i, j, k;
        //create a temporary array b and copy a to b
        int[] b = new int[a.length];
        for (i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        i = low;
        j = mid + 1;
        k = low;
        while (i <= mid && j <= high) {
            if (b[i] > b[j]) {
                a[k++] = b[j++];
            } else {
                a[k++] = b[i++];
            }
        }
        while (i <= mid) {
            a[k++] = b[i++];
        }
        while (j <= high) {
            a[k++] = b[j++];
        }
    }

    void mergesort(int[] a, int low, int high) {
        if (low < high) {
            int k = (low + high) / 2;
            mergesort(a, low, k);
            mergesort(a, k + 1, high);
            merge(a, low, k, high);
        }
    }

    //quicksort O(nlogn)
    int partition(int[] a, int low, int high) {
        int i = low, j = high, pivot;
        pivot = a[i];
        while (i < j) {
            while (i < high && a[i] <= pivot) {
                i++;
            }
            while (j > low && a[j] >= pivot) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, low, j);
        return j;
    }

    void quicksort(int[] a, int low, int high) {
        if (low <= high) {
            int k = partition(a, low, high);
            quicksort(a, low, k - 1);
            quicksort(a, k + 1, high);
        }
    }

    //swap elements at position i, j 
    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //save all items on a to a file
    public void save(int[] a, int n) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
        for (int i = 0; i < n; i++) {
            bw.write(a[i] + "\n");
        }
        bw.close();
    }

    //selection sort O(n^2)
    public void selection(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            //tim min tren [i+1,n]
            int min = a[i + 1], k = i + 1;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < min) {
                    min = a[j];
                    k = j;
                }
            }
            if (a[i] > a[k]) {
                swap(a, i, k);
            }
        }
    }

    //insertion O(n^2)
    void insertion(int[] a, int n) {
        int i, j, x;
        for (i = 1; i < n; i++) {
            x = a[i];
            j = i;
            while (j > 0 && a[j - 1] > x) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = x;
        }
    }

    //bubble O(n^2)
    void bubble(int[] a, int n) {
        boolean sorted = false;
        do {
            sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    sorted = false;
                }
            }
        } while (!sorted);
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        int n = 104;
        int[] a = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n);
        }
        Sorting s = new Sorting();
        //s.selection(a, n);
        long start = System.currentTimeMillis();
        //s.insertion(a, n);
        //s.quicksort(a, 0, n-1);
        s.mergesort(a, 0, n - 1);
        long end = System.currentTimeMillis();
        System.out.println("Time consuming: " + (end - start) / 1000.0);
        s.save(a, n);
    }
}
/*
Quick Sort: Nhanh cho mảng lớn, hiệu suất tốt (𝑂(𝑛log𝑛)), nhưng có thể chậm trong trường hợp xấu nhất.
Merge Sort: Hiệu suất ổn định (𝑂(𝑛log𝑛)), phù hợp khi cần sắp xếp ổn định nhưng tốn thêm bộ nhớ.
Heap Sort: O(nlogn), không yêu cầu nhiều bộ nhớ phụ, tốt khi cần hiệu quả và ổn định.
Radix Sort: Nhanh với dữ liệu số nguyên có phạm vi nhỏ (O(d(n+k))), nhưng không phù hợp với tất cả loại dữ liệu.
Insertion Sort, Selection Sort: Hiệu quả với mảng nhỏ hoặc gần sắp xếp trước, độ phức tạp O(n^2).
Bubble Sort: Không hiệu quả cho mảng lớn, chỉ dùng để minh họa.
*/