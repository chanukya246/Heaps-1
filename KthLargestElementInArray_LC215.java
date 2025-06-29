// Time Complexity : O(n log k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : None



class KthLargestElementInArray_LC215 {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int kInit;
    public int findKthLargest(int[] nums, int k) {
        kInit = k;

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > kInit) pq.poll();
        }
        return pq.peek();
    }
}