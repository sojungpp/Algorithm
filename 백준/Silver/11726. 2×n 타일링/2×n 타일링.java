import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<dp.length; i++){
            // 점화식 도출
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }

        System.out.println(dp[n]);
    }
}