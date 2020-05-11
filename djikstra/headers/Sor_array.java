package djikstra.headers;
public class Sor_array
{
    protected int[] arr;
    protected int N;
    protected int p;
    protected int min ;

    public Sor_array() {
        N=1;
        arr = new int[N];
        p = -1;
        min = 10000000;
    }

    public Sor_array(int n)
    {
        this.N = n;
        this.arr = new int[n];
        p = -1;
    }
    
    public int get_min()
    {
        min = 0;
        int h = 10000000;
        if(p == -1)
         return -1;
        for(int i = 0;i<p;i++)
        {
            if(arr[i]<h)
              {min = i;h = arr[i];}
        }
        return arr[min];
    }
    
    public void del_min()
    {
        if(p == -1)
          System.out.println("Array Empty");
        else
         {
             for(int j = min;j<p-1;j++)
             arr[j] = arr[j+1];
             p--;
         }
    }
    
    public void insert_element(int a)
    {
        if(p == N-1)
         System.out.println("Container full");
        else
         {p++;arr[p] = a;}
    }
    
    public boolean empty()
    {
        if(p == -1) return true;
        else return false;
    }
}