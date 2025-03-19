import java.util.Arrays;

public class QuickSort {
    
    // Function to perform Quick Sort
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);
            quickSort(prices, low, pivotIndex - 1); // Sort left partition
            quickSort(prices, pivotIndex + 1, high); // Sort right partition
        }
    }

    // Function to partition the array
    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // Choosing last element as pivot
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                swap(prices, i, j);
            }
        }
        swap(prices, i + 1, high);
        return i + 1;
    }
    
    // Function to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] productPrices = {1200, 500, 1500, 200, 800, 1000};
        System.out.println("Original Prices: " + Arrays.toString(productPrices));
        
        quickSort(productPrices, 0, productPrices.length - 1);
        
        System.out.println("Sorted Prices: " + Arrays.toString(productPrices));
    }
}