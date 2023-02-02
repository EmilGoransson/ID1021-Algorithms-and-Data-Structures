public class DStack { //TASK 3
    int size;
    LinkedLists Stack;
    int sp;

    public DStack(int a) {
        LinkedLists temp = new LinkedLists(a, null);
        Stack = temp;
    }

    public void push(int t) {
        LinkedLists tempValue = new LinkedLists(t, null);
        Stack.append(tempValue);
    }

    public int pop() {
        LinkedLists ret = Stack;
        while (ret.tail().tail() != null) {
            ret = ret.tail();
        }
        int returnvalue = ret.tail().head();
        ret.tail = null;
        return returnvalue;
    }

}