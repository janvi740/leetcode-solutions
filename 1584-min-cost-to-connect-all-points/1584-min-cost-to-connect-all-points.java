class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        boolean[] visited = new boolean[n];

        pq.offer(new int[] {0, 0});

        int edgeUsed = 0;
        int cost = 0;

        while(edgeUsed < n){

            int[] current = pq.poll();

            int node = current[0];
            int weight = current[1];

            if(visited[node]){
                continue;
            }

            visited[node] = true;
            cost += weight;
            edgeUsed++;

            for(int next=0; next<n; next++){

                if(!visited[next]){

                    int distance = Math.abs(points[node][0] - points[next][0]) + 
                                    Math.abs(points[node][1] - points[next][1]);
                    
                    pq.offer(new int[] {next, distance});
                }
            }
        }

        return cost;
    }
}