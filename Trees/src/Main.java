import java.util.Random;

public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);
        for (int i : tree)
            System.out.println("next value " + i);
    }



    public static void bench() {
        int[] sizes = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
        Random rnd = new Random();
        for (int n : sizes) {
            int loops = 100_0000;
            double totalTime = 0;
            for (int i = 0; i < loops; i++) {
                BinaryTree tree = Methods.generate(n);
                int key = rnd.nextInt(n);

                long t0 = System.nanoTime();
                tree.lookup(key);
                long t1 = System.nanoTime();
                totalTime += (t1 - t0);
            }
            totalTime = totalTime / loops;
            System.out.println("TREE SERACH: N Size = " + n + " Time = " + totalTime);

        }
    }

    public static void benchBinary() {
        int[] sizes = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
        Random rnd = new Random();
        for (int n : sizes) {
            int loops = 100_0000;
            double totalTime = 0;
            for (int i = 0; i < loops; i++) {
                int[] rndArray = Methods.sorted(n);
                int key = rnd.nextInt(n);

                long t0 = System.nanoTime();
                Methods.binary_search(rndArray, key);
                long t1 = System.nanoTime();
                totalTime += (t1 - t0);
            }
            totalTime = totalTime / loops;
            System.out.println("BINARY SEARCH: N Size = " + n + " Time = " + totalTime);

        }
    }
}


