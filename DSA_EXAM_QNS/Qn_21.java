package DSA_EXAM_QNS;

import java.sql.Time;

public class Qn_21 {
    // Heapify is the process of restoring the heap property in a binary heap. In a max-heap, every parent must be greater than or equal to its children. If a node violates this, heapify fixes the violation by swapping the node with its largest child and then repeating the process.

    //Example
// Consider the following array representing a binary heap (using 0-indexing):


// A = [4, 10, 3, 5, 1]
// This array corresponds to the following binary tree:
//          4
//        /   \
//      10     3
//     /  \
//    5    1
// If we call max-heapify on index 0 (which holds 4), the algorithm compares 4 with its children (10 at index 1 and 3 at index 2):
// Compare: 10 (left child) is greater than 4, so mark index 1 as the candidate for swapping.
// Check right child: 3 is less than 10, so the candidate remains index 1.
// Swap: Swap 4 with 10.
// After the swap, the array becomes:
// A = [10, 4, 3, 5, 1]
// The tree now looks like:
//          10
//        /    \
//       4      3
//     /  \
//    5    1
// Recursive call: Now, max-heapify is called on index 1 (value 4), where its children (indices 3 and 4) are 5 and 1 respectively.
// Compare 4 with 5: since 5 is larger, swap them.
// The array updates to:
// A = [10, 5, 3, 4, 1]
// At this point, index 3 (value 4) is a leaf node (or has no children violating the heap property), so the operation stops.
// After these steps, the subtree rooted at index 0 is now a valid max-heap.


    public class HeapUtils {

        // Pseudocode for max-heapify in Java style
        public static void maxHeapify(int[] A, int i, int heapSize) {
            int left = 2 * i + 1;    // Left child index
            int right = 2 * i + 2;   // Right child index
            int largest = i;         // Assume current index i is largest
    
            // Check if left child exists and is greater than A[i]
            if (left < heapSize && A[left] > A[largest]) {
                largest = left;
            }
    
            // Check if right child exists and is greater than the current largest
            if (right < heapSize && A[right] > A[largest]) {
                largest = right;
            }
    
            // If largest is not the current node, swap and heapify the affected subtree
            if (largest != i) {
                int temp = A[i];
                A[i] = A[largest];
                A[largest] = temp;
    
                // Recursively heapify the subtree
                maxHeapify(A, largest, heapSize);
            }
        }
    
        // Optionally, a main method to demonstrate the pseudocode in action.
        public static void main(String[] args) {
            int[] A = {4, 10, 3, 5, 1};
            int heapSize = A.length;
    
            // Call heapify on index 0
            maxHeapify(A, 0, heapSize);
    
            // Print the updated array
            for (int x : A) {
                System.out.print(x + " ");
            }
        }

// Complexity Analysis
// Time Complexity:
// In the worst case, the operation may travel from the root down to a leaf, which is O(log n).

// Space Complexity:
// Recursive Implementation: Uses up to O(log n) space for the call stack.
    }
    
}