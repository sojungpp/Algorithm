import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n+1];
        int[] temp = new int[n+1];
        temp[0] = Integer.parseInt(br.readLine());
        if(n >= 2) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[0] = Integer.parseInt(st.nextToken()) + temp[0];
            nums[1] = Integer.parseInt(st.nextToken()) + temp[0];
            temp = Arrays.copyOf(nums, nums.length);
        }
        
        for(int i=2; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) {
                if(j == i) nums[j] = temp[j-1] + Integer.parseInt(st.nextToken());
                else if(j>0) nums[j] = Math.max(temp[j], temp[j-1]) + Integer.parseInt(st.nextToken());
                else nums[j] = temp[j] + Integer.parseInt(st.nextToken());
            }
            temp = Arrays.copyOf(nums, nums.length);
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            answer = Math.max(answer, temp[i]);  
        }
        System.out.println(answer);
    }
}