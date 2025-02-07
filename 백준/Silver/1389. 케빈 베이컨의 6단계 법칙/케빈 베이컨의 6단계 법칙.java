import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] friend;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        
        friend = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                friend[i][j] = 99999;
                if(i==j) friend[i][j] = 0;
            }
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a][b] = 1;
            friend[b][a] = 1;
        }

        for(int k=1; k<=N; k++) { 
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					friend[i][j] = Math.min(friend[i][j], friend[i][k]+friend[k][j]);
				}
			}
		}
        
        int cnt = 99999;
        int answer = 0;
        for(int i=1; i<=N; i++) {
            int temp = 0;
            for(int j=1; j<=N; j++) {
                temp += friend[i][j];
            }
            if(cnt>temp) {
                answer = i;
                cnt = temp;
            }
        }
        System.out.println(answer);
    }
}