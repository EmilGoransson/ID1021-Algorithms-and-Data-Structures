

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        HeapArray arr = new HeapArray(10);
        arr.add(4);
        arr.add(5);
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.print();
        arr.remove();
        arr.remove();

        System.out.println("------");
        arr.print();


    }

    public static void bench_1_Add() {
        int[] sizes = {100, 400, 800, 1600, 3200, 6400, 12800};
        Random rnd = new Random();
        for (int n : sizes) {
            PriorityQueue queue = new PriorityQueue();

            int loops = 10000;
            double totalTime = 0;

            for (int i = 0; i < loops; i++) {
                int key = rnd.nextInt(n);
                long t0 = System.nanoTime();
                queue.add(key);
                long t1 = System.nanoTime();
                totalTime += (t1 - t0);
            }
            totalTime = totalTime / (loops * n);
            System.out.println("Queue_1_Add: N Size = " + n + " Time = " + totalTime);

        }
    }

    public static void bench_1_remove() {
        Random rnd = new Random();
        for (int n = 1000; n <= 10000; n += 1000) {
            PriorityQueue queue = new PriorityQueue();

            int loops = 100_0;
            double totalTime = 0;
            for (int i = 0; i < loops; i++) {
                queue.add(rnd.nextInt(n));
            }
            for (int i = 0; i < loops; i++) {
                long t0 = System.nanoTime();
                queue.remove();
                long t1 = System.nanoTime();
                totalTime += (t1 - t0);
            }
            totalTime = totalTime / loops;
            System.out.println("Queue_1_Add: N Size = " + n + " Time = " + totalTime);

        }
    }

    public static void bench_2_add() {
        int[] sizes = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
        Random rnd = new Random();
        PriorityQueueV2 queue = new PriorityQueueV2();
        for (int n = 1000; n <= 10000; n += 1000) {
            int loops = 100_0000;
            double totalTime = 0;

            for (int i = 0; i < loops; i++) {
                int key = rnd.nextInt(n);
                long t0 = System.nanoTime();
                queue.add(key);
                long t1 = System.nanoTime();
                totalTime += (t1 - t0);
            }
            totalTime = (double) totalTime / loops;
            System.out.println("Queue_1_Add: N Size = " + n + " Time = " + totalTime);

        }
    }

    public static void bench_2_remove() {
        int[] sizes = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096};
        Random rnd = new Random();
        PriorityQueueV2 queue = new PriorityQueueV2();
        for (int n = 1000; n <= 10000; n += 1000) {
            int loops = 100_0000;
            double totalTime = 0;
            for (int i = 0; i < loops; i++) {
                long t0 = System.nanoTime();
                Integer a = queue.remove();
                long t1 = System.nanoTime();
                totalTime += (t1 - t0);
            }
            totalTime = totalTime / loops;
            System.out.println("Queue_1_Add: N Size = " + n + " Time = " + totalTime);

        }
    }

    public static void benchaddn() {
        Random ra = new Random();

        for (int n = 1000; n <= 10000; n += 1000) { //Average time of one add operation per n
            PriorityQueue tester = new PriorityQueue();
            double avgadd = 0;
            double avgrev = 0;

            int k = 0;
            int superloop = 100;
            int o = 0;
            while (o < superloop) {
                long t0 = System.nanoTime();
                while (k < n) {
                    tester.add(ra.nextInt(n * 5));
                    k++;
                }
                long t1 = System.nanoTime();
                long t2 = System.nanoTime();
                while (k > 0) {
                    Integer a = tester.remove();
                    k--;
                }
                long t3 = System.nanoTime();

                avgadd += (double) t1 - t0;

                avgrev += (double) t3 - t2;
                o++;
            }
            System.out.println(n + " stor, add: " + avgadd / (n * superloop) + " remove: " + avgrev / (n * superloop));
        }

    }

    public static void benchHeapPush() {
        HeapBinaryTreeV2 test = new HeapBinaryTreeV2();
        Random rnd = new Random();
        int depth;
        int depthAdd = 0;
        int loop = 1000;
        int[] rand64 = new int[64];
        int[] randPush = new int[64];
        for (int i = 0; i < 64; i++) {
            rand64[i] = rnd.nextInt(100);
            randPush[i] = rnd.nextInt(20);
            test.add(rand64[i]);
        }
        int sum0 = 0;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;
        int sum5 = 0;
        int sum6 = 0;
        int depth0 = 0;
        int depth1 = 0;
        int depth2 = 0;
        int depth3 = 0;
        int depth4 = 0;
        int depth5 = 0;
        int depth6 = 0;
        long t1 = 0;
        long t2 = 0;
        int depth0Add = 0;
        int depth1Add = 0;
        int depth2Add = 0;
        int depth3Add = 0;
        int depth4Add = 0;
        int depth5Add = 0;
        int depth6Add = 0;
        int sum0Add = 0;
        int sum1Add = 0;
        int sum2Add = 0;
        int sum3Add = 0;
        int sum4Add = 0;
        int sum5Add = 0;
        int sum6Add = 0;
        for (int i = 0; i < loop; i++) {
            HeapBinaryTreeV2 testAdd = new HeapBinaryTreeV2();

            for (int j = 0; j < 64; j++) {
                long t0 = System.nanoTime();
                depthAdd = testAdd.add(rand64[j]);
                t2 = System.nanoTime() - t0;
                switch (depthAdd) {
                    case 0:
                        depth0Add++;
                        sum0Add += t2;
                        break;
                    case 1:
                        depth1Add++;
                        sum1Add += t2;
                        break;
                    case 2:
                        depth2Add++;
                        sum2Add += t2;
                        break;
                    case 3:
                        depth3Add++;
                        sum3Add += t2;
                        break;
                    case 4:
                        depth4Add++;
                        sum4Add += t2;
                        break;
                    case 5:
                        depth5Add++;
                        sum5Add += t2;
                        break;
                    case 6:
                        depth6Add++;
                        sum6Add += t2;
                        break;
                }
            }
            for (int j = 0; j < 64; j++) {
                long t0 = System.nanoTime();
                depth = test.push(randPush[j]);
                t1 = System.nanoTime() - t0;
                switch (depth) {
                    case 0:
                        sum0 += t1;
                        depth0++;
                        break;
                    case 1:
                        sum1 += t1;
                        depth1++;
                        break;
                    case 2:
                        sum2 += t1;
                        depth2++;
                        break;
                    case 3:
                        sum3 += t1;
                        depth3++;
                        break;
                    case 4:
                        sum4 += t1;
                        depth4++;
                        break;
                    case 5:
                        sum5 += t1;
                        depth5++;
                        break;
                    case 6:
                        sum6 += t1;
                        depth6++;
                        break;
                }

            }
        }
        if (depth0 != 0)
            System.out.println("Avg Depth 0: " + (double) depth0 / loop + "| Avg Time per depth: " + sum0 / depth0);
        if (depth1 != 0)
            System.out.println("Avg Depth 1: " + (double) depth1 / loop + "| Avg Time per depth: " + sum1 / depth1);
        if (depth2 != 0)
            System.out.println("Avg Depth 2: " + (double) depth2 / loop + "| Avg Time per depth: " + sum2 / depth2);
        if (depth3 != 0)
            System.out.println("Avg Depth 3: " + (double) depth3 / loop + "| Avg Time per depth: " + sum3 / depth3);
        if (depth4 != 0)
            System.out.println("Avg Depth 4: " + (double) depth4 / loop + "| Avg Time per depth: " + sum4 / depth4);
        if (depth5 != 0)
            System.out.println("Avg Depth 5: " + (double) depth5 / loop + "| Avg Time per depth: " + sum5 / depth5);
        System.out.println("----------------");
        if (depthAdd != 0)
            System.out.println("Avg depthAdd 0: " + (double) depth0Add / loop + "| Avg Time: " + sum0Add / depth0Add);
        if (depthAdd != 0)
            System.out.println("Avg depthAdd 1: " + (double) depth1Add / loop + "| Avg Time: " + sum1Add / depth1Add);
        if (depthAdd != 0)
            System.out.println("Avg depthAdd 2: " + (double) depth2Add / loop + "| Avg Time: " + sum2Add / depth2Add);
        if (depthAdd != 0)
            System.out.println("Avg depthAdd 3: " + (double) depth3Add / loop + "| Avg Time: " + sum3Add / depth3Add);
        if (depthAdd != 0)
            System.out.println("Avg depthAdd 4: " + (double) depth4Add / loop + "| Avg Time: " + sum4Add / depth4Add);
        if (depthAdd != 0)
            System.out.println("Avg depthAdd 5: " + (double) depth5Add / loop + "| Avg Time: " + sum5Add / depth5Add);
    }
    public static void bench_Array(){
        Random ra = new Random();

        for (int n = 1000; n <= 10000; n += 1000) { //Average time of one add operation per n
            HeapArray tester = new HeapArray(100000);
            double avgadd = 0;
            double avgrev = 0;

            int k = 0;
            int superloop = 100;
            int o = 0;
            while (o < superloop) {
                long t0 = System.nanoTime();
                while (k < n) {
                    tester.add(ra.nextInt(n * 10));
                    k++;
                }
                long t1 = System.nanoTime();
                long t2 = System.nanoTime();
                while (k > 0) {
                    Integer a = tester.remove();
                    k--;
                }
                long t3 = System.nanoTime();


                avgadd += (double) t1 - t0;

                avgrev += (double) t3 - t2;
                o++;
            }
            System.out.println(n + " stor, add: " + avgadd / (n * superloop) + " remove: " + avgrev / (n * superloop));
        }
    }
    public static void bench_ArrayV2(){
        int loop = 1000;
        Random ra = new Random();
        int time = 0;
        long t1 = 0;
        long t0 = 0;
        for (int n = 1000; n <= 10000; n += 1000) {
            HeapArray arr = new HeapArray(100000);
            for (int j = 0; j < 1000; j++) {
                 t0 = System.nanoTime();
                arr.add(ra.nextInt(10*n));
                 t1 = System.nanoTime();

                time += t1-t0;

            }
            System.out.println("N: " + n + "Time: " + time / (n * loop));


            }
        }
        public static void bench_ArrayV3(){
            int[] sizes = {2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
            int loops = 1000;
            Random rnd = new Random();
        for (int n : sizes) { //Benchmark task 2.4 (GenerateArray benchmark) //use lower N values
            double minValue = 0;
            HeapArray arr = new HeapArray(10000);
            for (int i = 0; i < loops; i++) {

                long t0 = System.nanoTime();
                arr.add(rnd.nextInt(n*10));
                long t1 = System.nanoTime();

                    minValue +=  (t1 - t0);
            }
            System.out.println("N: " + n + " Time: " + minValue/(loops));
        }
    }
    }
