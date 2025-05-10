import java.util.*;
import java.lang.*;
import java.io.*;

// 회의 겹치치 않게 사용 가능한 최대 개수
class Main {
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        list.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        int answer = 0;
        int lastTime = 0;
        for(int[] l : list) {
            int start = l[0];
            int end = l[1];
            if(start >= lastTime) {
                answer++;
                lastTime = end;
            }
        }
         System.out.println(answer);
     }
}