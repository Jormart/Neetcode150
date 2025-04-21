import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Create a map to store the priority queue of destinations for each departure
        // airport
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        // Initialize the itinerary list and start the DFS from "JFK"
        LinkedList<String> itinerary = new LinkedList<>();
        dfs(graph, "JFK", itinerary);
        return itinerary;
    }

    // Depth-First Search (DFS) to find the itinerary
    private void dfs(Map<String, PriorityQueue<String>> graph, String airport, LinkedList<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            // Remove the next destination from the priority queue and continue DFS
            dfs(graph, destinations.poll(), itinerary);
        }
        // Add the airport to the beginning of the itinerary (equivalent to adding to
        // the end and reversing)
        itinerary.addFirst(airport);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        List<String> itinerary = solution.findItinerary(tickets);
        System.out.println(itinerary); // Output: [JFK, MUC, LHR, SFO, SJC]
    }
}