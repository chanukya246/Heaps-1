//Time complexity : O(Nlogk) where k is the number of linked lists.
//                    The comparison cost will be reduced to O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1) time.
//                    There are N nodes in the final linked list.
//Space complexity :  O(n) Creating a new linked list costs O(n) space.
//                    O(k) The code above present applies in-place method which cost O(1) space. And the priority queue (often implemented with heaps) costs O(k) space (it's far less than N in most situations).
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode point = result;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode l1, ListNode l2) {
                        if (l1.val > l2.val)
                            return 1;
                        else if (l1.val == l2.val)
                            return 0;
                        else
                            return -1;
                    }
                });

        for (ListNode listNode : lists) {
            if (listNode != null)
                queue.add(listNode);
        }

        while (!queue.isEmpty()) {
            point.next = queue.poll();
            point = point.next;
            if (point.next != null)
                queue.add(point.next);
        }

        return result.next;
    }
}