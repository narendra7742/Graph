import java.io.*;
import java.util.*;

public class ConnectedGraph{
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
			graph[i]=new ArrayList<Edge>();
		}
		int edges = sc.nextInt();
		for(int i=0;i<edges;i++){
			int src = sc.nextInt();
			int nbr = sc.nextInt();
			int wt = sc.nextInt();
			graph[src].add(new Edge(src,nbr,wt));
			graph[nbr].add(new Edge(nbr,src,wt));
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		boolean[] vis = new boolean[vtces];
		for(int i=0;i<vtces;i++){
			if(vis[i]==false){
				ArrayList<Integer> comp = new ArrayList<>();
				drawTree(graph,i,comp,vis);
				ans.add(comp);
			}
		}



		System.out.println(ans);
	}
	public static void drawTree(ArrayList<Edge>[] graph, int src,ArrayList<Integer> comp,boolean[] vis ){
		vis[src] = true;
		comp.add(src);
		for(Edge e: graph[src]){
			if(vis[e.nbr]==false){
				drawTree(graph,e.nbr,comp,vis);
			}
		}
	}
}