import java.util.Random;

public class Main {
   /* public static void main(String[] args) {
         int n = 6400;
        Random random = new Random();
        int[] arr = new int[n]; // create arr and assign it random numbers between 0-n
        int sum = 0;
        int sum2 = 0;
        int sum3 = 0;
        int loop = 100_000;
        Methods.randomArray(arr, n);

        for (int j = 0; j < loop; j++) { //benchmark unsorted search-algo
            long t0 = System.nanoTime();
            Methods.search_unsorted(arr, random.nextInt(n));
            long t1 = System.nanoTime();
            sum+=t1-t0;
        }
        System.out.println("Unsorted serach: " + (double) (sum) / (loop));

        int[] arr2 = new int[n];

        arr2 = sorted(n);

        for (int j = 0; j < loop; j++) { //benchmark search-algo
            long s0 = System.nanoTime();
            Methods.search_sorted(arr2, random.nextInt(n));
            long s1 = System.nanoTime();
            sum2+=s1-s0;
        }
        System.out.println("Sorted Search: " + (double) (sum2) / (loop));

        for (int j = 0; j < loop; j++) { //benchmark search-algo
            long w0 = System.nanoTime();
            Methods.binary_search(arr2, random.nextInt(n));
            long w1 = System.nanoTime();
            sum3+=w1-w0;
        }
        System.out.println("Binary Sort: " + (double) (sum3) / (loop));
    }*/
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


    class Bench {

        private static void linear(int[] array, int[] indx) {
            for (int i = 0; i < indx.length ; i++) {
                Methods.search_unsorted(array, indx[i]);
            }
        }


        private static void binary(int[] array, int[] indx) {
            for (int i = 0; i < indx.length ; i++) {
                Methods.binary_search(array, indx[i]);
            }
        }


        private static int[] sorted(int n) {
            Random rnd = new Random();
            int[] array = new int[n];
            int nxt = rnd.nextInt(10);

            for (int i = 0; i < n ; i++) {
                array[i] = nxt;
                nxt += rnd.nextInt(10) + 1 ;
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


        public static void main(String[] arg) {

            int[] sizes = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600};

            System.out.printf("# searching through an array of length n, time in ns\n");
            System.out.printf("#%7s%8s%8s\n", "n", "linear", "binary");
            for ( int n : sizes) {

                int loop = 10000;

                int[] array = sorted(n);
                int[] indx = keys(loop, n);

                System.out.printf("%8d", n);

                int k = 1000;

                double min = Double.POSITIVE_INFINITY;

                for (int i = 0; i < k; i++) {
                    long t0 = System.nanoTime();
                    linear(array, indx);
                    long t1 = System.nanoTime();
                    double t = (t1 - t0);
                    if (t < min)
                        min = t;
                }

                System.out.printf("%8.0f", (min/loop));

                min = Double.POSITIVE_INFINITY;

                for (int i = 0; i < k; i++) {
                    long t0 = System.nanoTime();
                    binary(array, indx);
                    long t1 = System.nanoTime();
                    double t = (t1 - t0);
                    if (t < min)
                        min = t;
                }

                System.out.printf("%8.0f\n" , (min/loop));
            }
        }
    }
}
