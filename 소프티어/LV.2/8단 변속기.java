// https://softeer.ai/practice/6283

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] speed = new int[8];
        
        for(int i=0; i<8; i++) {
            speed[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<7; i++) {
            if(speed[i] - speed[i-1] < 0 && speed[i+1] - speed[i] < 0) continue;
            if(speed[i] - speed[i-1] > 0 && speed[i+1] - speed[i] > 0) continue;
            System.out.println("mixed");
            return;
        }

        if(speed[1] - speed[0] < 0) System.out.println("descending");
        else System.out.println("ascending");
    }
}
