import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] nums = new long[101];
        nums[1] = 1;
        nums[2] = 1;
        nums[3] = 1;
        nums[4] = 2;
        nums[5] = 2;

        for(int i=6; i<=100; i++) {
            nums[i] = nums[i-1] + nums[i-5];
        }

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(nums[N]);
        }
        
    }
}