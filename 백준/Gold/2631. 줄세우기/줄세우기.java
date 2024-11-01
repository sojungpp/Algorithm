import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        for(int i=0; i<N; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        // 최장 증가 부분 수열
        for(int i=0; i<N; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(people[j] < people[i] && dp[j]+1>dp[i]) dp[i] = dp[j]+1;
            }
        }

        Arrays.sort(dp);
        System.out.println(N - dp[N-1]);
    }
}