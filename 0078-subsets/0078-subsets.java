class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, current, result);

        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result){

        result.add(new ArrayList<>(current));

        for(int i=index; i<nums.length; i++){

            current.add(nums[i]);

            backtrack(i+1, nums, current, result);

            current.remove(current.size() - 1);
        }
    }
}