import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {
    static class Edge {
        int src, nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
            graph[v1].add(new Edge(v1, v2));
//            graph[v2].add(new Edge(v2,v1));
        }
        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();
        for (int v = 0; v < vtces; v++) {
            if (visited[v] == false) {
                topologicalSort(graph, v, visited, st);
            }
        }
        while (st.size() > 0) {
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }

    public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] vis, Stack<Integer> st) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (vis[e.nbr] == false) {
                topologicalSort(graph, e.nbr, vis, st);
            }
        }
        st.push(src);
    }
}
