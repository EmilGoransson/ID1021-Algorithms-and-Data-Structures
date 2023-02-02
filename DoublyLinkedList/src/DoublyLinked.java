public class DoublyLinked {
    int value;
    DoublyLinked next; // tail
    DoublyLinked prev; // head

    public DoublyLinked(int value, DoublyLinked next, DoublyLinked prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public int getValue() {
        return this.value;
    }

    public void append(DoublyLinked b) {
        DoublyLinked nxt = this;
        while(nxt.next != null)
        {
            nxt = nxt.next;
        }
        nxt.next = b;
        b.prev = nxt;
    }

    public void addFirst(DoublyLinked b) {
        DoublyLinked nxt = this;
        b.next = nxt;
        nxt.prev = b;
    }

    public DoublyLinked[] getArray(int size) {
        DoublyLinked nxt = this;
        DoublyLinked[] array = new DoublyLinked[size];

        int i = 0;
        while (i != size) {
            array[i] = nxt;
            nxt = nxt.next;
            i++;
        }
        return array;

    }


    public DoublyLinked searchNode(int n) {
        DoublyLinked nxt = this; //pekar på node nr1
        while (nxt != null && nxt.value != n) {
            prev = nxt;
            nxt = nxt.next;
        }
        return nxt;
    }

    public DoublyLinked deletetestn2(DoublyLinked nxt) { //use in conjunction wiith serachNode

        if (nxt != null && prev != null && nxt.next != null) {
            prev.next = nxt.next;
            nxt.next.prev = nxt.prev;
        }
        if (prev == null)
            return nxt.next;

        if (nxt != null && nxt.next == null)
            prev.next = null;

        if (nxt.next == null && nxt.prev == null) {
            return null;
        }
        return this;
    }

    public DoublyLinked delete(int n) { //serach and find value _> delete
        DoublyLinked nxt = this; //pekar på node nr1
        while (nxt != null && nxt.value != n) {
            prev = nxt;
            nxt = nxt.next;
        }
        if (nxt != null && prev != null && nxt.next != null) {
            prev.next = nxt.next;
            nxt.next.prev = nxt.prev;
        }
        if (prev == null)
            return nxt.next;

        if (nxt != null && nxt.next == null)
            prev.next = null;

        if (nxt.next == null && nxt.prev == null) {
            return null;
        }
        return this;
    }

    public DoublyLinked removeNode(DoublyLinked[] array, int index) {
        DoublyLinked nxt = array[index]; //pekar på nod
        if (nxt != null && prev != null && nxt.next != null) {
            prev.next = nxt.next;
            nxt.next.prev = nxt.prev;
        }
        if (prev == null)
            return nxt.next;

        if (nxt != null && nxt.next == null)
            prev.next = null;

        if (nxt.next == null && nxt.prev == null) {
            return null;
        }
        return null;
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