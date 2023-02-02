public class Stack{ //TASK 3
    LinkedLists stack;

    public Stack() {
        LinkedLists temp = new LinkedLists(null, null); //skapar en
        stack = temp;
    }
    public void push(BinaryTree.Node point) {
        LinkedLists tempValue = new LinkedLists(point, null);
        stack.append(tempValue);
    }

    public BinaryTree.Node pop() {
        LinkedLists ret = stack;
        while (ret.tail().tail() != null) {
            ret = ret.tail();
        }
        BinaryTree.Node retNode = ret.tail().head();
        ret.tail = null;
        return retNode;
    }
    public BinaryTree.Node getNode(){
        return stack.head;
    }
    public boolean empty(){
        if(stack.tail == null)
            return true;
        return false;
    }
}