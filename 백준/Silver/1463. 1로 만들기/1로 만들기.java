import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        /*
        X가 3으로 나누어 떨어지면, 3으로 나눈다.
        X가 2로 나누어 떨어지면, 2로 나눈다.
        1을 뺀다.
        */
        int[] dp = new int[1000001];

        for(int i=1; i<dp.length; i++){
            if(i == 1) continue;
            // 1을 빼는 경우
            dp[i] = dp[i-1]+1;
            // 2와 3으로 나누어지면, 각 1 빼는 것 vs 나누는 것 중 최소인 값 선택
            if(i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if(i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }
        System.out.println(dp[num]);
    }
}