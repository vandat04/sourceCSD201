package PE;

public class QuickSort{
    // Đặt pivot ở vị trí đầu tiên của dãy ; 2 pointer technical
    int partitionHoare(int[] arr, int low, int high) {
        int pivot = arr[low]; // Chọn pivot là phần tử đầu tiên
        int i = low; // Chỉ số từ đầu mảng
        int j = high; // Chỉ số từ cuối mảng
        while (true) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            // i và j gặp nhau hoặc vượt qua nhau, kết thúc quá trình phân hoạch
            if (i >= j) {
                return j; // Trả về chỉ số vị trí chính xác của pivot
            }
            // Hoán đổi phần tử không đúng vị trí
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionHoare(arr, low, high);
            quickSort(arr, low, pivotIndex);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int[] arr = {34, 7, 23, 32, 5, 62}; // Mảng cần sắp xếp
        sorter.quickSort(arr, 0, arr.length - 1);
        System.out.println("Mảng sau khi sắp xếp:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
