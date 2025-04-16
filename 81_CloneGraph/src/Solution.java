import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    // Depth-First Search (DFS) approach to clone the graph
    // This approach uses recursion to traverse the graph and create a deep copy of
    // it.
    // It maintains a map to keep track of visited nodes and their corresponding
    // clones.
    // The map is used to avoid infinite loops in case of cycles in the graph.
    // The time complexity of this approach is O(V + E), where V is the number of
    // vertices and E is the number of edges.
    // The space complexity is O(V) for the visited map and the recursion stack.

    HashMap<Node, Node> visited = new HashMap<>(); // Map to keep track of visited nodes and their clones

    public Node cloneGraph(Node node) {
        if (node == null)
            return null; // If the input node is null, return null

        Map<Node, Node> visited = new HashMap<>(); // Map to keep track of visited nodes and their clones
        return dfs(node, visited); // Start DFS from the input node
    }

    private Node dfs(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node))
            return visited.get(node); // If the node is already visited, return its clone

        Node clone = new Node(node.val); // Create a new clone of the current node
        visited.put(node, clone); // Store the clone in the visited map

        for (Node neighbor : node.neighbors) { // Iterate through the neighbors of the current node
            clone.neighbors.add(dfs(neighbor, visited)); // Recursively clone each neighbor and add it to the clone's
                                                         // neighbors
        }

        return clone; // Return the cloned node
    }

}

    public static void main(String[] args) {
        // Example usage
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Solution solution = new Solution();
        Node clonedGraph = solution.cloneGraph(node1);

        // Print the cloned graph (for testing purposes)
        System.out.println("Cloned graph nodes:");
        for (Node n : clonedGraph.neighbors) {
            System.out.println(n.val);
        }
    }

}