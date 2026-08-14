class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<String>());
            graph.get(from).offer(to);
        }

        List<String> itinerary = new LinkedList<>();

        dfs("JFK", graph, itinerary);

        return itinerary;
    }

    public void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> itinerary){

        PriorityQueue<String> destinations = graph.get(airport);

        while(destinations != null && !destinations.isEmpty()){

            String nextAirport = destinations.poll();
            dfs(nextAirport, graph, itinerary);
        }

        itinerary.addFirst(airport);
    }
}