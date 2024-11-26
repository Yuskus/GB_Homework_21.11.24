package lesson3.nodes;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void add(int val) {
        Node node = new Node(val);

        if (root == null) {
            node.isRed = false;
            root = node;
            return;
        }

        Node Y = null;
        Node X = root;

        while (X != null) {
            Y = X;
            X = node.val < X.val ? X.left : X.right;
        }

        node.parent = Y;

        if (Y == null) {
            root = node;
        } else if (node.val < Y.val) {
            Y.left = node;
        } else {
            Y.right = node;
        }

        node.isRed = true;
        balance(node);
    }

    private void balance(Node node) {
        while (node != root && node.parent.isRed == true) {
            if (node.parent == node.parent.parent.left) {
                Node Y = node.parent.parent.right;

                if (Y != null && Y.isRed == true) {
                    changeColors(node.parent, false);
                    Y.isRed = false;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    changeColors(node.parent, false);
                    rightRotate(node.parent.parent);
                }
            } else {
                Node X = node.parent.parent.left;

                if (X != null && X.isRed == false) {
                    changeColors(node.parent, true);
                    X.isRed = true;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    changeColors(node.parent, true);
                    leftRotate(node.parent.parent);
                }

            }
            root.isRed = false;
        }
    }

    private void leftRotate(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        if (temp.left != null) {
            temp.left.parent = node;
        }
        temp.parent = node.parent;
        if (node.parent == null) {
            root = temp;
        } else if (node == node.parent.left) {
            node.parent.left = temp;
        } else {
            node.parent.right = temp;
        }
        temp.left = node;
        node.parent = temp;
        temp.isRed = node.isRed;
        node.isRed = true;
    }

    private void rightRotate(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        if (temp.right != null) {
            temp.right.parent = node;
        }
        temp.parent = node.parent;
        if (node.parent == null) {
            root = temp;
        } else if (node == node.parent.right) {
            node.parent.right = temp;
        } else {
            node.parent.left = temp;
        }
        temp.right = node;
        node.parent = temp;
        temp.isRed = node.isRed;
        node.isRed = true;
    }

    private void changeColors(Node node, boolean color) {
        node.isRed = color;
        node.parent.isRed = !color;
    }

    public void printTreeFromRoot() {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        System.out.println();
    }

    public void printRecursiveAndOrdered() {
        printRecursiveAndOrdered(root);
    }

    private void printRecursiveAndOrdered(Node node) {
        if (node == null)
            return;
        printRecursiveAndOrdered(node.left);
        System.out.print(node.val + " ");
        printRecursiveAndOrdered(node.right);
    }
}
