import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M, L, K, answer;
    static List<int[]> stars;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로 길이
        M = Integer.parseInt(st.nextToken()); // 세로 길이
        L = Integer.parseInt(st.nextToken()); // 트램펄린 한 변
        K = Integer.parseInt(st.nextToken()); // 별동별 수

        stars = new ArrayList<>();
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x, y});
        }

        answer = K;
        for(int[] star1 : stars) {
            for(int[] star2 : stars) {
                calculateStar(star1[0], star2[1]);
            }
        }
        
        System.out.println(answer);
    }

    private static void calculateStar(int x, int y) {
        int cnt = 0;
        for(int[] star : stars) {
            if(x <= star[0] && star[0] <= x+L && y <= star[1] && star[1] <= y+L) cnt++;
        }
        answer = Math.min(answer, K-cnt);
    }
}