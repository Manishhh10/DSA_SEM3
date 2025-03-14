package DSA_EXAM_QNS;

public class Qn_33 {
// Concurrency Control Keyword in Dynamic Multi-threading
// In dynamic multi-threading, managing access to shared resources is crucial to prevent race conditions. In Java, the synchronized keyword is commonly used as a concurrency control mechanism. When a method or code block is declared as synchronized, only one thread can execute it at a time, ensuring mutual exclusion and proper memory visibility of shared variables.
public class ParallelMergeSort {

    private static final int THRESHOLD = 1000;

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        
        if (high - low > THRESHOLD) {
            Thread left = new Thread(() -> mergeSort(arr, low, mid));
            Thread right = new Thread(() -> mergeSort(arr, high, mid + 1 ));
            left.start();
            right.start();
            try {
                left.join();
                right.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            mergeSort(arr, low, mid);
            mergeSort(arr, high, mid + 1);
        }
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }            
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, low, temp.length);
    }
    
    public static void main(String[] args) {
        // int[] array = { 38, 27, 43, 3, 9, 82, 10 };
        // mergeSort(array, 0, array.length - 1);
        // for (int num : array) {
        //     System.out.print(num + " ");
        // }
    }
}
}