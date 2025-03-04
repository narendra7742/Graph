import java.io.*;
import java.util.*;

public class Bfs{
	static class Edge{
	 	int src, nbr, wt;
	 	Edge(int src, int nbr){
	 		this.src = src;
	 		this.nbr = nbr;
	 		// this.wt = wt;
	 	}
	 }
	 static class Pair{
	 	int v;
	 	String psf;
	 	Pair(int v, String psf){
	 		this.v = v;
	 		this.psf = psf;
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
	 	for(int i=0;i<edge;i++){
	 		int v1 = sc.nextInt();
	 		int v2 = sc.nextInt();
	 		graph[v1].add(new Edge(v1,v2));
	 		graph[v2].add(new Edge(v2,v1));
	 	}
	 	int src = sc.nextInt();

	 	ArrayDeque<Pair> queue = new ArrayDeque<>();
	 	boolean[] vis = new boolean[vtces];
	 	queue.add(new Pair(src, src+""));
	 	while(queue.size()>0){
	 		Pair rem = queue.removeFirst();
	 		if(vis[rem.v]==true){
	 			continue;
	 		}
	 		vis[rem.v] = true;
	 		System.out.println(rem.v + "@"+ rem.psf);
	 		for(Edge e : graph[rem.v]){
	 			if(vis[e.nbr]==false){
	 				queue.add(new Pair(e.nbr, rem.psf+e.nbr));
	 			}
	 		}
	 	}
	 }
}