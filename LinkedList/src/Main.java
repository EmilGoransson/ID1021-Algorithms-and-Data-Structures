import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int constantSize = 100;

        //benchmark for task 1
        int[] sizes = {128, 256, 512, 1024, 2048, 4096, 8192};
        int loops = 1000;
        /*for (int n : sizes) { //Benchmark task 1.2 (notice sizes on ListA/ListB)
            double minValue = Double.POSITIVE_INFINITY;

            for (int i = 0; i < loops; i++) {
                LinkedLists listA = Methods.generateList(n);
                LinkedLists listB = Methods.generateList(constantSize);

                double t0 = System.nanoTime();
                listA.append(listB);
                double t1 = System.nanoTime();

                if ((t1 - t0) < minValue)
                    minValue = (t1 - t0);
                }
            System.out.println("N: " + n + " Time: " + minValue);
            }*/
        /* for (int n : sizes) { //benchmark task 1.2 switched sizes
            double minValue = Double.POSITIVE_INFINITY;

            for (int i = 0; i < loops; i++) {
                LinkedLists listA = Methods.generateList(constantSize);
                LinkedLists listB = Methods.generateList(n);

                double t0 = System.nanoTime();
                listA.append(listB);
                double t1 = System.nanoTime();

                if ((t1 - t0) < minValue && (t1 - t0 > 0)) {
                    minValue = (t1 - t0);
                }
            }
            System.out.println("N: " + n + " Time: " + minValue);
        } */

       /* int[] test;
       for (int n : sizes) { //Benchmark 2.1 (Arrays!) USE 10_000 LOOP!
            double minValue = Double.POSITIVE_INFINITY;

            for (int i = 0; i < loops; i++) {
                int[] arrayA = Methods.generateArray(n);
                int[] arrayB = Methods.generateArray(constantSize);

                long t0 = System.nanoTime();
                Methods.arrayAppend(arrayA, arrayB);
                long t1 = System.nanoTime();
                if ((t1-t0) < minValue)
                    minValue  = (double) t1-t0;
            }
            System.out.println("N: " + n + " Time: " + minValue);
        } /*
         /*for (int n : sizes) { //Benchmark 2.2 (Arrays!) USE 10_000 LOOPS!
            double minValue = Double.POSITIVE_INFINITY;

            for (int i = 0; i < loops; i++) {
                int[] arrayA = Methods.generateArray(constantSize);
                int[] arrayB = Methods.generateArray(n);

                double t0 = System.nanoTime();
                Methods.arrayAppend(arrayA, arrayB);
                double t1 = System.nanoTime();

                if ((t1 - t0) < minValue)
                    minValue = (t1 - t0);
            }
            System.out.println("N: " + n + " Time: " + minValue);
        } */

        /*for (int n : sizes) { //Benchmark task 2.3 (GenerateList benchmark) //use lower N values
            double minValue = Double.POSITIVE_INFINITY;

            for (int i = 0; i < loops; i++) {

                double t0 = System.nanoTime();
                Methods.generateList(n);
                double t1 = System.nanoTime();

                if ((t1 - t0) < minValue)
                    minValue = (t1 - t0);
            }
            System.out.println("N: " + n + " Time: " + minValue);
        } */
        for (int n : sizes) { //Benchmark task 2.4 (GenerateArray benchmark) //use lower N values
            double minValue = Double.POSITIVE_INFINITY;

            for (int i = 0; i < loops; i++) {

                long t0 = System.nanoTime();
                Methods.generateArray(n);
                long t1 = System.nanoTime();

                if ((t1 - t0) < minValue)
                    minValue =  (t1 - t0);
            }
            System.out.println("N: " + n + " Time: " + minValue);
        }
        LinkedLists list =  new LinkedLists(5, null);
        list.append(new LinkedLists(5, null));
        //DStack stack = new DStack(5); // TASK 3


    }
}




