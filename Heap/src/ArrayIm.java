
import java.util.Random;

public class ArrayIm {
    Integer[] Heap;
    int k;		// last index

    public ArrayIm(int n) {
        Heap = new Integer[n * 2];
        k = 0;
    }

    public void add(Integer element){
        this.Heap[++k] = element;
        int temp = k;
        int temp2;
        if(temp%2 == 0) {
            while (temp > 1 && Heap[temp] < Heap[(temp - 2) / 2]) {
                temp2 = Heap[temp];
                Heap[temp] = Heap[(temp - 2) / 2];
                Heap[(temp - 2) / 2] = temp2;
                temp = (temp - 2) / 2;
            }
        }
        if(temp%2 == 1){

            while (Heap[temp] < Heap[(temp - 1) / 2]) {
                temp2 = Heap[temp];
                Heap[temp] = Heap[(temp - 1) / 2];
                Heap[(temp - 1) / 2] = temp2;
                temp = (temp - 1) / 2;
            }
        }
    }
    public void print() {
        for (int i = 0; i < k; i++) {
            System.out.println(Heap[i]);
        }
    }
}