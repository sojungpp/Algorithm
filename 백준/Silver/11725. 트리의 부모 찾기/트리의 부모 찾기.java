import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N;
    static int[] parents;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    private static void dfs(int node){
        visited[node] = true;

        for(int i: arr[node]){
            if(!visited[i]){
                dfs(i);
                parents[i] = node;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        parents = new int[N+1];
        visited = new boolean[N+1];
        
        arr = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
        
         for(int i=0; i<N-1; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

             arr[start].add(end);
             arr[end].add(start);
        }

        dfs(1);

        for(int i=2; i<=N; i++){
            System.out.println(parents[i]);
        }
    }
}