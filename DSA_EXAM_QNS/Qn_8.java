package DSA_EXAM_QNS;

import java.util.PriorityQueue;

public class Qn_8 {
    // Merge k-th sorted linked list into single linked list

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class MergeKSortedLists {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

            for (ListNode list : lists) {
                if (list != null) {
                    minHeap.offer(list);
                }
            }

            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            while (!minHeap.isEmpty()) {
                ListNode smallest = minHeap.poll();
                current.next = smallest;
                current = current.next;
                if (smallest.next != null) {
                    minHeap.offer(smallest.next);
                }
            }

            return dummy.next;
        }
    }
}
