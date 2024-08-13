import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] name = new String[N];
        int[] exp = new int[N];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            name[i] = st.nextToken();
            exp[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            int target = Integer.parseInt(br.readLine());
            int left = 0;
            int right = N;
            int index = 0;

            while(left <= right) {
                int mid = (left + right) / 2;
                if(target <= exp[mid]) {
                    right = mid - 1;
                    index = mid;
                } else {
                    left = mid + 1;
                }
            }
            sb.append(name[index]).append("\n");
        }
        System.out.println(sb);
    }
}