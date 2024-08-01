package com;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

       // BinarySearchTree tree = new BinarySearchTree();
//        AVLTree tree = new AVLTree();
//
//
//        tree.insert(40);
//        tree.insert(10);
//        tree.insert(30);
//        tree.insert(20);
//
//        tree.inorder();
//        System.out.println();
//        // tree.delete(30);
//
//        tree.inorder();

//        PriorityQueue queue = new PriorityQueue();
//        queue.enqueue(100, 2);
//        queue.enqueue(40, 5);
//        queue.enqueue(20, 1);
//
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());



//        CompleteGraph g = new CompleteGraph(5);
//        g.addEdge(0,4,10);
//        g.addEdge(1,0,40);
//        g.addEdge(1,3, 100);
//        g.addEdge(2,4, 50);
//        g.addEdge(2,4, 70);
//        g.addEdge(3,2, 5);
//
//
//        //g.dijkstra(0);
//        g.bellmanFord(1);
//
//
//        //g.print();
//       // g.travers(1);
//        //g.dfs(1);


        String data = "Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua";

        HuffmanCoding hc = new HuffmanCoding();
        Map<Character, Integer> frequencyMap = hc.calculateFrequency(data);

        HuffmanCoding.Node node = hc.buildTree(frequencyMap);

        Map<Character, String> huffmanCode = new HashMap<>();

        hc.generateCode(node,"", huffmanCode);

        String encodedData = hc.encodeData(data, huffmanCode);
        System.out.println(encodedData);

        String decodedData = hc.decodeData(encodedData, node);
        System.out.println(decodedData);
    }
}
