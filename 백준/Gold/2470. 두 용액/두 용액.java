import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = N-1;
        int[] answer = new int[2];

        while(left<right) {
            int temp = Math.abs(nums[left] + nums[right]);
            if(temp < min) {
                min = temp;
                answer[0] = nums[left];
                answer[1] = nums[right];
            }
            if(nums[left]+nums[right] < 0) {
                left++;
            } else {
                right--;
            }
        }
        

        Arrays.sort(answer);        
        System.out.println(answer[0] + " " + answer[1]);
    }
}