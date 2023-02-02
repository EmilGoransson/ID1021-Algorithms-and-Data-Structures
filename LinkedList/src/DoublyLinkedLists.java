public class DoublyLinkedLists {
    int value;
    DoublyLinkedLists next;
    DoublyLinkedLists prev;

    public DoublyLinkedLists(int item, DoublyLinkedLists tail,DoublyLinkedLists head) {
        value = item;
        this.next = tail;
        this.prev = head;
    }
    public int value() {
        return this.value;
    }
    public DoublyLinkedLists next() {
        return this.next;
    }
    public DoublyLinkedLists prev(){
        return this.prev;
    }
    public void append(DoublyLinkedLists b) { //addfirst
        DoublyLinkedLists nxt = this;
        while (nxt.next != null) {
            nxt = nxt.next;
        }
        nxt.next = b;
        b.prev = nxt;
    }
    public static void printDoublyList(DoublyLinkedLists a){
        DoublyLinkedLists nxt = a;
        System.out.println("[" + nxt.value());
        while(nxt.next !=null){
            nxt = nxt.next;
            System.out.println(", " + nxt.value());
        }
    }
}