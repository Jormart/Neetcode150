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

class Solution2 {

    // BFS approach
    // Time Complexity: O(N), where N is the number of nodes in the graph
    // Space Complexity: O(N), for the visited map and queue
    // This approach uses a HashMap to keep track of the visited nodes and their
    // corresponding clones.
    // It uses a queue to perform a breadth-first traversal of the graph, cloning
    // each
    // node and its neighbors as it goes.
    // The BFS approach is iterative and uses a queue to explore the graph level by
    public Node cloneGraph(Node node) {

        if (node == null)
            return null; // If the input node is null, return null

        Map<Node, Node> visited = new HashMap<>(); // Map to keep track of visited nodes and their clones
        Queue<Node> queue = new LinkedList<>(); // Queue for BFS traversal

        Node clone = new Node(node.val); // Create a new clone of the input node
        visited.put(node, clone); // Store the clone in the visited map
        queue.add(node); // Add the input node to the queue

        while (!queue.isEmpty()) { // While there are nodes to process in the queue
            Node currentNode = queue.poll(); // Get the next node from the queue

            for (Node neighbor : currentNode.neighbors) { // Iterate through the neighbors of the current node
                if (!visited.containsKey(neighbor)) { // If the neighbor has not been visited yet
                    Node neighborClone = new Node(neighbor.val); // Create a new clone of the neighbor
                    visited.put(neighbor, neighborClone); // Store the clone in the visited map
                    queue.add(neighbor); // Add the neighbor to the queue for further processing
                }
                visited.get(currentNode).neighbors.add(visited.get(neighbor)); // Add the cloned neighbor to the cloned
                                                                               // node's neighbors
            }
        }

        return clone; // Return the cloned graph starting from the cloned input node
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

        Solution2 solution = new Solution2();
        Node clonedGraph = solution.cloneGraph(node1); // Clone the graph starting from node1

        // Print the cloned graph (for testing purposes)
        System.out.println("Cloned graph starting from node 1: " + clonedGraph.val);
    }
}