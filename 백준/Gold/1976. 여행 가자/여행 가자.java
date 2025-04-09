import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] parent;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N];
        
        for(int i=0; i<N; i++) {
            parent[i] = i;
        }
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) union(i, j);
            }
        }

        int[] plan = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            plan[i] = Integer.parseInt(st.nextToken())-1;
            
        }
        
        boolean isPossible = true;
        int root = find(plan[0]);
        for(int i=1; i<M; i++) {
            if(find(plan[i]) != root) {
                isPossible = false;
                break;
            }
        }
        
        if(isPossible) System.out.println("YES");
        else System.out.println("NO");
    }

    private static int find(int target) {
        if(parent[target] != target) {
            parent[target] = find(parent[target]);
        }
        return parent[target];
    }

    private static void union(int start, int end) {
        int parentA = find(start);
        int parentB = find(end);
        if(parentA != parentB) {
            parent[parentB] = parentA;
        }
    }
}