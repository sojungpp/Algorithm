import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] list;
    static int N;
    static int answer = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] visited = new boolean[N];
        int[] temp = new int[N];
        combination(0, visited, temp);
        System.out.println(answer);
    }

    private static void combination(int cnt, boolean[] visited, int[] temp) {
        if(cnt == N) {
            checkMax(temp);
        }
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                temp[cnt] = list[i];
                visited[i] = true;
                combination(cnt+1, visited, temp);
                visited[i] = false;
            }
        }
    }

    private static void checkMax(int[] temp) {
        int sum = 0;
        for(int i=0; i<N-1; i++) {
            sum += Math.abs(temp[i] - temp[i+1]);
        }
        answer = Math.max(sum, answer);
    }
}