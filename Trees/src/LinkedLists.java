

public class LinkedLists {
    BinaryTree.Node head; //The "data" that the specific "LinkedList/Node" hods.
    LinkedLists tail;
    public LinkedLists(BinaryTree.Node head, LinkedLists list) {
        this.head = head;
        tail = list;
    }
    public BinaryTree.Node head() {
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