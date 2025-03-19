import java.util.Arrays;

public class SelectionSort {
    
    // Function to perform Selection Sort
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            
            swap(scores, i, minIndex);
        }
    }
    
    // Function to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] examScores = {85, 70, 95, 60, 90, 75};
        System.out.println("Original Scores: " + Arrays.toString(examScores));
        
        selectionSort(examScores);
        
        System.out.println("Sorted Scores: " + Arrays.toString(examScores));
    }
}
