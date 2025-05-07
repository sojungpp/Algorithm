import java.util.*;
import java.lang.*;
import java.io.*;

// 위쪽으로 이동 불가, 중복방문 불가
// (1, 1) -> (N, M)
// 탐사한 지역의 가치 합 최대
class Main {

    static int[][] land;
    static int[][] answer;
    static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        land = new int[N][M];
        answer = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 줄
        answer[0][0] = land[0][0];
        for(int i=1; i<M; i++) {
            answer[0][i] = answer[0][i-1] + land[0][i];
        }

        // 한 줄씩 처리
        int[][] temp = new int[2][M];
        for(int i=1; i<N; i++) {
            // 왼쪽, 위쪽
            temp[0][0] = answer[i-1][0] + land[i][0];
            for(int j=1; j<M; j++){
                temp[0][j] = Math.max(temp[0][j-1], answer[i-1][j]) + land[i][j];
            }

            // 오른쪽, 위쪽
            temp[1][M-1] = answer[i-1][M-1] + land[i][M-1];
            for(int j=M-2; j>=0; j--){
                temp[1][j] = Math.max(temp[1][j+1], answer[i-1][j]) + land[i][j];
            }

            // 최대값 갱신
            for(int j=0; j<M; j++){
                answer[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }
        System.out.println(answer[N-1][M-1]);       
    }

}