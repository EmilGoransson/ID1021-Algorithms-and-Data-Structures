import java.util.Iterator;
import java.util.Random;

public class HeapBinaryTree {
    Node root;

    public class Node {
        public Integer key;
        public Node left, right;
        public int size;
        public int value;

        public Node(Integer key) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        private Integer add(Integer key, int depth) { //PROBLEM MED DÅ MAN LÄGGER TILL NY ROT.
            Node cur = this;
            cur.size++;

            if (key < cur.key) {
                int temp = cur.key;
                cur.key = key;
                key = temp;
            }
            if (cur.left == null) {
                cur.left = new Node(key);
                return depth;
            }
            if (cur.right == null) {
                cur.right = new Node(key);
                return depth;
            }
            if (cur.left.size < cur.right.size) {
                return cur.left.add(key, depth + 1 );

            } else {
                return cur.right.add(key, depth + 1);
            }
        }
        private Integer add(Integer key){
            return add(key, 0);
        }

        private Node remove() { //FUNGERAR BRA!
            Node cur = this;
            if (cur.left == null) {
                return cur.right;
            }
            if (cur.right == null) {
                return cur.left;
            }
            if (cur.left.key < cur.right.key) {
                cur.key = cur.left.key;
                cur.size--;
                if (cur.left.size == 0)
                    cur.left = null;
                else
                    cur.left = cur.left.remove();
                return cur;
            } else {
                cur.key = cur.right.key;
                cur.size -= 1;
                if (cur.right.size == 0)
                    cur.right = null;
                else
                    cur.right = cur.right.remove();
                return cur;
            }
        }

        private Integer push(Integer incr) { //FUNGERAR BRA!
            Node cur = this;
            cur.key += incr;
            Integer depth = 0;
            while (cur.size != 0) {
                if (cur.left != null && cur.left.key <= cur.key) {
                    Integer temp = cur.key;
                    cur.key = cur.left.key;
                    cur.left.key = temp;
                    cur = cur.left;
                    depth++;
                } else if (cur.right != null && cur.right.key <= cur.key) {
                    Integer temp = cur.key;
                    cur.key = cur.right.key;
                    cur.right.key = temp;
                    cur = cur.right;
                    depth++;
                } else {
                    break;
                }
            }
            return depth;
        }


        public void print() {
            if (root == null)
                System.out.println("Tree empty");
            if (left != null) left.print();
            System.out.println(" key: " + key);
            if (right != null) right.print();
        }


    }


    public HeapBinaryTree() {
        root = null;
    }
//print the tree


    public Integer add(Integer key) {
        if (root == null) {
            root = new Node(key);
            return 0;
        } else {
            return root.add(key);
        }
    }

    public Integer remove() {
        if (root == null)
            return null;
        if (root.size == 0) {
            Integer ret = root.key;
            root = null;
            return ret;
        } else {
            root = root.remove();
        }
        return root.key;
    }

    public Integer push(Integer incr) {
        Integer depth = 0;
        if (root == null)
            return null;

        else
            depth = root.push(incr);
        return depth;
    }
}


