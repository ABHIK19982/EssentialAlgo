package djikstra;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import djikstra.headers.*;


public class djikstra {
    static int[] dist;
    static int[][] m;
    public static Sor_array s;

    static void ini(int dist[]) {
        for (int i = 0; i < dist.length; i++)
            dist[i] = 1000000000;
    }

    static void ini(boolean dist[]) {
        for (int i = 0; i < dist.length; i++)
            dist[i] = false;
    }

    static void djikstra_path(int n) {
        s = new Sor_array(n);
        dist = new int[n];
        boolean visited[] = new boolean[n];
        s.insert_element(0);
        ini(dist);
        ini(visited);
        dist[0] = 0;
        while (!s.empty()) {
            int temp = s.get_min();
            s.del_min();
            if (visited[temp] == true) continue;
            int next = 0;
            visited[temp] = true;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && m[temp][i] != 0) {
                    s.insert_element(i);
                    if (dist[temp] + m[temp][i] < dist[i])
                        dist[i] = dist[temp] + m[temp][i];
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        m = new int[N][N];

        for (int i = 0; i < M; i++) {
            int a, b, d;
            System.out.println("From: ");
            a = Integer.parseInt(br.readLine());
            System.out.println("To: ");
            b = Integer.parseInt(br.readLine());
            System.out.println("weight: ");
            d = Integer.parseInt(br.readLine());

            m[a - 1][b - 1] = d;
        }

        djikstra_path(N);

        for(int i=0;i<dist.length;i++)
            System.out.print(dist[i]);
    }
}