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
}