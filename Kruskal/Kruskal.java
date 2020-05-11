package Kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Kruskal {
    Integer[] dist;
    public Integer[] Kruskal_MST(ArrayList<Integer[]> paths, int N, int M)
    {
        Collections.sort(paths,(a1,a2)->{if(a1[2]>a2[2]) return 1;
                                    else if(a1[2]<a2[2]) return -1;
                                    else return 0;} );
        dist = new Integer[N];
        Arrays.fill(dist,0);
        Integer[] tags = new Integer[N];
        Arrays.fill(tags,0);
        tags[paths.get(0)[0]-1] = 1;int grp =1;
        for(int i = 0;i<M;i++)
        {
            if(tags[paths.get(i)[0]-1] == tags[paths.get(i)[1]-1] && tags[paths.get(i)[0]] != 0 ) continue;
            if(tags[paths.get(i)[0]-1] == tags[paths.get(i)[1]-1] && tags[paths.get(i)[0]] == 0 )
            {
                grp++;tags[paths.get(i)[0]-1] =grp;tags[paths.get(i)[1]-1] = grp;
                dist[paths.get(i)[1]-1] = dist[paths.get(i)[1]-1]+paths.get(i)[2];
            }
            if(tags[paths.get(i)[0]-1]!=0 )
            {
                if(tags[paths.get(i)[1]-1] ==0)
                {tags[paths.get(i)[1]-1] = tags[paths.get(i)[0]-1];
                dist[paths.get(i)[1]-1] = dist[paths.get(i)[0]-1]+paths.get(i)[2];}
                else
                {
                    Collections.replaceAll(tags,)
                }

            }
        }
    }
}
