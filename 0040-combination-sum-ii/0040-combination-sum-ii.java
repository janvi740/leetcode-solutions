class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(0, candidates, target, list, result);

        return result;
    }

    private void backtrack(int index, int[] candidates, int target, List<Integer> list, List<List<Integer>> result){

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (index == candidates.length) {
            return;
        }

        if(candidates[index] <= target){

            list.add(candidates[index]);
            backtrack(index+1, candidates, target-candidates[index], list, result);
            list.remove(list.size() - 1);
        }

        int nextIndex = index + 1;

        while (nextIndex < candidates.length && candidates[nextIndex] == candidates[index]){
            nextIndex++;
        }

        backtrack(nextIndex, candidates, target, list, result);
    }
}