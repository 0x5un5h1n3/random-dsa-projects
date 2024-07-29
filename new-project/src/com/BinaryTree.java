package com;

public class BinaryTree {
    Node root;

    public void inorder(Node node){
        if (node != null){
            inorder(node.left);
            System.out.print(node.data);
            if (node.left != null || node.right != null){
                System.out.print(", ");
            }
            inorder(node.right);
        }
    }

    public void preorder(Node node){
        if (node != null){
            System.out.print(node.data);
            if (node.left != null || node.right != null){
                System.out.print(", ");
            }
            preorder(node.left);
            preorder(node.right);

        }
    }

    public void postorder(Node node){
        if (node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data);
            if (node.left != null || node.right != null) {
                System.out.print(", ");
            }
        }
    }

}

class Node{
    int data;
    Node left, right;

    public Node(int value){
        this.data = value;
    }
}
