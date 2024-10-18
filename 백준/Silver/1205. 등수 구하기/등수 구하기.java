import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  
        int newScore = Integer.parseInt(st.nextToken());  
        int P = Integer.parseInt(st.nextToken());  

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        if (N == P && newScore <= list[N - 1]) {
            System.out.println(-1);
            return;
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (newScore < list[i]) {
                rank++;
            } else {
                break;
            }
        }

 
        if (rank > P) {
            rank = P + 1;
        }

        System.out.println(rank);
    }
}
