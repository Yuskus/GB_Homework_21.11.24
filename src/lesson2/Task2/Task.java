/*Задача 2. Реализуйте метод, который находит средний
элемент односвязного списка за один проход по нему. */

package lesson2.Task2;

import lesson2.Nodes.*;

class Task {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, 2, 3, 4, 5);
        ListNode.printWithArrows(listNode, "Start node list:");

        Node middle = findMiddleElement(listNode);
        System.out.println(middle == null ? "Empty list!" : "Middle element: " + middle.val);
    }

    public static Node findMiddleElement(ListNode listNode) {
        if (listNode == null || listNode.head == null)
            return null;
        Node slow = listNode.head;
        Node fast = listNode.head;
        while (fast != null && fast.next != null) {
            if (fast.next.next == null)
                return slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
