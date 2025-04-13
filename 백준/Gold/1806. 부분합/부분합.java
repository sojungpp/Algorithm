import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0; 
        int answer = Integer.MAX_VALUE;
        int temp = 0;
        while(true) {
            if(temp >= S) {
                answer = Math.min(answer, right-left);
                temp-=arr[left];
                left++;
            } else if (right == N) {
                break;
            } else {
                temp+=arr[right];
                right++;
            }
        }

        if(answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}