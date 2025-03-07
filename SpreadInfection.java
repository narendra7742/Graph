import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class SpreadInfection {
    static class Edge{
        int src, nbr;
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    static class Pair{
        int v, time;
        Pair(int v, int time){
            this.v= v;
            this.time = time;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vtces = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i=0;i<vtces;i++){
            graph[i]=new ArrayList<Edge>();
        }
        int edge = sc.nextInt();
        for (int i = 0; i < edge; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }
        int scr = sc.nextInt();
        int t = sc.nextInt();

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(scr,1));
        int[] vis = new int[vtces];
        int count = 0;
        while(q.size()>0){
            Pair rem = q.removeFirst();
            if(vis[rem.v]>0){
                continue;
            }
            vis[rem.v]=rem.time;
            if(rem.time>t){
                break;
            }
            count++;
            for(Edge e : graph[rem.v]){
                if(vis[e.nbr]==0){
                    q.add(new Pair(e.nbr,rem.time+1));
                }
            }
        }
        System.out.println(count);



    }
}
