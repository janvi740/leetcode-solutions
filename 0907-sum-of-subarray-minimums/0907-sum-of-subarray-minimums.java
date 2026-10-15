class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        int[] pse = new int[n];
        int[] nse = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<n; i++){

            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            pse[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        for(int i=n-1; i>=0; i--){

            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? n : stack.peek();
            
            stack.push(i);
        }

        long sum = 0;

        for(int i=0; i<n; i++){

            long left = i - pse[i];
            long right = nse[i] - i;

            long contribution = ((long) arr[i] * left * right) % MOD;

            sum = (sum + contribution) % MOD;
        }

        return (int) sum;
    }
}