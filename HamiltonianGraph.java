import java.io.*;
import java.util.*;

public class HamiltonianGraph{
	static class Edge{
		int src, nbr, wt;
		Edge(int src, int nbr, int wt){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static void main(String[] args){
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
			int wt = sc.nextInt();
			graph[v1].add(new Edge(v1,v2,wt));
			graph[v2].add(new Edge(v2,v1,wt));
		}
		int src = sc.nextInt();
		HashSet<Integer> vis = new HashSet<>();
		hamiltonian(graph,src,vis,src+"",src);
	}

	public static void hamiltonian(ArrayList<Edge>[] graph, int src, HashSet<Integer> vis, String psf,int osrc){
		if(vis.size() == graph.length -1){
			System.out.print(psf);
			boolean closingEdgeFound = false;
			for(Edge e: graph[src]){
				if(e.nbr == osrc){
					closingEdgeFound = true;
				}
			}
			if(closingEdgeFound== true){
				System.out.println("*");
			}else{
				System.out.println(".");
			}
			return ;
		}

		vis.add(src);
		for(Edge e : graph[src]){
			if(vis.contains(e.nbr)== false){
				hamiltonian(graph, e.nbr, vis, psf+e.nbr,osrc);
			}
		}
		vis.remove(src);
	}
}