class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        long[] prefix = new long[n+1];

        for(int i=0; i<n; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int minLen = n + 1;

        for(int j=0; j<=n; j++){

            while(!deque.isEmpty() && prefix[j] - prefix[deque.peekFirst()] >= k){
                minLen = Math.min(minLen, j - deque.pollFirst());
            }

            while(!deque.isEmpty() && prefix[j] <= prefix[deque.peekLast()]){
                deque.pollLast();
            }

            deque.offerLast(j);
        }

        return minLen == n+1 ? -1 : minLen;
    }
}