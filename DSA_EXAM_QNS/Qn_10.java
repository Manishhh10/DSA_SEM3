package DSA_EXAM_QNS;

public class Qn_10 {
    public class MaxElementFinder {
    
        // Method to find the maximum element in an array
        public static int findMax(int[] arr) {
            // Assume the array is non-empty and initialize max to the first element.
            int max = arr[0];
            
            // Iterate through the array starting from the second element.
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i]; // Update max if a larger element is found.
                }
            }
            return max;
        }
        
        public static void main(String[] args) {
            int[] array = {12, 34, 5, 67, 89, 23, 44};
            System.out.println("The maximum element is: " + findMax(array));
        }
    }
    
}

// Time Complexity Analysis
// Worst-case Scenario:
// The algorithm checks every element exactly once. If there are n elements, it performs n - 1 comparisons.

// Time Complexity:
// Since the number of comparisons grows linearly with the size of the input array, the worst-case time complexity is O(n).

// Best-case Scenario:
// Even in the best case (for example, when the maximum element is at the beginning), the algorithm still needs to check every other element to be sure, so it remains O(n).

// This simple and efficient approach ensures that the maximum element is found in a single pass through the array.