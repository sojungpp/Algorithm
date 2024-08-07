import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] cookie = new boolean[N][N];
        int[] head = new int[2];
        int[] answer = new int[5];

        for(int i=0; i<N; i++){
            String input = br.readLine();
            char[] inputs = input.toCharArray();
            for(int j=0; j<N; j++){
                if(inputs[j] == '*') {
                    cookie[i][j] = true;
                    if(head[1] == 0) {
                        head[0] = i;
                        head[1] = j;
                    }
                }
            }
        }

        // 심장
        System.out.println(head[0] + 2 + " " + (head[1]+1));
        // 왼쪽 팔
        int num = 0;
        for(int i=head[1]-1; i>=0; i--){
            if(cookie[head[0]+1][i]) num++;
            else break;
        }
        answer[0] = num;
        // 오른쪽 팔
        num = 0;
        for(int i=head[1]+1; i<N; i++){
            if(cookie[head[0]+1][i]) num++;
            else break;
        }
        answer[1] = num;
        // 허리
        num = 0;
        for(int i=head[0]+2; i<N; i++){
            if(cookie[i][head[1]]) num++;
            else break;
        }
        answer[2] = num;
        // 왼쪽 다리
        num = 0;
        for(int i=head[0]+2+answer[2]; i<N; i++){
            for(int j=0; j<head[1]; j++){
                if(cookie[i][j]) num++;
            }
        }
        answer[3] = num;
        // 오른쪽 다리
        num = 0;
        for(int i=head[0]+1+answer[2]+1; i<N; i++){
            for(int j=head[1]+1; j<N; j++){
                if(cookie[i][j]) num++;
            }
        }
        answer[4] = num;

        for(int i=0; i<5; i++){
            System.out.print(answer[i] + " ");
        }
        
    }
}