package merger.headers;

import merger.headers.interaces.*;
//import org.jetbrains.annotations.NotNull;

public class v_array implements array_functions
{
    int[] arr;
    int N;int p;
    
    public v_array(int n)
    {
        N=n;
        arr = new int[n];p = -1;
    }
    public v_array(int [] y)
    {
        if(y.length>max_capacity)
         {System.out.println("Container Overflow");
           arr = new int[0];p =-1;N=0;}
        else
        {arr = y;
        N=arr.length;
        p = N-1;}
    }
    
    public int at(int pos)
    {
        return arr[pos];
    }
    
    public int[] split(int start,int end)
    {
        int[] temp = new int[end-start+1];int j = start;
        for(int i=0;i<temp.length;i++) {temp[i] = arr[j];j++;}
        return temp;
    }
    
    public void push_back(int ele)
    {
        try
         {arr[++p] = ele;}
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Vector full");
        }
    }
    
    public void erase(int pos)
    {
        try
        {for(int i=pos;i<N-1;i++)
          arr[i] = arr[i+1];
        }
        catch(ArrayIndexOutOfBoundsException e)
         {System.out.println("Vector Empty");}
        finally
        {p--;}
    }
    
    public boolean empty()
    {
        if(p==-1)
          return true;
        else 
         return false;
    }
    
    public int[] toarray()
    {
        return arr;
    }
}

