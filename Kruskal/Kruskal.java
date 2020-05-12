package Kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Kruskal{
    Integer[] dist;
    public Integer[] Kruskal_MST(ArrayList<Integer[]> paths, int N, int M)
    {
        Collections.sort(paths,(a1,a2)->{if(a1[2]>a2[2]) return 1;
                                    else if(a1[2]<a2[2]) return -1;
                                    else return 0;} );
        dist = new Integer[N];
        Arrays.fill(dist,0);
        ArrayList<Integer> tags = new ArrayList<Integer>(N);
       for(int i=0;i<N;i++) tags.add(0);
        tags.set(paths.get(0)[0]-1,1);int grp =1;
        for(int i=0;i<M;i++)
        {
            if(tags.get(paths.get(i)[0]-1) == tags.get(paths.get(i)[1]-1) && tags.get(paths.get(i)[0]-1) != 0 )
                continue;
            else if(tags.get(paths.get(i)[0]-1) == tags.get(paths.get(i)[1]-1) && tags.get(paths.get(i)[0]-1) == 0 )
            {
                grp++;tags.set(paths.get(i)[0]-1,grp);tags.set(paths.get(i)[1]-1,grp);
                dist[paths.get(i)[1]-1] = dist[paths.get(i)[1]-1]+paths.get(i)[2];
            }
            else if(tags.get(paths.get(i)[0]-1)!=0 ) {
                if (tags.get(paths.get(i)[1] - 1) == 0) {
                    tags.set(paths.get(i)[1] - 1, tags.get(paths.get(i)[0] - 1));
                    dist[paths.get(i)[1] - 1] = dist[paths.get(i)[0] - 1] + paths.get(i)[2];
                } else {
                    Collections.replaceAll(tags, tags.get(paths.get(i)[1] - 1), tags.get(paths.get(i)[0] - 1));
                }
            }
            else if(tags.get(paths.get(i)[1]-1)!=0 ) {
                if (tags.get(paths.get(i)[0] - 1) == 0) {
                    tags.set(paths.get(i)[0] - 1, tags.get(paths.get(i)[1] - 1));
                    dist[paths.get(i)[0] - 1] = dist[paths.get(i)[1] - 1] + paths.get(i)[2];
                } else {
                    Collections.replaceAll(tags, tags.get(paths.get(i)[0] - 1), tags.get(paths.get(i)[1] - 1));
                }
            }
        }
        return dist;
    }
}
