package bellman_ford.header;

public class bellman_ford {
    float[] dist;
    int[] predecessor;
    boolean[] visi;

    public void bellman_path(int paths[][],int n,int m)
    {
        int temp = 0;
        dist = new float[n];
        predecessor = new int[n];

        for(float i:dist)
        { i = (float)1000000.0;}

        for(int i:predecessor)
        { i = -1;}

        dist[0] = 0;
        for(int i=0;i<n;i++)
        {
            for(int j =0 ;j<m;j++)
            {
                if(dist[paths[j][1]-1] > dist[paths[j][0]-1]+paths[j][2]) {
                    dist[paths[j][1]-1] = dist[paths[j][0]-1] + paths[j][2];
                    predecessor[paths[j][1]-1] = paths[j][0]-1;
                }
            }
        }
    }

    public float[] getdistances()
    {
        return dist;
    }

    public int[] getpre()
    {return predecessor;}
}
