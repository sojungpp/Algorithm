import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[N+1];
        for(int i=1; i<=N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                answer[i] = Math.max(answer[i], answer[i-j] + cards[j]);
            }
        }

        System.out.println(answer[N]);
    }
}