// https://softeer.ai/practice/6291

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lecture = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lecture[i][0] = Integer.parseInt(st.nextToken());
            lecture[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lecture, (a, b) -> {
            return a[1] - b[1];
        });

        int answer = 1;
        int standard = lecture[0][1];

        for(int i=1; i<N; i++) {
            if(lecture[i][0] >= standard) {
                standard = lecture[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
