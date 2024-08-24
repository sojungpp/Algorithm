import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        
        // 메모장
        for(int i=0; i<N; i++) {
            set.add(br.readLine());
        }

        // 블로그
        for(int i=0; i<M; i++) {
            // 쉼표로 구분
            int answer = set.size();
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()) {
                String word = st.nextToken();
                if(set.contains(word)) set.remove(word);
            }
            System.out.println(set.size());    
        }
        
    }
}