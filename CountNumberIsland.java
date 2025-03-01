import java.io.*;
import java.util.*;

public class CountNumberIsland{
	static class Edge{
		int src,nbr,wt;
		Edge(int src,int nbr,int wt){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// int vtces = sc.nextInt();
		// ArrayList<Edge>[] graph = new ArrayList[vtces];
		// for(int i=0;i<vtces;i++){
		// 	graph[i] = new ArrayList<Edge>();

		// }
		// int edges = sc.nextInt();
		// for(int i=0;i<edges;i++){
		// 	int v1 = sc.nextInt();
		// 	int v2 = sc.nextInt();
		// 	int wt = sc.nextInt();
		// 	graph[v1].add(new Edge(v1,v2,wt));
		// 	graph[v2].add(new Edge(v2,v1,wt));
		// }
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] g = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				g[i][j]=sc.nextInt();
			}
		}
		int c = 0;
		boolean[][] vis = new boolean[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(g[i][j]==0 && vis[i][j]==false){
					drawTree(g,i,j,vis);
					c++;
				}
			}
		}
		System.out.println(c);
	}
	public static void drawTree(int[][] g, int i, int j, boolean[][] vis){
		if(i<0 ||j<0 || i>=g.length || j>=g[0].length || g[i][j]==1 || vis[i][j]==true){
			return;
		}
		vis[i][j] = true;
		drawTree(g,i-1,j,vis);
		drawTree(g,i,j-1,vis);
		drawTree(g,i+1,j,vis);
		drawTree(g,i,j+1,vis);
	}
}