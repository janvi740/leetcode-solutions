class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        int day = 1;
        int count = 0;

        while(i<n || !pq.isEmpty()){

            // Jump to next event if no event is available
            if(pq.isEmpty() && i<n){
                day = Math.max(day, events[i][0]);
            }

            // Add all events that have started
            while(i<n && events[i][0] <= day){
                pq.offer(events[i][1]);
                i++;
            }

            // Remove expired events
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }

            if(!pq.isEmpty()){
                pq.poll();
                count++;
            }

            day++;
        }

        return count;
    }
}