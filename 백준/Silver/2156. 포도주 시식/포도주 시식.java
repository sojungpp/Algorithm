import java.util.*;
import java.lang.*;
import java.io.*;

// 1. 선택한 포도주 모두 마시고, 다시 원래 위치
// 2. 연속 3잔 모두 마시기 불가
// 최대 마실 수 있는 포도주 양
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] grape = new int[n];
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            grape[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = grape[0];
        if(n>=2) dp[1] = Math.max(dp[0], dp[0]+grape[1]);
        if(n>=3) dp[2] = Math.max(Math.max(dp[1], dp[0]+grape[2]), grape[1]+grape[2]);
        for(int i=3; i<n; i++) {
            // 건너뛰기 / 이전 + 마시기 / 이전전 + 연속마시기
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-2]+grape[i]), dp[i-3]+grape[i-1]+grape[i]);
        }

        System.out.println(dp[n-1]);        
    }
}