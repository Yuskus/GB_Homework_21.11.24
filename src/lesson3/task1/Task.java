package lesson3.task1;

import lesson3.nodes.Tree;

public class Task {
    public static void main(String[] args) {
        System.out.println("Реализация красно-черного дерева.");

        Tree myTree = new Tree();

        myTree.add(10);
        myTree.add(20);
        myTree.add(30);
        myTree.add(15);
        myTree.add(25);
        myTree.add(5);

        System.out.println("Добавлены по очереди:");
        System.out.println("10 20 30 15 25 5");

        System.out.println("Вывод от корня (с использованием стэка для перебора нод):");
        myTree.printTreeFromRoot();

        System.out.println("Вывод в отсортированном порядке (перебор нод слева направо):");
        myTree.printRecursiveAndOrdered();
    }
}
