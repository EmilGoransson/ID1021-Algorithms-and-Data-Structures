public class PriorityQueue { //Queue add = O(n), remove = O(1)
    Node head;

    public class Node {
        public Integer item; //data value item
        public Node next; //points to next node

        public Node(Integer item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public void add(Integer item) {// O(n)
        if(head == null || item < head.item) {
            head = new Node(item, head);
        }
        else{
           Node cur = head;
           while(cur.next != null && cur.next.item < item){
               cur = cur.next;
           }
           Node temp = new Node(item, cur.next);
           cur.next = temp;
        }
 /*
        if (head == null) { //if head is empty
            head = new Node(item, null);
        } else if (item < cur.item) { //if item that is being added is smaller than head
            Node newNode = new Node(item, head);
            head = newNode;

        } else {
            while ((cur.next != null) && (item > cur.next.item)) {
                cur = cur.next;
            }
            if (cur.next == null) {
                cur.next = new Node(item, null);
            } else {
                Node newNode = new Node(item, cur.next);
                cur.next = newNode;
            }
        }*/
    }

    public Integer remove() { // O(1)
        Integer ret = head.item;
        Node temp = head;
        head = head.next;
        temp.next = null;
        return ret;
    }

    //print the queue
    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.item);
            cur = cur.next;
        }
    }
}
