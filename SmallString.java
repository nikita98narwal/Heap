import java.util.*;
  import java.io.*;

  public class Main {
    static int size;
    static int count;
    static String s="";
    public static void main(String args[]) throws IOException {

      Scanner sc = new Scanner(System.in);
      int t=sc.nextInt();
      for(int j=0;j<t;j++)
      {
        size=0;
        s="";
        String str=sc.next();
        char heap[]=new char[str.length()+1];
        int len=str.length();
        int k= sc.nextInt();
        for(int i=0;i<k;i++)
        {
          insert(heap,str.charAt(i));
        }

        delete(heap);
        for(int i=k;i<len;i++)
        {
          insert(heap,str.charAt(i));
          delete(heap);
        }
        for(int i=0;i<k-1;i++)
        {
          delete(heap);
        }
        System.out.println(s);
      }
    }
    static void insert(char heap[],char data)
    {
      heap[++size]=data;
      int temp=size;
      while(temp>1&&heap[temp/2]>heap[temp])
      {
        swap(heap,temp,temp/2);
        temp=temp/2;
      }

    }
    static void minheapify(char heap[],int i)
    {
      if(size==0)
      return;
      if(i>size/2&&i<=size)
      return;
      int left=2*i;
      int right=2*i+1;
      if(right<=size)
      {
        if(heap[left]>=heap[i]&&heap[right]>=heap[i])
        return;
      }
      else
      {
        if(heap[left]>=heap[i])
        return;
      }
      int smallest;
      if(left<=size&&heap[left]<heap[i])
      {
        smallest=left;
      }
      else
      smallest=i;
      if(right<=size&&heap[right]<heap[smallest])
      smallest=right;
      if(smallest!=i)
      {
        swap(heap,smallest,i);
      }
      minheapify(heap,smallest);
    }
    static void swap(char heap[],int i,int j)
    {
      char temp=heap[i];
      heap[i]=heap[j];
      heap[j]=temp;
    }
    static void delete(char heap[])
    {
      s=s+ heap[1];
      heap[1]=heap[size];
      size=size-1;
      minheapify(heap,1);
    }
  }