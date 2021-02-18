import java.util.*;
  import java.io.*;
  
  public class Main {
    static int maximum_toys(int cost[],  
                        int N, int K) 
{ 
    int count = 0, sum = 0; 
  
    Arrays.sort(cost); 
    for (int i = 0; i < N; i++)  
    { 
          if (sum +cost[i] <= K)  
        { 
            sum = sum + cost[i]; 
            count++; 
        } 
    } 
    return count; 
} 
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cost[] = new int[n];
        for(int i = 0; i < n; i++){
          cost[i] = sc.nextInt();
        }
        System.out.println( maximum_toys(cost, n, k)); 
      }
      
    }
  }