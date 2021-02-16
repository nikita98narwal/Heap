import java.util.*;
  import java.io.*;
  
  public class Main {
    static void heapify(int arr[], int n, int i) 
    { 
        int smallest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
        if (l < n && arr[l] < arr[smallest]) 
            smallest = l; 
        if (r < n && arr[r] < arr[smallest]) 
            smallest = r; 
        if (smallest != i) { 
            int temp = arr[i]; 
            arr[i] = arr[smallest]; 
            arr[smallest] = temp; 
            heapify(arr, n, smallest); 
        } 
    } 
    static void heapSort(int arr[], int n) 
    { 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
        for (int i = n - 1; i >= 0; i--) { 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            heapify(arr, i, 0); 
        } 
    } 
    static void printArray(int arr[], int n) 
    { 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
          arr[i] = sc.nextInt();
        }
        heapSort(arr, n); 
        printArray(arr, n);
      }
  
         
      
    }
  }