import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] num = new long[N];
        for(int i=0; i<N; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = N-1;
        long[] list = new long[2];
        list[0] = num[left];
        list[1] = num[N-1];

        while(left < right) {
            if(Math.abs(num[left]+num[right]) < Math.abs(list[0]+list[1])) {
                list[0] = num[left];
                list[1] = num[right];
            }

            if(Math.abs(num[left+1]+num[right]) < Math.abs(num[left]+num[right-1])) {
                left++;
            } else right--;
        }
        System.out.println(list[0] + " " + list[1]);
    }
}