package com;

public class WeightGraph {
    private int vertices;
    private int[][] matrix;

    WeightGraph(int vertices){
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
        for(int i = 0; i < vertices; i++){
            for (int j = 0; j < vertices; j++){
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    void addEdge(int v1, int v2, int weight){
        matrix[v1][v2] = weight;
        matrix[v2][v1] = weight;
    }

    void print(){
        for (int i = 0; i < vertices; i++){
            for (int j= 0; j < vertices; j++){
                System.out.print(matrix[i][j] == Integer.MAX_VALUE ? "IN ": matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}
