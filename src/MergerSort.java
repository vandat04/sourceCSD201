package PE;

class EffSort {
    int[] a;
    int n;

    // Constructor để khởi tạo mảng
    public EffSort(int[] b) {
        this.a = b;
        this.n = b.length;
    }

    // Phương thức hiển thị mảng đã sắp xếp
    public void display() {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // Phương thức sắp xếp Merge Sort
    void mergeSort(int p, int r) {
        if (p >= r) return;
        int q = (p + r) / 2;
        mergeSort(p, q); // Đệ quy sắp xếp nửa đầu
        mergeSort(q + 1, r); // Đệ quy sắp xếp nửa sau
        merge(p, q, r); // Trộn hai nửa lại với nhau
    }

    // Phương thức trộn hai nửa đã sắp xếp
    void merge(int p, int q, int r) {
        if (!(p <= q) && (q <= r)) return;
        int n = r - p + 1;
        int[] b = new int[n];
        int i = p, j = q + 1, k = 0;

        // Trộn hai nửa lại với nhau
        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }

        // Sao chép các phần tử còn lại từ nửa bên trái
        while (i <= q) {
            b[k++] = a[i++];
        }

        // Sao chép các phần tử còn lại từ nửa bên phải
        while (j <= r) {
            b[k++] = a[j++];
        }

        // Sao chép lại các phần tử đã sắp xếp vào mảng ban đầu
        k = 0;
        for (i = p; i <= r; i++) {
            a[i] = b[k++];
        }
    }

    // Phương thức main để kiểm tra sắp xếp
    public static void main(String[] args) {
        int[] b = {7, 3, 5, 9, 11, 8, 6, 15, 10, 12, 14};
        EffSort t = new EffSort(b);
        int n = b.length;
        t.mergeSort(0, n - 1); // Gọi phương thức sắp xếp
        t.display(); // Hiển thị kết quả sau khi sắp xếp
    }
}
