import java.util.Arrays;
import java.util.Random;

public class Main {
    public static DoublyLinked a = new DoublyLinked(0, null, null); //MAKES A GLOBAL SO THAT WE CAN MAKE A NULL AND CHANGE WHAT NODE A IS REFERENCING

    public static void main(String[] args) {

        bench();


    }

    public static void bench() {
        int k = 10;
        int[] sizes = {128, 256, 512, 1024, 2048, 4096, 8192, 16384};
        for (int n : sizes) {

            //generates DoublyLinked nodes
            DoublyLinked[] arrayDoubly = new DoublyLinked[n];
            Main.a = Methods.generateList(n);
            DoublyLinked test = Main.a;

            LinkedLists Llist = Methods.generateListLinked(n);


            //Generates DoulbyLinked[] (array) containing the DoulbyLinked nodes.

            for (int i = 0; i < n; i++) {
                arrayDoubly[i] = test;
                if (test.next != null)
                    test = test.next;
            }

            int[] indxes = new int[k];
            Random rnd = new Random();
            for (int i = 0; i < k; i++) {
                indxes[i] = rnd.nextInt(n);
            }
            double min = Double.POSITIVE_INFINITY;
            double min2 = Double.POSITIVE_INFINITY;
            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                arrayDoubly[indxes[i]].deleteFinal();
                arrayDoubly[indxes[i]].addFirst();
                long t1 = System.nanoTime();
                if (t1 - t0 < min && t1 - t0 > 0)
                    min = (double) t1 - t0;

                double tot = 0;
                for (int j = 0; j < 1; j++) {
                    long t2 = System.nanoTime();
                    Llist.delete(indxes[i]);
                    Llist.add(indxes[i]);
                    long t3 = System.nanoTime();
                    tot = t3 - t2;
                }
                min2 = tot / 1;
            }


                System.out.println(" N = " + n + " tid DOUBLE = " + min + " tid SINGLE = " + min2);


            }
        }

    }

