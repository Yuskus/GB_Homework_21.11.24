/* Задание 1. Удаление дубликатов в односвязном списке.
 Напишите метод, который удаляет все дубликаты из односвязного списка. */

package lesson2.Task1;

import java.util.HashSet;
import lesson2.Nodes.*;

public class Task {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, 2, 3, 2, 4, 1);
        ListNode.printWithArrows(listNode, "Before removing duplicates:");

        removeDuplicates(listNode);
        ListNode.printWithArrows(listNode, "After removing duplicates:");
    }

    public static void removeDuplicates(ListNode listNode) {
        if (listNode == null || listNode.head == null)
            return;
        Node cur = listNode.head;
        int countBefore = 0;
        HashSet<Integer> hSet = new HashSet<>();
        while (cur != null) {
            hSet.add(cur.val);
            if (countBefore == hSet.size()) {
                listNode.removeNode(cur);
            }
            cur = cur.next;
            countBefore = hSet.size();
        }
    }
}
