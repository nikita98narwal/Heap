 import java.util.*;
 import java.io.*;

 public class Main {

 static int size = 0;
 public int findKthLargest(int[] nums, int k) {
 this.size = nums.length;
 int ans = 0;
 int last = (this.size-1)/2;
 for(int i=last;i>=0;i--)
      downheapify(nums,i);
 for(int i=1;i<=k;i++)
      ans = remove(nums);
 return ans;
 }
 public static void main(String args[]) throws IOException {

 Scanner sc = new Scanner(System.in);
 int t = sc.nextInt();
 while(t-->0)
 {
      Main m = new Main();
      int n= sc.nextInt();
      int k = sc.nextInt();
      int []a = new int[n];
      for(int i=0;i<n;i++)
      {a[i]= sc.nextInt();}
      System.out.println(m.findKthLargest(a,k));
 }


 }


 public void swap(int []nums,int i, int j) {
      int temp = nums[i];
 nums[i] = nums[j];
 nums[j] = temp;
 }

 public int remove(int []nums) {
      swap(nums,0,this.size - 1);
      int temp = nums[this.size - 1];
 this.size--;
      downheapify(nums,0);
      return temp;
 }

 public void downheapify(int []nums,int pi) {

      int mini = pi;
      int li = 2 * pi + 1;
      int ri = 2 * pi + 2;

      if (li < this.size && nums[li] > nums[mini])
           mini = li;

      if (ri < this.size && nums[ri] > nums[mini])
           mini = ri;

      if (mini != pi) {
           swap(nums,mini, pi);
           downheapify(nums,mini);
      }
   }

 }
