class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(0, candidates, target, list, ans);

        return ans;
    }

    public void solve(int index, int[] candidates, int target, List<Integer> list, List<List<Integer>> ans){

        if(index==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(candidates[index] <= target){
            list.add(candidates[index]);

            solve(index, candidates, target - candidates[index], list, ans);

            list.remove(list.size()-1);
        }

        solve(index+1, candidates, target, list, ans);
    }
}