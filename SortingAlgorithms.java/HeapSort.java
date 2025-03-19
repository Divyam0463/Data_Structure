import java.util.Arrays;

public class HeapSort {
    
    // Function to perform Heap Sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;
        
        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }
        
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(salaries, 0, i);
            heapify(salaries, i, 0);
        }
    }
    
    // Function to heapify a subtree rooted at index i
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    
    // Function to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] salaryDemands = {50000, 70000, 45000, 60000, 80000, 55000};
        System.out.println("Original Salaries: " + Arrays.toString(salaryDemands));
        
        heapSort(salaryDemands);
        
        System.out.println("Sorted Salaries: " + Arrays.toString(salaryDemands));
    }
}
