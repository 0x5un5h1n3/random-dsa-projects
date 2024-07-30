package com;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphWithList {
    private int vertices;
    private LinkedList<Integer> adjList[];

    GraphWithList(int v){
        this.vertices = v;
        adjList = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    void  addEdge(int v1, int v2){
        adjList[v1].add(v2);
    }

    void bfs(int v){
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()){
            v = queue.poll();
            System.out.print(v+" ");
            Iterator<Integer> li = adjList[v].listIterator();
            while (li.hasNext()){
                int i = li.next();
                if (!visited[i]){
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
                System.out.print(v+" ");
                visited[v] = true;
            }

            for (Integer i : adjList[v]){
                if (!visited[i]){
                    stack.push(i);
                }
            }
        }

    }
}
