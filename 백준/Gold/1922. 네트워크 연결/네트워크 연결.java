import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int answer = 0;

        int[][] graph = new int[M][3];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=0; i<M; i++) {
            if(findParent(graph[i][0]) != findParent(graph[i][1])) {
                setParent(graph[i][0], graph[i][1]);
                answer += graph[i][2];
            } 
        }
        
        System.out.println(answer);
    }
    private static void setParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a>b) parent[a] = b;
        else parent[b] = a;
    }
    private static int findParent(int target) {
        if(parent[target] == target) return target;
        else return findParent(parent[target]);
    }
}