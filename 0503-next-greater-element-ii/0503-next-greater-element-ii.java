class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<2*n; i++){

            int index = i % n;
            int current = nums[index];

            while(!stack.isEmpty() && current > nums[stack.peek()]){
                int prevIndex = stack.pop();
                ans[prevIndex] = current;
            }

            if(i < n){
                stack.push(index);
            }
        }

        return ans;
    }
}