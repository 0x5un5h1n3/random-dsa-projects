package com;

import java.util.LinkedList;

public class CompleteGraph {
    private int vertices;
    private LinkedList<Node>[] adjList;

    CompleteGraph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v1, int v2, int weight) {
        adjList[v1].add(new Node(v2, weight));
        adjList[v2].add(new Node(v1, weight));
    }


    void dijkstra(int source) {
        boolean[] visited = new boolean[vertices];
        LinkedList<Node> nodes = new LinkedList<>();

        int[] cost = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[source] = 0;

        for (int i = 0; i < vertices; i++) {
            nodes.add(new Node(i, cost[i]));
        }

        while (!nodes.isEmpty()) {
            Node minNode = getMinNode(nodes, cost);

            int v = minNode.vertex;
            nodes.remove(minNode);

            visited[v] = true;

            for (Node node : adjList[v]) {
                if (!visited[node.vertex] && cost[v] != Integer.MAX_VALUE && cost[v] + node.weight < cost[node.vertex]) {
                    cost[node.vertex] = cost[v] + node.weight;
                    updateNode(nodes, node.vertex, cost[node.vertex]);
                }
            }
        }


        // Print Shortest Path
        printShortPath(cost);

    }

    void bellmanFord(int source){
        int[] cost = new int[vertices];

        for (int i = 0; i < vertices; i++){
            cost[i] = Integer.MAX_VALUE;
        }

        cost[source] = 0;

        for(int i = 1; i < vertices; i++){
            for (int j = 0; j < vertices; j++){
                for(Node node : adjList[j]){
                    int vertex = node.vertex;
                    int weight = node.weight;

                    if (cost[j] != Integer.MAX_VALUE && cost[j] + weight < cost[vertex]){
                        cost[vertex] = cost[j] + weight;
                    }

                }
            }
        }

        for (int j = 0; j < vertices; j++){
            for(Node node : adjList[j]){
                int vertex = node.vertex;
                int weight = node.weight;

                if (cost[j] != Integer.MAX_VALUE && cost[j] + weight < cost[vertex]){
                    System.out.println("This Graph contains negative cycle...");
                    return;
                }

            }
        }

        printShortPath(cost);

    }

    void printShortPath(int[] cost){
        System.out.println("Shortest Path Form Source :");
        for(int i = 0; i < vertices; i++){
            System.out.print(cost[i]);
            if (i+1 != vertices){
                System.out.print("->");
            }
        }
    }


    Node getMinNode(LinkedList<Node> nodes, int[] cost) {
        Node minNode = null;
        int minCost = Integer.MAX_VALUE;

        for (Node node : nodes) {
            if (cost[node.vertex] < minCost) {
                minCost = cost[node.vertex];
                minNode = node;
            }
        }
        return minNode;
    }

    void updateNode(LinkedList<Node> nodes, int vertex, int updateCost) {
        for (Node node : nodes) {
            if (node.vertex == vertex) {
                node.weight = updateCost;
                break;
            }
        }
    }


    void print() {
        for (int i = 0; i < vertices; i++) {
            for (Node node : adjList[i]) {
                System.out.print(node.weight + " ");
            }
            System.out.println();
        }

    }

    private static class Node {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
