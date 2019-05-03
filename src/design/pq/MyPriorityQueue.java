package design.pq;

/**
 * My priority queue implementation.
 * Binary heap version
 */
class MyPriorityQueue {
    private int[] pq;
    private int N;

    MyPriorityQueue(int capacity) {
        this.N = 0;
        this.pq = new int[capacity+1];
    }

    boolean isEmpty() {
        return N == 0;
    }

    private void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int index) {
        while (index > 1 && pq[index] > pq[index/2] ) {
            exch(index, index/2);
            index = index/2;
        }
    }

    private void sink(int index) {
        while (2*index <= N) {
            int leftChild = pq[2*index];
            int rightChild = pq[2*index + 1];
            int biggerChildIndex = leftChild < rightChild ? (2*index + 1) : 2*index;
            if (pq[index] > pq[biggerChildIndex]) break;
            else {
                exch(index, biggerChildIndex);
                index = biggerChildIndex;
            }
        }
    }

    void insert(int value) {
        this.N++;
        this.pq[N] = value;
        this.swim(N);
    }

    int delMax() {
        int max = pq[1];
        exch(1, N);
        pq[N] = 0;
        N--;
        sink(1);
        return max;
    }
}
