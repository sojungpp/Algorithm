import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] students = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 오름차순 정렬
        for(int i=0; i<N; i++) {
            Arrays.sort(students[i]);
        }
        
        int[] index = new int[N];
        int result = Integer.MAX_VALUE;
        int minArrayIndex = 0;
        while(true) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            // max와 min값 찾기
            for(int i=0; i<N; i++) {
                if(students[i][index[i]] > max) max = students[i][index[i]];
                if(students[i][index[i]] < min){
                    min = students[i][index[i]];
                    // 최소값인 배열 인덱스
                    minArrayIndex = i;
                }
            }
            result = Math.min(result, max-min);
            // 최소값인 배열 인덱스 갱신
            index[minArrayIndex]++;
            // 해당 배열 끝까지 탐색했으면 break
            if(index[minArrayIndex] == M) break;
        }
        System.out.println(result);
    }
}