package AdvantageDSA;

import java.util.*;

class Node3 implements Comparable<Node3> {
    public final String name;
    public final int gCost; // Cost from start to this node
    public final int hCost; // Heuristic cost to goal
    public final int fCost; // Total cost (g + h)
    public final Node3 parent;

    public Node3(String name, int gCost, int hCost, Node3 parent) {
        this.name = name;
        this.gCost = gCost;
        this.hCost = hCost;
        this.fCost = gCost + hCost;
        this.parent = parent;
    }

    @Override
    public int compareTo(Node3 other) {
        return Integer.compare(this.fCost, other.fCost);
    }
}

class AStar {
    private final Map<String, List<Node3>> adjacencyList; // Adjacency list

    public AStar() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(String source, String destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.get(source).add(new Node3(destination, weight, 0, null));
    }

    public List<String> aStar(String start, String goal, Map<String, Integer> heuristic) {
        PriorityQueue<Node3> openSet = new PriorityQueue<>();
        Set<String> closedSet = new HashSet<>();
        openSet.add(new Node3(start, 0, heuristic.get(start), null));

        while (!openSet.isEmpty()) {
            Node3 currentNode = openSet.poll();

            if (currentNode.name.equals(goal)) {
                return reconstructPath(currentNode);
            }

            closedSet.add(currentNode.name);

            for (Node3 neighbor : adjacencyList.getOrDefault(currentNode.name, new ArrayList<>())) {
                if (closedSet.contains(neighbor.name)) {
                    continue; // Skip the node if it's already evaluated
                }

                int newCost = currentNode.gCost + neighbor.gCost; // Calculate cost from start to neighbor
                Node3 neighborNode = new Node3(neighbor.name, newCost, heuristic.get(neighbor.name), currentNode);

                if (!openSet.contains(neighborNode)) {
                    openSet.add(neighborNode);
                } else if (newCost < neighborNode.gCost) {
                    openSet.remove(neighborNode);
                    openSet.add(neighborNode);
                }
            }
        }
        return Collections.emptyList(); // Return empty if no path is found
    }

    // Reconstruct the path from start to goal
    private List<String> reconstructPath(Node3 node) {
        List<String> path = new ArrayList<>();
        while (node != null) {
            path.add(node.name);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        AStar graph = new AStar();
        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 1);
        graph.addEdge("C", "E", 3);
        graph.addEdge("D", "E", 2);

        // Heuristic values for nodes
        Map<String, Integer> heuristic = new HashMap<>();
        heuristic.put("A", 7);
        heuristic.put("B", 6);
        heuristic.put("C", 2);
        heuristic.put("D", 1);
        heuristic.put("E", 0);

        List<String> path = graph.aStar("A", "E", heuristic);
        System.out.println("Path from A to E: " + path);
    }
}