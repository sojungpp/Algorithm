import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] house;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for(int i=0; i<N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int min = 1;
        int max = house[N-1] - house[0] + 1;

        while(min < max) {
            int mid = (min + max) / 2;

            if(isValid(mid) < C) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }

    private static int isValid(int dist) {
        int cnt = 1;
        int standard = house[0];

        for(int i=1; i<house.length; i++) {
            int now = house[i];
            if(now - standard >= dist) {
                cnt++;
                standard = now;
            }
        }
        return cnt;
    }
}