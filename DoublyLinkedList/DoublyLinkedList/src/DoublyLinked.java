public class DoublyLinked {
    int value;
    DoublyLinked next; // tail
    DoublyLinked prev; // head

    public DoublyLinked(int value, DoublyLinked next, DoublyLinked prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
    public DoublyLinked(DoublyLinked a){ //copy node
        this.value = a.value;
        this.next = a.next;
        this.prev = a.prev;
    }

    public void append(DoublyLinked b) {
        DoublyLinked nxt = this;
        while (nxt.next != null) {
            nxt = nxt.next;
        }
        nxt.next = b;
        b.prev = nxt;
    }

    public void deleteFinal() {
        DoublyLinked nxt = this;
        if(nxt.next == null && nxt.prev == null){
            Main.a = null;
        }
        else if (nxt.prev == null) { //if prev node is null
            Main.a = Main.a.next;
            this.next.prev = null;
        } else if (nxt.next == null) {
            nxt.prev.next = null;
            nxt.prev = null;
        } else {
            nxt.prev.next = nxt.next;
            nxt.next.prev = nxt.prev;
            nxt.next = null;
            nxt.prev = null;
        }
    }

    public void addFirst() {
     DoublyLinked nxt = this;
     nxt.next = Main.a;
     Main.a.prev = next;
     nxt.next.prev = nxt;
     nxt.prev = null;
     Main.a = nxt;
    }







    public static void print(DoublyLinked a) {
        if (a == null)
            System.out.print("[]");
        else {
            DoublyLinked nxt = a;
            System.out.print("[" + nxt.value);
            while (nxt.next != null) {
                nxt = nxt.next;
                System.out.print(", " + nxt.value);
            }
            System.out.println("]");
        }
    }
}