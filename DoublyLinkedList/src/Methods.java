import java.util.Random;

public class Methods {
    public static DoublyLinked generateList(int n) { //size n
        Random random = new Random();
        DoublyLinked listTotal = new DoublyLinked(random.nextInt(10 * n), null, null);
        for (int i = 0; i < n - 1; i++) { //genererar list a with n size
            DoublyLinked tempList = new DoublyLinked(random.nextInt(10 * n), null, null);
            listTotal.append(tempList);
        }
        return listTotal;
    }

    public static DoublyLinked[] getArrayFromList(DoublyLinked a, int size) {
        DoublyLinked list = a;
        DoublyLinked[] arrayDoubly = new DoublyLinked[size];
        int i = 0;
        while (i != size) {
            arrayDoubly[i] = list;
            list = list.next;
            i++;
        }
        return arrayDoubly;
    }

    public static DoublyLinked generatelist(int[] array) {  //generate doublylinkedlist with values from array
        DoublyLinked listTotal = new DoublyLinked(array[0], null, null);

        for (int i = 1; i < array.length; i++) {
            DoublyLinked tempList = new DoublyLinked(array[i], null, null);
            listTotal.append(tempList);
        }
        return listTotal;
    }

    public static void printArrayList(DoublyLinked[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].value + ", ");
        }
        System.out.println("]");
    }

}