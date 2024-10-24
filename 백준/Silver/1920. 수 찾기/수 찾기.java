import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        for(int i=0; i<N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            nums[i] = temp;
        }
        Arrays.sort(nums);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if(binarySearch(nums, target)) System.out.println(1);
            else System.out.println(0);
        }
    }

    private static boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            int mid = (left+right)/2;
            if(target == nums[mid]) return true;
            else if(target > nums[mid]) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}