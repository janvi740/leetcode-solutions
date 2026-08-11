class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int inf = (int) 1e9;
        int[][] dist = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], inf);
            dist[i][i] = 0;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][k]!=inf && dist[k][j]!=inf){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int minReachCity = Integer.MAX_VALUE;
        int resultCity = -1;

        for(int city=0; city<n; city++){
            int count = 0;

            for(int other=0; other<n; other++){

                if(city!=other && dist[city][other] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= minReachCity){
                minReachCity = count;
                resultCity = city;
            }
        } 

        return resultCity;       
    }
}