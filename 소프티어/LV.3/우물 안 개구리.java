// https://softeer.ai/practice/6289

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] people = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] answer = new boolean[N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(people[num1] >= people[num2]) answer[num2] = true;
            if(people[num1] <= people[num2]) answer[num1] = true;
        }

        int cnt = 0;
        for(int i=1; i<=N; i++) {
            if(!answer[i]) cnt++;
        }
        System.out.println(cnt);
    }
}
