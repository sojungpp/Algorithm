import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] state = new int[W];
        for(int i=0; i<W; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i=1; i<=W-1; i++) {
            int leftStandard = 0;
            int rightStandard = 0;
            for(int j=0; j<i; j++) {
                leftStandard = Math.max(leftStandard, state[j]);
            }
             for(int j=i+1; j<W; j++) {
                rightStandard = Math.max(rightStandard, state[j]);
            }

            if(state[i] < leftStandard && state[i] < rightStandard) {
                answer += Math.min(leftStandard, rightStandard) - state[i]; 
            }
        }

        System.out.println(answer);
    }
}