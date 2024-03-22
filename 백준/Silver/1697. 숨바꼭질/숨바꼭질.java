import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[] visited = new int[100000+1];

    private static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;

        while(!q.isEmpty()){
            int temp = q.poll();
            if(temp == m){
                System.out.println(visited[temp]);
                return;
            }
            
            for(int i=0; i<3; i++){
                int nextN;
                
                if(i==0) nextN = temp+1;
                else if(i==1) nextN = temp-1;
                else nextN = temp*2;

                if(nextN == m){
                    System.out.println(visited[temp]);
                    return;
                }

                if(nextN>=0 && nextN<100001 && visited[nextN]==0){
                    q.add(nextN);
                    visited[nextN] = visited[temp]+1;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        if(n==m) System.out.println(0);
        else bfs(n);
    }
}