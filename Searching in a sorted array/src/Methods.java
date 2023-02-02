import java.util.Random;

public class Methods {
    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }
    public static boolean search_sorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if(array[index]>key)
                break;
            if (array[index] == key) {
                return true;
            }
        }
        return false;
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

    public static int[] randomArray(int[] arr, int n){
        Random random = new Random();
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

}
