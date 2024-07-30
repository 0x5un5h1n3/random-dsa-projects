package com;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private int vertices;
    private int[][] matrix;

    Graph(int vertices){
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    void addEdge(int v1, int v2){
        matrix[v1][v2] = 1;
        matrix[v2][v1] = 1;
    }

    void bfs(int v){
        boolean[] visited = new boolean[vertices];
        //LinkedListQueue queue = new LinkedListQueue();
        LinkedList<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()){
             v = queue.poll();
            System.out.print(v+" ");

            for (int i = 0; i < vertices; i++){
                if (matrix[v][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    void dfs(int v){
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(v);

        while (!stack.isEmpty()){
            v = stack.pop();

            if (!visited[v]){
                System.out.print(v +" ");
                visited[v] = true;
            }

            for (int i = vertices - 1; i >= 0; i--){
                if (matrix[v][i] == 1 && !visited[i]){
                    stack.push(i);
                }
            }

        }

    }

    void print(){
        for (int i = 0; i < vertices; i++){
            for (int j= 0; j < vertices; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
