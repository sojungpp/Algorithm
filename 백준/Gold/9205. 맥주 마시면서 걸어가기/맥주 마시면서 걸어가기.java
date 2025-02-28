import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] home, festival;
    static List<int[]> market;
    static boolean isArrived;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            home = new int[2];
            festival = new int[2];
            market = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                int[] temp = new int[2];
                temp[0] = Integer.parseInt(st.nextToken());
                temp[1] = Integer.parseInt(st.nextToken());
                market.add(temp);
            }
            visited = new boolean[market.size()];
            st = new StringTokenizer(br.readLine());
            festival[0] = Integer.parseInt(st.nextToken());
            festival[1] = Integer.parseInt(st.nextToken());
            
            int beer = 20;
            isArrived = false;
            dfs(home[0], home[1], beer);
            if(isArrived) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    private static void dfs(int x, int y, int beer) {
        if(isFinished(x, y, beer)) {
            isArrived = true;
            return;
        }

        int size = market.size();
        for(int i=0; i<size; i++) {
            int[] m = market.get(i);
            if(!visited[i] && (Math.abs(x - m[0]) + Math.abs(y - m[1])) <= beer*50) {
                visited[i] = true;
                dfs(m[0], m[1], 20);
            }
        }
    }

    private static boolean isFinished(int x, int y, int beer) {
        return (Math.abs(x - festival[0]) + Math.abs(y - festival[1])) <= beer*50;
    }
}