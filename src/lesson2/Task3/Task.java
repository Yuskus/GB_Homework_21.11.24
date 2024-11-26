/* Задание 3. Реализуйте метод, который сливает два отсортированных 
односвязных списка в один отсортированный список. */

package lesson2.Task3;

import lesson2.Nodes.*;

public class Task {
    public static void main(String[] args) {
        ListNode first = new ListNode(1, 3, 5);
        ListNode second = new ListNode(2, 4, 6);
        ListNode merged = mergeSortedLists(first, second);

        ListNode.printWithArrows(first, "First sorted node list:");
        ListNode.printWithArrows(second, "Second sorted node list:");
        ListNode.printWithArrows(merged, "Merged node lists:");
    }

    public static ListNode mergeSortedLists(ListNode a, ListNode b) {
        // Если один из списков null или пуст, возвращается копия второго
        // Если оба null или пусты, вернется пустой инициализированный список
        if (a == null || a.isEmpty())
            return new ListNode(b);
        if (b == null || b.isEmpty())
            return new ListNode(a);

        // Создаём итоговый экземпляр
        ListNode result = new ListNode();

        // Фиксируем сумму элементов
        int sumCount = a.count + b.count;

        // Создаём указатели на первые элементы списков "a" и "b"
        Node aCurrent = a.head;
        Node bCurrent = b.head;

        // Перебираем списки, добавляя минимальный имеющийся элемент в "result"
        while (result.count != sumCount) {
            if (aCurrent == null) {
                result.add(bCurrent.val);
                bCurrent = bCurrent.next;
            } else if (bCurrent == null) {
                result.add(aCurrent.val);
                aCurrent = aCurrent.next;
            } else {
                if (aCurrent.val < bCurrent.val) {
                    result.add(aCurrent.val);
                    aCurrent = aCurrent.next;
                } else {
                    result.add(bCurrent.val);
                    bCurrent = bCurrent.next;
                }
            }
        }
        return result;
    }
}
