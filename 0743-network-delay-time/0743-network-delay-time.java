class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] tm : times){
            int u = tm[0];
            int v = tm[1];
            int t = tm[2];

            adj.get(u).add(new int[] {v, t});
        }

        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);

        time[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[] {k, 0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();

            int node = current[0];
            int currTime = current[1];

            if(currTime > time[node]){
                continue;
            }

            for(int[] neighbour : adj.get(node)){
                int adjNode = neighbour[0];
                int newTime = neighbour[1];

                if(currTime + newTime < time[adjNode]){
                    time[adjNode] = currTime + newTime;
                    pq.offer(new int[] {adjNode, time[adjNode]});
                }
            }
        }

        int max = 0;

        for(int i=1; i<=n; i++){
            max = Math.max(max, time[i]);
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }
}