import java.util.Random;

public class Main {
    public static void main(String[] args) {
    int k = 2;
    int[] sizes = {5};




        for(int n : sizes){


        int[] sequence = new int[k];
        Random rnd = new Random();
        for (int i = 0; i < k; i++) {
            sequence[i] = rnd.nextInt(n);
        }


        DoublyLinked list = new DoublyLinked(0, null, null);
        for (int i = 0; i < k; i++) {
            list.append(new DoublyLinked(sequence[i], null, null));
        }
        System.out.println("First Append test!");
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < sequence.length; i++) {
            DoublyLinked candi = list.searchNode(sequence[i]);
            System.out.println("Seq test!");
            long t0 = System.nanoTime();
          //  list = list.deletetestn2(candi);
            list.addFirst(candi);
            System.out.println("Add test!");

            long t1 = System.nanoTime();
            double mincandi = (t1-t0);
            if(mincandi < min)
                min = mincandi;
        }
        System.out.println("N: " + n + " Time: " + min);

        //benchmark block


    }

}
}