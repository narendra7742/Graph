import java.io.*;
import java.util.*;

public class AllPathGraph{
	static class Edge{
		int src, nbr, wt;

		Edge(int src, int nbr, int wt){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int vtces = sc.nextInt();
		ArrayList<Edge>[] Graph = new ArrayList[vtces];
		for(int i=0;i<vtces;i++){
			Graph[i] = new ArrayList<>();
		}
		int edges = sc.nextInt();
		for(int i=0;i<edges;i++){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int wt = sc.nextInt();
			Graph[v1].add(new Edge(v1,v2,wt));
			Graph[v2].add(new Edge(v2,v1,wt));
		}
		int src = sc.nextInt();
		int desc = sc.nextInt();

		boolean[] visited = new boolean[vtces];
		printAllPaths(Graph,src,desc,visited,src+"" );
	}

	public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String pts){
		if(src == dest){
			System.out.println(pts);
			return;
		}
		visited[src] = true;
		for(Edge edge : graph[src]){
			if(visited[edge.nbr]==false){
				printAllPaths(graph, edge.nbr, dest, visited, pts+edge.nbr);
			}
		}
		visited[src] = false;
	}
}