// https://softeer.ai/practice/7628

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] stove = new int[N];
        for(int i=0; i<N; i++) {
            stove[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for(int i=2; i<=100; i++) {
            int temp = 0;
            if(isPrime(i) || i==2) {
                for(int j=0; j<N; j++) {
                    if(stove[j] % i == 0) temp++;
                }
            }
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }

    private static boolean isPrime(int num) {
        for(int i=2; i<num; i++) {
            if(num % i == 0) return false; 
        }
        return true;
    }
}
