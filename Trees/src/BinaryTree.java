import java.util.Iterator;
import java.util.Random;

public class BinaryTree implements Iterable<Integer> {

    public static int[] shuffle(int n) {
        Random rnd = new Random();
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int swap = rnd.nextInt(n);
            int temp = index[swap];
            index[swap] = index[i];
            index[i] = temp;
        }

        return index;
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }

    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        private void add(Integer key, Integer value) {
            if (this.key == key) {
                this.value = value;
                return;
            }
            if (this.key > key)
                if (this.left != null)
                    this.left.add(key, value);
                else
                    this.left = new Node(key, value);
            else {
                if (this.right != null)
                    this.right.add(key, value);
                else
                    this.right = new Node(key, value);
            }
        }

        public void print() {

            if (left != null) left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if (right != null) right.print();
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(Integer key, Integer value) {
        if (root == null) {
            root = new Node(key, value);
        } else root.add(key, value);
    }

    public Integer lookup(Integer key) {
        Node cur = this.root;
        while (cur != null) {
            if (cur.key == key) return cur.value;
            if (cur.key < key) cur = cur.right;
            else cur = cur.left;
        }
        return null;
    }


    public class TreeIterator implements Iterator<Integer> {
        private Node current;
        private Stack stack;

        public TreeIterator() {
            this.stack = new Stack();
            current = root;

            while (current.left != null) {
                if (current == root)
                    stack.push(root);
                stack.push(current.left);
                current = current.left;
            }

        }

        @Override
        public boolean hasNext() {
            if (stack.empty()) return false;
            return true;
        }

        @Override
        public Integer next() {
            BinaryTree.Node temp = stack.pop();
            current = temp;
            if (current.right != null) {
                current = current.right;
                stack.push(current);
                while (current.left != null) {
                    stack.push(current.left);
                    current = current.left;
                }
            }
            return temp.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
