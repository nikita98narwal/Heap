import java.util.Scanner;

public class Main {
    public static class Heap {
        private int[] Heap;
        private int N;
        private int maxsize;
        private boolean reverse;

        public Heap(int maxsize) {
            this.maxsize = maxsize;
            this.Heap = new int[maxsize + 1];
            this.N = 0;
        }

        public Heap(int maxsize, boolean reverse) {
            this(maxsize);
            this.reverse = reverse;
        }


        private boolean comp(int a, int b) {
            if (reverse) {
                return Heap[a] > Heap[b];
            } else {
                return Heap[a] < Heap[b];
            }
        }

        public void insert(int val) {
            Heap[++N] = val;
            heapify_up(N);
        }

        public int size() {
            return N;
        }

        private void heapify_up(int n) {
            while (n > 1 && comp(n, n/2)) {
                swap(n, n/2);
                n = n/2;
            }
        }
        private void heapify_down(int n) {
            while (2 * n <= N) {
                int j = 2 * n;
                if (j < N && !comp(j, j+1)) j++;
                if (comp(n, j)) break;
                swap(n, j);
                n = j;
            }
        }



        public boolean isEmpty() {
            return N == 0;
        }

        public int top() {
            return Heap[1];
        }

        public void pop() {
            Heap[1] = Heap[N--];
            heapify_down(1);
        }

        private void swap(int a, int b) {
            int temp = Heap[a];
            Heap[a] = Heap[b];
            Heap[b] = temp;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int curans = 0;
                Heap minheap = new Heap(n);
                Heap maxheap = new Heap(n, true);

                for (int k = 0; k < n; k++) {
                    if (k >= i && k <= j) {
                        curans += a[k];
                        minheap.insert(a[k]);
                    } else {
                        maxheap.insert(a[k]);
                    }
                }

                ans = Math.max(ans, curans);

                for (int k = 1; k <= s; k++) {
                    if (maxheap.isEmpty() || minheap.isEmpty() || minheap.top() >= maxheap.top()) {
                        break;
                    }

                    curans -= minheap.top();
                    minheap.pop();
                    curans += maxheap.top();
                    maxheap.pop();

                    ans = Math.max(ans, curans);
                }
            }
        }

        System.out.println(ans);
    }

}
