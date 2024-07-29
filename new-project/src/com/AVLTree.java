package com;

public class AVLTree {

    private Node root;

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int max(int a, int b) {
        return (a >= b) ? a : b;
    }

    private int balanceFactor(Node node){
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private Node rightRotate(Node node) {
        Node left = node.left;
        Node right = left.right;

        left.right = node;
        node.left = right;

        node.height = max(height(node.left), height(node.right)) + 1;
        left.height = max(height(left.left), height(left.right)) + 1;

        return left;
    }

    private Node leftRotate(Node node) {
        Node right = node.right;
        Node left = right.left;

        right.left = node;
        node.right = left;

        node.height = max(height(node.left), height(node.right)) + 1;
        left.height = max(height(left.left), height(left.right)) + 1;

        return right;
    }


    private Node insert(Node node, int value) {
        if (node == null)
            return new Node(value);

        if (value < node.data) {
            node.left = insert(node.left, value);
        } else if (value > node.data) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }

        node.height = max(height(node.left), height(node.right)) + 1;

        return rotate(node, value);


    }

    private Node delete(Node node, int value){
        if (root == null){
            return root;
        }

        if (value < root.data){
            root.left = delete(root.left, value);
        }else if(value > root.data){
            root.right = delete(root.right, value);
        }else {
            if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = delete(root.right, value);

        }

        node.height = max(height(node.left), height(node.right)) + 1;

        return rotate(node,value);
    }

    private Node rotate(Node node, int value){
        int bf = balanceFactor(node);

        //Left Condition
        if (bf > 1 && value < node.left.data){
            return rightRotate(node);
        }
        //Right Condition
        if (bf < -1 && value > node.right.data) {
            return leftRotate(node);
        }

        //Left-Right Condition
        if (bf > 1 && value > node.left.data){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //Right-Left Condition
        if (bf < -1 && value < node.right.data){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private int minValue(Node root){
        int minValue = root.data;
        while (root.left != null){
            minValue = root.left.data;
        }
        return minValue;
    }

    public void insert(int value) {
        root = insert(root, value);
    }



    public void delete(int value){
        root = delete(root, value);
    }


    void inorder() {
        inorder(root);
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }


    private static class Node {
        int data;
        int height;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}
