 import java.util.*;
     import java.io.*;

     public class Main {
     public static void main(String[] args) throws IOException {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            //int k = sc.nextInt();
            MinHeap minHeap = new MinHeap(n);
            for (int i = 0; i < n; i++) {
                minHeap.insert(sc.nextInt());
            }

            // wr.write(minHeap.remove()+" ");
            System.out.println(minHeap.remove()+" ");

            // minHeap.deleteKey(k);
            minHeap.printHeap(sc);
           // minHeap.heapSort(wr);
            System.out.println();
            //wr.write("\n");
        }
        //wr.flush();
        //wr.close();

        }

    }
     class MinHeap
    {
    private int[]Heap;
    private int size;
    private int maxSize;
    private static final int FRONT = 1;
    MinHeap(int maxSize)
    {
        this.maxSize = maxSize;
        size=0;
        Heap = new int[this.maxSize+1];
        Heap[0] = Integer.MIN_VALUE;
    }
    private int parent(int pos) {
        return pos / 2;
    }
    private int leftChild(int pos)
    {
        return (2*pos);
    }
    private int rightChild(int pos)
    {
        return (2*pos)+1;
    }
    private boolean isLeaf(int pos)
    {
        if(pos>=(size/2) && pos<=size)
            return true;
        return false;
    }
    private void swap(int fpos, int spos)
    {
        int temp;
        temp = Heap[fpos];
        Heap[fpos]=Heap[spos];
        Heap[spos]=temp;
    }
    private void minHeapify(int pos)
    {
        int left = leftChild(pos);
        int right = rightChild(pos);
        int largest = pos;
        if(left<=size && Heap[left]<Heap[largest])
            largest=left;
        if(right<=size && Heap[right]<Heap[largest])
            largest = right;

        if(largest!=pos)
        {
            swap(pos, largest);
            minHeapify(largest);
        }
        /*if(!isLeaf(pos))
        {
            if(Heap[pos]>Heap[leftChild(pos)]
            || Heap[pos]>Heap[rightChild(pos)]){
                if(Heap[leftChild(pos)]<Heap[rightChild(pos)])
                {
                    swap(pos,leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else
                {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }*/
    }
    void insert(int element)
    {
        if(size>=maxSize)
            return;

        Heap[++size]=element;
        int i=size;
        while(Heap[i]<Heap[parent(i)])
        {
            swap(i,parent(i));
            i=parent(i);
        }
    }
    private void build_heap()
    {
        int j=(int)Math.floor(size/2.0);
        for(int i=j;i>=1;i--){
            minHeapify(i);
        }

    }
    public void heapSort(Writer wr) throws IOException {
        build_heap();
        int length=size;
        for(int i=size;i>=2;i--)
        {
            swap(1,i);
            size--;
            minHeapify(1);
        }
        size=length;
      // printHeap(wr);

    }
    public int remove()
    {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size];
        size=size-1;
        minHeapify(FRONT);
        return popped;
    }
    public void deleteKey(int i)
    {
        decreaseKey(i, Integer.MIN_VALUE);
        remove();
    }

    private void decreaseKey(int i, int new_val) {
        Heap[i]=new_val;
        while(i !=0 && Heap[parent(i)]>Heap[i])
        {
            swap(i,parent(i));
            i=parent(i);
        }
    }

    void printHeap(Scanner sc) throws IOException {
        for(int i=1;i<=size;i++)
        {
            //wr.write(Heap[i]+" ");
            System.out.print(Heap[i]+" ");
        }
    }

     }