import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        int[] cnt = new int[N+1];

        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            list.get(front).add(back);
            cnt[back]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        // 앞 학생 없는 경우 추가
        for(int i=1; i<=N; i++) {
            if(cnt[i] == 0) q.add(i);
        }

        // 위상정렬
        while(!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");
            for(int next : list.get(temp)) {
                cnt[next]--;
                if(cnt[next] == 0) q.add(next);
            }
        }
    }
}