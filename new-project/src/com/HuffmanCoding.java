package com;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCoding {

    Map<Character, Integer> calculateFrequency(String data) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : data.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

    Node buildTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();

            Node parent = new Node('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            queue.add(parent);

        }

        return queue.poll();

    }

    void generateCode(Node root, String code, Map<Character, String> huffmanCode) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            huffmanCode.put(root.character, code);
        }

        generateCode(root.left, code + "0", huffmanCode);
        generateCode(root.right, code + "1", huffmanCode);
    }

    String encodeData(String data, Map<Character, String> huffmanCode) {
        StringBuilder sb = new StringBuilder();
        for (char c : data.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }
        return sb.toString();
    }


    String decodeData(String encodeData, Node root){
        StringBuilder sb = new StringBuilder();
        Node current = root;
        for(char c : encodeData.toCharArray()){
            current = c == '0' ? current.left : current.right;

            if (current.left == null && current.right == null){
                sb.append(current.character);
                current = root;
            }
        }

        return sb.toString();
    }


    static class Node implements Comparable<Node> {
        char character;
        int frequency;
        Node left, right;

        Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Node node) {
            return this.frequency - node.frequency;
        }
    }
}
