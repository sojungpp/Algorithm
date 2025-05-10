import java.util.*;
import java.lang.*;
import java.io.*;

// A와 B가 한 팀 = AB + BA = 능력치
// 두 팀으로 나눌 때, 능력치 차이 최솟값
class Main {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static int n;
    static int[][] power;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        power = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                power[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n];
        comb(0, 0);
        System.out.println(answer);
    }

    // 조합
    private static void comb(int num, int cnt) {
        if(cnt == n/2) {
            comparePower();
            return;
        }

        for(int i=num; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }

    // 팀의 능력치 비교
    private static void comparePower() {
        int teamA = 0;
        int teamB = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(i==j) continue;
                if(visited[i] && visited[j]) teamA += power[i][j] + power[j][i];
                if(!visited[i] &&! visited[j]) teamB += + power[i][j] + power[j][i];
            }
        }
        answer = Math.min(answer, Math.abs(teamA-teamB));
    }
}