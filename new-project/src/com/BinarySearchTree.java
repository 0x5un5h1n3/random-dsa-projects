package com;

public class BinarySearchTree {

    private Node root;

    void add(int value) {
        this.root = add(root, value);
    }

    private Node add(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            //  return root;
        } else {
            if (value < root.data) {
                root.left = add(root.left, value);
            } else if (value > root.data) {
                root.right = add(root.right, value);
            }
        }
        return root;
    }

    boolean search(int value) {
        return search(root, value);
    }

    private boolean search(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.data == value) {
            return true;
        }

        if (root.data < value) {
            return search(root.right, value);
        }

        return search(root.left, value);

    }

    void delete(int value){
        root = delete(root, value);
    }

    private Node delete(Node root, int value){
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
        return root;
    }

    private int minValue(Node root){
        int minValue = root.data;
        while (root.left != null){
            minValue = root.left.data;
        }
        return minValue;
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

    public static class Node {
        int data;
        Node left, right;

        Node(int value) {
            this.data = value;
        }
    }
}
