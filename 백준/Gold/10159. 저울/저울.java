import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[N+1][N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
        }

        // 플로이드-워셜
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                for(int k=1; k<N+1; k++) {
                    if(arr[j][i] && arr[i][k]) {
                        arr[j][k] = true;
                    }
                }
            }
        }

        for(int i=1; i<N+1; i++) {
            int answer = 0;
            for(int j=1; j<N+1; j++) {
                if(i == j) continue;
                if(!arr[i][j] && !arr[j][i]) answer++;
            }
            System.out.println(answer);
        }
        
    }
}