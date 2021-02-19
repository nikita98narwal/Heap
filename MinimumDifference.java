import java.util.*;
  import java.io.*;
  
  class Pair 
{ 
    Integer key; 
    Integer value; 
      
    public Pair(Integer key, Integer value) 
    { 
        this.key = key; 
        this.value = value; 
    } 
    public Integer getKey() 
    { 
        return key; 
    } 
    public void setKey(Integer key) 
    { 
        this.key = key; 
    } 
    public Integer getValue() 
    { 
        return value; 
    } 
    public void setValue(Integer value) 
    { 
        this.value = value; 
    } 
} 
  public class Main {
    public static void printKclosest(int[] arr, int n, 
                                 int x, int k)  
{ 
    PriorityQueue<Pair> pq = new PriorityQueue<>( 
                             new Comparator<Pair>() 
    { 
        public int compare(Pair p1, Pair p2) 
        { 
            return p2.getValue().compareTo( 
                   p1.getValue()); 
        } 
    }); 
    for(int i = 0; i < k; i++)  
    { 
        pq.offer(new Pair(arr[i],  
                 Math.abs(arr[i] - x))); 
    } 
    for(int i = k; i < n; i++) 
    { 
        int diff = Math.abs(arr[i] - x); 
        if(diff > pq.peek().getValue()) continue; 
        pq.poll(); 
        pq.offer(new Pair(arr[i], diff)); 
    } 
    while(!pq.isEmpty()) 
    { 
        System.out.print(pq.poll().getKey() + " "); 
    } 
} 
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
        int n = sc.nextInt();
        int x = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
          arr[i] = sc.nextInt();
        }
        printKclosest(arr, n, x, k);
        System.out.println();
      }
    }
  }
