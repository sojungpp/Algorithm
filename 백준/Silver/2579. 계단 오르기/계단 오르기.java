import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N+1];
        for(int i=1; i<=N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] answer = new int[N+1];
        if(N <= 2) {
            System.out.println(stairs[N] + stairs[N-1]);
            return;
        }
        answer[1] = stairs[1];
        answer[2] = stairs[1] + stairs[2];
        answer[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
        
        for(int i=4; i<=N; i++) {
            answer[i] = Math.max(answer[i-3] + stairs[i-1], answer[i-2]) + stairs[i];
        }

        System.out.println(answer[N]);
    }
}