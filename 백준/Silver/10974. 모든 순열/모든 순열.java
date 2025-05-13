import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        comb(new int[N], new boolean[N+1], 0);
    }

    private static void comb(int[] temp, boolean[] visited, int cnt) {
        if(cnt == N) {
            for(int t : temp) {
                System.out.print(t + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[cnt] = i;
                comb(temp, visited, cnt+1);
                visited[i] = false;
            }
        }
    }
}