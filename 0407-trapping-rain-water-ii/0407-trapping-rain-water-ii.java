class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if(m < 3 || n < 3){
            return 0;
        }

        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        //add left and right boundary to pq
        for(int i=0; i<m; i++){
            pq.offer(new int[] {heightMap[i][0], i, 0});
            pq.offer(new int[] {heightMap[i][n-1], i, n-1});

            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        //add top and bottom boundary to pq
        for(int j=1; j<n-1; j++){
            pq.offer(new int[] {heightMap[0][j], 0, j});
            pq.offer(new int[] {heightMap[m-1][j], m-1, j});

            visited[0][j] = true;
            visited[m-1][j] = true;
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int water = 0;

        while(!pq.isEmpty()){

            int[] cell = pq.poll();

            int height = cell[0];
            int row = cell[1];
            int col = cell[2];

            for(int d=0; d<4; d++){

                int nr = row + dr[d];
                int nc = col + dc[d];

                if(nr<0 || nr>=m || nc<0 || nc>=n || visited[nr][nc]){
                    continue;
                }

                visited[nr][nc] = true;

                water += Math.max(0, height - heightMap[nr][nc]);

                int newHeight = Math.max(height, heightMap[nr][nc]);

                pq.offer(new int[] {newHeight, nr, nc});
            }
        }

        return water;
    }
}