import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraBfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vtces = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        int edge = sc.nextInt();
        for (int i = 0; i < edge; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int wt = sc.nextInt();
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        int src = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, src + "", 0));
        boolean[] vis = new boolean[vtces];

        while (pq.size() > 0) {
            Pair rem = pq.remove();
            if (vis[rem.v] == true) {
                continue;
                
            }
            vis[rem.v] = true;
            System.out.println(rem.v + " via " + rem.psf + " @" + rem.wt);
            for (Edge e : graph[rem.v]) {
                if (vis[e.nbr] == false) {
                    pq.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wt + e.wt));
                }
            }
        }

    }

    static class Edge {
        int src, nbr, wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int v;
        String psf;
        int wt;

        Pair(int v, String psf, int wt) {
            this.v = v;
            this.psf = psf;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }
}
