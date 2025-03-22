import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimMst {
    static class Edge {
        int src, nbr, wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int v, av, wt;

        Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vtces = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        int edges = sc.nextInt();
        for (int i = 0; i < edges; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int wt = sc.nextInt();
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[vtces];

        pq.add(new Pair(0, -1, 0));
        while (pq.size() > 0) {
            Pair rem = pq.remove();
            if (vis[rem.v] == true) {
                continue;
            }
            vis[rem.v] = true;
            if (rem.av != -1) {
                System.out.println("[" + rem.v + "_" + rem.av + "@" + rem.wt + "]");
            }
            for (Edge e : graph[rem.v]) {
                if (vis[e.nbr] == false) {
                    pq.add(new Pair(e.nbr, rem.v, e.wt));
                }
            }
        }
    }
}
