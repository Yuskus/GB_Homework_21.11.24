package lesson2.Nodes;

public class ListNode {
    public Node head;
    public Node tail;
    public int count;

    public ListNode() {
    }

    public ListNode(Integer... args) {
        addRange(args);
    }

    public ListNode(ListNode listNode) {
        addRange(listNode);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void add(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }

        tail = node;
        count++;
    }

    public void addFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (count == 0)
            tail = head;
        count++;
    }

    public void addRange(Integer[] args) {
        for (int i = 0; i < args.length; i++) {
            add(args[i]);
        }
    }

    public void addRange(ListNode listNode) {
        if (listNode == null)
            return;
        for (int i = 0; i < listNode.count; i++) {
            add(listNode.pop().val);
        }
    }

    public boolean removeNode(Node node) {
        Node cur = head;
        Node prev = null;

        while (cur != null) {
            if (cur == node) {
                if (prev != null) {
                    prev.next = cur.next;
                    if (cur.next == null)
                        tail = prev;
                } else {
                    head = head.next;
                    if (head == null)
                        tail = null;
                }
                count--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }

        return false;
    }

    public boolean removeValue(int val) {
        Node cur = head;
        Node prev = null;

        while (cur != null) {
            if (cur.val == val) {
                if (prev != null) {
                    prev.next = cur.next;
                    if (cur.next == null)
                        tail = prev;
                } else {
                    head = head.next;
                    if (head == null)
                        tail = null;
                }
                count--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }

        return false;
    }

    public Node pop() {
        if (head == null)
            throw new IllegalStateException("Node list is empty!");
        Node res = head;
        head = head.next;
        return res;
    }

    public static void printWithArrows(ListNode listNode) {
        if (listNode == null || listNode.head == null)
            return;
        Node cur = listNode.head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur != listNode.tail)
                System.out.print(" -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void printWithArrows(ListNode listNode, String description) {
        System.out.println(description);
        printWithArrows(listNode);
    }
}
