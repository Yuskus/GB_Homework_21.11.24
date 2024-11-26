package lesson3.nodes;

class Node {
    int val;
    Node left, right, parent;
    boolean isRed;

    Node(int value) {
        val = value;
        left = null;
        right = null;
        parent = null;
        isRed = true; // Новый узел всегда красный
    }
}
