package DSA_EXAM_QNS;

import java.util.*;  // Importing java.util for Arrays.sort and other utilities

public class Qn_17 {
    class Job {
        int id, profit, deadline;
        Job(int id, int profit, int deadline) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }
    }
    
    static class JobSequencing {
        static int maxProfit(Job[] jobs) {
            // Sort jobs in descending order by profit.
            Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
            boolean[] slots = new boolean[3];
            int profit = 0;
            
            // For each job, try to schedule it in the latest available slot before its deadline.
            for (Job job : jobs) {
                for (int j = Math.min(job.deadline, slots.length) - 1; j >= 0; j--) {
                    if (!slots[j]) {
                        slots[j] = true;
                        profit += job.profit;
                        break;
                    }
                }
            }
            return profit;
        }
    }
}

