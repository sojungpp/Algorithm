// https://softeer.ai/practice/9657

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    map.put(i, map.getOrDefault(i, 0)+1);
                }
            }
        }

        for(int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j=start; j<=end; j++) {
                map.put(j, map.getOrDefault(j, 1)-1);
            }
        }

        List<Integer> key = new ArrayList<>(map.keySet());
        int answer = 0;
        for(Integer k : key) {
            if(map.get(k) > 0) answer += map.get(k);
        }
        System.out.println(answer);
    }
}
