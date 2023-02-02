public class LinkedLists {
    int head;
    LinkedLists tail;

    public LinkedLists(int item, LinkedLists list) {
        head = item;
        tail = list;
    }

    public int head() {
        return this.head;
    }

    public LinkedLists delete(int key) {
        LinkedLists nxt = this;
        LinkedLists prev = null;
        while (nxt != null) {
            if (nxt.head == key) {
                prev.tail = nxt.tail;
                break;
            }
            prev = nxt;
            nxt = nxt.tail;
        }
        if (this == nxt)
            return null;
        else
            return this;
    }

    public void print() {

        LinkedLists nxt = this;
        System.out.print("[" + nxt.head);
        while (nxt.tail != null) {
            nxt = nxt.tail;
            System.out.print(", " + nxt.head);
        }
        System.out.println("]");
    }

    public LinkedLists tail() {
        return this.tail;
    }

    public void append(LinkedLists b) { //addfirst
        LinkedLists nxt = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }

    public LinkedLists addFirst(LinkedLists b) {
        LinkedLists nxt = this;
        b.append(nxt);
        return b;
    }


}