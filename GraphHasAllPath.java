import java.io.*;
import java.util.*;

public class GraphHasAllPath{
	static class Edge{
		int src, nbr, wt;
		Edge(int src, int nbr, int wt){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	static class Pair implements Comparable<Pair> {
		int wsf;
		String psf;
		Pair(int wsf, String psf){
			this.wsf = wsf;
			this.psf = psf;
		}
		public int compareTo(Pair o){
		  return	this.wsf = o.wsf;
		}
	}
	static String sPath;
	static Integer sPathWt = Integer.MAX_VALUE;
	static String lPath;
	static Integer lPathWt = Integer.MIN_VALUE;
	static String cPath;
	static Integer cPathWt = Integer.MAX_VALUE;
	static String fPath;
	static Integer fPathWT = Integer.MIN_VALUE;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();


	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int vtces = sc.nextInt();
		ArrayList<Edge>[] Graph = new ArrayList[vtces];
		for(int i=0;i<vtces;i++){
			Graph[i]= new ArrayList<>();
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
		int dest = sc.nextInt();
		int wait = sc.nextInt();
		int k = sc.nextInt();

		boolean[] visited = new boolean[vtces];
		multiSolver(Graph, src, dest, visited, wait, k, src+"", 0);

		System.out.println("Smallest Path = "+sPath+" @"+sPathWt); 
		System.out.println("Largest Path = "+lPath+" @"+lPathWt);


	}
	public static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int c, int k, String psf, int wsf){
		
		if(src == dest){
			if(wsf < sPathWt){
				sPathWt = wsf;
				sPath = psf;
			}
			if(wsf > lPathWt){
				lPathWt = wsf;
				lPath = psf;
			}
			if(wsf >c && wsf <cPathWt){
				cPathWt = wsf;
				cPath = psf;
			}
			if(wsf < c && wsf > fPathWT){
				fPathWT = wsf;
				fPath = psf;
			}
			if(pq.size() <k){
				pq.add(new Pair(wsf, psf));
			}else{
				if(wsf > pq.peek().wsf){
					pq.remove();
					pq.add(new Pair(wsf, psf));
				}
			}

			return;
		}

		visited[src] = true;
		for(Edge e :graph[src] ){
			if(visited[e.nbr] == false){
				multiSolver(graph, e.nbr, dest, visited, c, k, psf+e.nbr, wsf+e.wt);
			}
		}
		visited[src] = false;
	}
}