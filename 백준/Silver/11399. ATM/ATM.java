import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        int temp = 0;
        while(!q.isEmpty()) {
            temp += q.poll();
            answer += temp;
        }
        System.out.println(answer);
    }
}