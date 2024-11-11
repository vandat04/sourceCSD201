package AdvantageDSA;

import java.util.*;

class Node1 {
    int id, distance;
    List<Edge> edges = new ArrayList<>();

    Node1(int id) {
        this.id = id;
        this.distance = Integer.MAX_VALUE; // Khoảng cách ban đầu
    }
}

class Edge {
    Node1 target;
    int weight;

    Edge(Node1 target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

class Graph {
    List<Node1> nodes;

    Graph(int numNodes) {
        nodes = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) nodes.add(new Node1(i));
    }

    void addEdge(int src, int dest, int weight) {
        nodes.get(src).edges.add(new Edge(nodes.get(dest), weight));
    }

    void dijkstra(int startId) {
        nodes.get(startId).distance = 0;
        PriorityQueue<Node1> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        pq.add(nodes.get(startId));

        while (!pq.isEmpty()) {
            Node1 current = pq.poll();
            for (Edge edge : current.edges) {
                int newDist = current.distance + edge.weight;
                if (newDist < edge.target.distance) {
                    edge.target.distance = newDist;
                    pq.add(edge.target);
                }
            }
        }
    }

    void printShortestPaths() {
        for (Node1 node : nodes) {
            System.out.println("Node " + node.id + ": " + (node.distance == Integer.MAX_VALUE ? "Infinity" : node.distance));
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 4, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(4, 1, 3);
        graph.addEdge(4, 2, 9);
        graph.addEdge(4, 3, 2);

        graph.dijkstra(0); // Tính khoảng cách từ node 0
        graph.printShortestPaths(); // In ra kết quả
    }
}

