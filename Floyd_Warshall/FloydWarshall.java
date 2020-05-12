package Floyd_Warshall;

import java.util.ArrayList;

public class FloydWarshall<T extends Number> {
    private ArrayList<ArrayList<Object>> map;

    public FloydWarshall(int N) {
        map = new ArrayList<ArrayList<Object>>(N);
        InitializeMap(N);
    }

    private void InitializeMap (int N) {
        for(int i =0;i<N;i++)
        {
            map.add(new ArrayList<Object>(N));
            for(int j=0;j<N;j++)
            {
                if(i==j) map.get(i).add(0);
                map.get(i).add(1000000);
            }
        }
    }
    public boolean setpath(int a,int b,int l) {
        try
        {
            map.get(a-1).set(b-1,l);
        }
        catch(IndexOutOfBoundsException e)
        {System.out.println("Invalid index: " + a + " " + b); return false;}
        finally {return true;}
    }
    public void Allpathsearch() {
        long N = map.size();
        for(int i=0;i<N;i++)
        {
            for(int j = 0;j<N;j++)
            {
                if(j == i) continue;
                for(int k = 0;k<N;k++)
                {
                    if( k == i) continue;
                    if(j==k) continue;
                    if(Integer.parseInt(map.get(j).get(k).toString()) < Integer.parseInt(map.get(j).get(i).toString()) + Integer.parseInt(map.get(i).get(k).toString())) continue;
                    else map.get(j).set(k,Integer.parseInt(map.get(j).get(i).toString()) + Integer.parseInt(map.get(i).get(k).toString()));
                }
            }
        }
    }
    public void showpathmatrix() {
        for(int i = 0;i<map.size();i++)
        {
            for(int j = 0;j<map.size();j++)
                System.out.print(map.get(i).get(j).toString() + " ");
            System.out.println("");
        }
    }
    public T getShortestPath(int a,int b){
        return (T)map.get(a-1).get(b-1);
    }
}
