package DSA_EXAM_QNS;

import java.util.ArrayList;
import java.util.List;

public class Qn_23 {
    // Yes, backtracking can explore all possible configurations and return multiple solutions if they exist.
    public static void findSubsets(int[] arr, int target, int index, List<Integer> current, List<List<Integer>> solutions) {
        if (target == 0) {
            solutions.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || index == arr.length) { 
            return;
        }
        current.add(arr[index]);
        findSubsets(arr, target - arr[index], index + 1, current, solutions);
        current.remove(current.size() - 1);
        findSubsets(arr, target, index + 1, current, solutions);
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 1};
        int target = 8;
        List<List<Integer>> solutions = new ArrayList<>();
        
        findSubsets(arr, target, 0, new ArrayList<>(), solutions);
        
        System.out.println("Subsets that sum to " + target + ":");
        for (List<Integer> subset : solutions) {
            System.out.println(subset);
        }
    }
}