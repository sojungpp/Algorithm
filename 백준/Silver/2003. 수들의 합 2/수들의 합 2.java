import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 0;
        
        while(left < N) {

            while(sum < M && right < N) {
                sum += nums[right];
                right++;
            }

            if(sum == M) answer++;

            sum -= nums[left];
            left++;
        }
        
        System.out.println(answer);
        
    }
}