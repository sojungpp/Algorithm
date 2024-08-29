import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] budget = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int target = Integer.parseInt(st.nextToken());
            sum += target;
            budget[i] = target;
        }
        int standard = Integer.parseInt(br.readLine());
        Arrays.sort(budget);

        if(sum <= standard) {
            System.out.println(budget[N-1]);
            return;
        }

        int index = budget[N-1];
        sum = Integer.MAX_VALUE;
        while(sum > standard) {
            sum = 0;
            for(int i=0; i<N; i++) {
                if(budget[i] <= index) sum += budget[i];
                else sum += index;
            }
            index--;
        }

        System.out.println(index+1);
        
    }
}