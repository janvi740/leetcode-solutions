class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[] {0, 0, grid[0][0]});

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, -1, 0, 1};

        while(!pq.isEmpty()){

            int[] current = pq.poll();

            int row = current[0];
            int col = current[1];
            int time = current[2];

            if(visited[row][col]){
                continue;
            }

            visited[row][col] = true;

            if(row == n-1 && col == n-1){
                return time;
            }

            for(int i=0; i<4; i++){
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if(newRow<0 || newRow>=n || newCol<0 || newCol>=n || visited[newRow][newCol]){
                    continue;
                }

                int newTime = Math.max(time, grid[newRow][newCol]);

                pq.offer(new int[] {newRow, newCol, newTime});
            }
        }

        return -1;
    }
}