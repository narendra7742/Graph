import java.io.*;
import java.util.*;

public class IsGraphCycleBfs{
	static class Edge{
		int src,nbr,wt;
		Edge(int src, int nbr, int wt){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	static class Pair{
		int src;
		String psf;
		Pair(int src, String psf){
			this.src = src;
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
			int wt = sc.nextInt();
			graph[v1].add(new Edge(v1,v2,wt));
			graph[v2].add(new Edge(v2,v1,wt));
		}
		boolean[] vis = new boolean[vtces];
		for(int i=0;i<vtces;i++){
			if(vis[i]==false){
				boolean cycle = isCyclic(graph,i,vis);
				if(cycle){
					System.out.println(true);
					return;
				}
			}
		}
		System.out.println(false);

	}
	public static boolean isCyclic(ArrayList<Edge>[] g, int src, boolean[] vis){
		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(src,src+""));
		while(q.size() >0){
			Pair rem = q.removeFirst();
			if(vis[rem.src]==true){
				return true;
			}
			vis[rem.src]=true;
			for(Edge e: g[rem.src]){
				if(vis[e.nbr]==false){
					q.add(new Pair(e.nbr, rem.psf + e.nbr));
				}
			}
			
		}
		return false;
	}
}