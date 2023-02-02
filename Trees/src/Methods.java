import java.util.Random;

public class Methods {
    public static BinaryTree generate(int n) {
        BinaryTree tree = new BinaryTree();
        int[] index = BinaryTree.shuffle(n);
        for (int i = 0; i < n; i++) {
            tree.add(index[i], i);
        }
        return tree;
    }
    public static int[] keys(int n){
        int[] arr = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(n*10);
        }
        return arr;
    }
    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;
        while (true) {
            int index = first + ((last-first)/2);// jump to the middle
            if (array[index] == key) {
                return true;
            }

            if (array[index] < key && index < last) {
// The index position holds something that is less than
// what we're looking for, what is the first possible page?
                first = index+1;
                continue;
            }
            if (array[index] > key && index > first) {
// The index position holds something that is larger than
// what we're looking for, what is the last possible page?
                last = index-1;
                continue;
            }

// Why do we land here? What should we do?
            if(first == index || last == index)
                break;
        }
        return false;
    }
    public static int[] randomArray(int n){
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt(0, n);

        return arr;
    }
    public static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }
    private static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] indx = new int[loop];
        for (int i = 0; i < loop ; i++) {
            indx[i] = rnd.nextInt(n*5);
        }
        return indx;
    }
}