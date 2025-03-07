import java.io.*;
import java.util.*;

public class IsBipartiteBfs {
    static class Edge{
        int src, nbr;
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    static class Pair{
        int v;
        String psf;
        int level;
        Pair(int v, String psf, int level){
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vtces = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i=0;i<vtces;i++){
            graph[i] = new ArrayList<Edge>();
        }
        int edge = sc.nextInt();
        for(int i=0;i<edge;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }

        int[] visited = new int[vtces];
        Arrays.fill(visited,-1);
        for(int i=0;i<vtces;i++){
            if(visited[i]==-1){
                boolean isCompBipartite = checkGraphBipartite(graph,i,visited);
                if(isCompBipartite ==false){
                    System.out.println("False");
                    return;
                }
            }
        }
        System.out.println("True");

    }

    public static boolean checkGraphBipartite(ArrayList<Edge>[] graph, int v, int[] vis){
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(v, v+"", 0));
        while(q.size()>0){
            Pair rem = q.removeFirst();
            if(vis[rem.v] != -1){
                if(rem.level != vis[rem.v]){
                    return false;
                }
            }else{
                vis[rem.v]= rem.level;
            }
            for(Edge e: graph[rem.v]){
                if(vis[e.nbr]==-1){
                    q.add(new Pair(e.nbr, rem.psf+e.nbr,rem.level+1));
                }
            }
        }
        return true;
    }
}