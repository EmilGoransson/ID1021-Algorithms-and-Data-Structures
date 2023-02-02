public class HeapArray { //heap using array
    private Integer[] heap;
    private int size;

    public HeapArray(int capacity) {
        heap = new Integer[capacity];
        size = 0;
    }

    public void add(Integer item) {
        if (size == heap.length) {
            throw new IllegalStateException("No space left in heap");
        }
        heap[size] = item;
        int index = size;
        int parent = (index - 1) / 2;
        while (index > 0 && heap[index] < heap[parent]) {
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            index = parent;
            parent = (index - 1) / 2;
        }
        size++;
    }


    public Integer remove() {
        if (size == 0) {
            throw new IllegalStateException("The heap is empty");
        }
        int item = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        int index = 0;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size) {
            int smallest = left;
            if (right < size && heap[right] < heap[left]) {
                smallest = right;
            }
            if (heap[index] < heap[smallest]) {
                break;
            }
            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;
            index = smallest;
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
        return item;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(heap[i]);
        }
    }

}
