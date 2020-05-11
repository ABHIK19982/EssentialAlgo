
package merger;

import merger.headers.v_array;
import java.util.Scanner;

public class merge_sort
{
    public static int[] m_sort(int[] h ,int n)
    {
        v_array arr = new v_array(h);
        v_array merged = new v_array(n);
        if(n==1)
        {
            merged.push_back(arr.at(0));
            //if(!asArray)
               return merged.toarray();
        }
        
        int n_l = (n/2)-1;
        int n_u =n-n_l-1;
        int[] l = arr.split(0,n_l);
        int[] u = arr.split(n_l+1,n-1);
        
        l = m_sort(l,n_l+1);
        u = m_sort(u,n_u);
        v_array lower = new v_array(l);
        v_array upper = new v_array(u);
        
        while(!lower.empty() && !upper.empty())
        {
            if(lower.at(0) < upper.at(0)){merged.push_back(lower.at(0));lower.erase(0);}
            else {merged.push_back(upper.at(0));upper.erase(0);}
        }
        while(!lower.empty())
        {merged.push_back(lower.at(0));lower.erase(0);}
        while(!upper.empty())
        {merged.push_back(upper.at(0));upper.erase(0);}
        
        //if(asArray)
        return (merged.toarray());
        //else return merged;
    }
    
    public static void main(String args[])
    {
        int N = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = new int[N];
        for(int i =0 ;i<N;i++)
        {
            arr[i] = sc.nextInt();
        }
        
        int[] s_arr = m_sort(arr,N);
        
        for(int i=0;i<N;i++)
            System.out.println(s_arr[i]);
    }
}
