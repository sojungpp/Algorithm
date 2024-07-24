import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 벨트 위 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            sushi[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        int left = 0;

        while(left < N){
            Set<Integer> dishes = new HashSet<>();
            for(int i=0; i<k; i++){
                int index = left+i;
                if(index >= N) index -= N;
                dishes.add(sushi[index]);
            }
            if(!dishes.contains(c)) dishes.add(c);
            answer = Math.max(answer, dishes.size());
            left++;
        }

        System.out.println(answer);
        
    }
}