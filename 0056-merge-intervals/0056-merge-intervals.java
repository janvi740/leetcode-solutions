class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];

        for(int i=1; i<n; i++){

            int[] next = intervals[i];
 
            if(next[0] <= current[1]){
                current[1] = Math.max(next[1], current[1]);
            }

            else{
                result.add(current);
                current = next;
            }
        }

        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}