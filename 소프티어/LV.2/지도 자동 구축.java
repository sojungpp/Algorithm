// https://softeer.ai/practice/6280

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dots = new int[16];
        int standard = 2;
        dots[0] = 2;
        for(int i=1; i<=15; i++) {
            dots[i] = dots[i-1] + (int) Math.pow(2, i-1);
        }

        System.out.println(dots[N] * dots[N]);
    }
}
