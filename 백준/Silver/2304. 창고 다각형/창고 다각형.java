import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] blocks = new int[N][2];
        int y = 0;
        int x = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            blocks[i][0] = Integer.parseInt(st.nextToken());
            blocks[i][1] = Integer.parseInt(st.nextToken());
            if(y < blocks[i][1]) {
                y = blocks[i][1];
                x = blocks[i][0];
            }
        }
        Arrays.sort(blocks, Comparator.comparingInt(a -> a[0]));
        
        // 왼쪽에서 가장 큰 기둥까지
        int index = 0;
        int standardHeight = blocks[0][1];
        int answer = 0;
        for(int i=blocks[0][0]; i<x; i++){
            if(blocks[index][0] == i){
                if(blocks[index][1] > standardHeight) standardHeight = blocks[index][1];
                answer += standardHeight;
                index++;
            }
            else answer += standardHeight;
        }
        
        // 가장 큰 기둥
        answer += y;

        // 오른쪽에서 가장 큰 기둥까지
        standardHeight = blocks[N-1][1];
        index = N-1;
        for(int i=blocks[N-1][0]; i>=x+1; i--){
            if(blocks[index][0] == i){
                if(blocks[index][1] > standardHeight) standardHeight = blocks[index][1];
                answer += standardHeight;
                index--;
            }
            else answer += standardHeight;
        }
        
        System.out.println(answer);

    }
}