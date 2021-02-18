import java.util.*;
import java.io.*;

class Heap{
  private int arr[];
  private int size;
  private int current_size;
  Heap(int size)
  {
    this.size=size;
    arr=new int[this.size+1];
    current_size=0;
  }
  void insert(long temp3)
  {
    if(current_size==size)
    return;
    arr[++current_size]=(int) temp3;
    int currnode=current_size,temp;
    int parent=currnode/2;
    while(currnode>1 && arr[currnode]>arr[parent])
    {
      temp=arr[currnode];
      arr[currnode]=arr[parent];
      arr[parent]=temp;
      currnode=parent;
      parent=currnode/2;
    }
  }
  void decreasekey(int pos,int newvalue)
  {
    if(arr[pos]>=newvalue)
    return;
    arr[pos]=newvalue;
    int currnode=pos,temp;
    int parent=currnode/2;
    while(currnode>1 && arr[currnode]>arr[parent])
    {
      temp=arr[currnode];
      arr[currnode]=arr[parent];
      arr[parent]=temp;
      currnode=parent;
      parent=currnode/2;
    }
  }
  long extractmax()
  {
    if(current_size==0)
    return Integer.MIN_VALUE;
    int ele=arr[1];
    arr[1]=arr[current_size];
    current_size--;
    heapify(1);
    return ele;
  }
  private void heapify(int pos)
  {
    int last=current_size/2;
    if(pos>last)
    return;
    int currnode=pos;
    int leftchild,rightchild,largest,temp;
    while(currnode<=last)
    {
      leftchild=2*currnode;
      rightchild=2*currnode+1;
      largest=currnode;
      if(leftchild<=current_size && arr[leftchild]>arr[largest])
      largest=leftchild;
      if(rightchild<=current_size && arr[rightchild]>arr[largest])
      largest=rightchild;
      if(largest==currnode)
      break;
      temp=arr[largest];
      arr[largest]=arr[currnode];
      arr[currnode]=temp;
      currnode=largest;
    }
  }
  void print()
  {
    for(int i=1;i<=current_size;i++)
    System.out.print(arr[i]+" ");
  }
  boolean isempty()
  {
    if(current_size==0)
    return true;
    else
    return false;
  }
}

public class Main {
  public static void main(String args[]) throws IOException {
    
    //write your code here
     Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    while(t-->0)
    {
      int n=sc.nextInt();
      Heap h=new Heap(n);
      for(int i=0;i<n;i++)
      {
        h.insert(sc.nextInt());
      }
      long temp1,temp2,temp3;
      for(int i=0;i<n-1;i++)
      {
        temp1=h.extractmax()%1000000007;
        temp2=h.extractmax()%1000000007;
        temp3=((temp1*3)%1000000007-(temp2*2)%1000000007)%1000000007;
        h.insert(temp3);
      }
      System.out.println(h.extractmax()%1000000007);
    }
  }
}