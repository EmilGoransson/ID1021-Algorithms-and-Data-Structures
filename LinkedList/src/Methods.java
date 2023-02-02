import java.util.Random;

public class Methods {
    public static LinkedLists generateList(int n) { //size n
        Random random = new Random();
        LinkedLists listTotal = new LinkedLists(random.nextInt(10*n), null);

        for (int i = 0; i < n-1; i++) { //genererar list a with n size
            LinkedLists tempList = new LinkedLists(random.nextInt(10 * n), null);
            listTotal.append(tempList);
        }
        return listTotal;
    }
    public static int[] arrayAppend(int[] array, int[] array2){
        int[] newArray = new int[array.length + array2.length];
        int length = array.length;
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        for (int i = 0; i < array2.length; i++) {
            newArray[i+length] = array2[i];
        }
        return newArray;
    }
    public static int[] generateArray(int n){
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(10*n);
        }
        return array;
    }
}