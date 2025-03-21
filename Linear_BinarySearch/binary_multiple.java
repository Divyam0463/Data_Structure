
import java.util.Arrays;

public class binary_multiple {
  static int findFirstOccurence(int[] arr, int k) {
    int ans = -1;
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == k) {
        ans = mid;
        high = mid - 1;
      } else if (arr[mid] < k) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return ans;
  }

  static int findLastOccurence(int[] arr, int k) {
    int ans = -1;
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == k) {
        ans = mid;
        low = mid + 1;
      } else if (arr[mid] < k) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 2, 3, 9, 9 };
    int[] ans = new int[2];
    int k = 9;

    ans[0] = findFirstOccurence(arr, k);
    ans[1] = findLastOccurence(arr, k);

    System.out.println(Arrays.toString(ans));
  }
}
