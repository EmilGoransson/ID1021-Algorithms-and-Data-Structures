public class LinkedLists {
    int head;
    LinkedLists tail;

    public LinkedLists(int item, LinkedLists list) {
        head = item;
        tail = list;
    }

    public LinkedLists delete(int n) { //delete node with variable n as head and returns updated list
        LinkedLists nxt = this; //pekar på node nr1
        LinkedLists prev = null;
        while (nxt != null && nxt.head != n) {
            prev = nxt;
            nxt = nxt.tail;
        }
        if (nxt != null && prev != null) {
            prev.tail = nxt.tail;
        }
        if (prev == null) {
            return nxt.tail;
        } else {
            return this;
        }
    }

    public LinkedLists add(int key) {
        return new LinkedLists(key, this);
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


    public void append(LinkedLists b) { //addfirst
        LinkedLists nxt = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }

}