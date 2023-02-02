public class PriorityQueueV2 { //Queue add = O(1), remove = O(n)
    Node head;

    public class Node {
        public Integer item; //data value item
        public Node next; //points to next node

        public Node(Integer item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public void add(Integer item) {
        if (head == null) {
            head = new Node(item, null);
        } else {
            Node temp = new Node(item, head);
            head = temp;
        }
    }

    public Integer remove() {
        Node smallest = head;
        Integer ret = smallest.item;
        Node temp = null;
        Node nxt = head;
        while (nxt.next != null) {
            if (nxt.next.item < smallest.item) {
                smallest = nxt.next;
                temp = nxt;
            }
            nxt = nxt.next;
        }
        if (temp != null) {
            temp.next = smallest.next;
            smallest.next = null;
        } else {
            ret = smallest.item;
            temp = head;
            head = head.next;
            temp.next = null;
        }
        return ret;

    }

    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.item);
            cur = cur.next;
        }
    }
}
