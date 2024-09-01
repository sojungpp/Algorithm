import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[] house, festival;
    static List<int[]> store;
    static boolean[] visited;
    static boolean answer;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            answer = false;
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            house = new int[2];
            house[0] = Integer.parseInt(st.nextToken());
            house[1] = Integer.parseInt(st.nextToken());
            
            store = new ArrayList<>();
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                int[] s = new int[2];
                s[0] = Integer.parseInt(st.nextToken());
                s[1] = Integer.parseInt(st.nextToken());
                store.add(s);
            }
            visited = new boolean[store.size()];

            st = new StringTokenizer(br.readLine());
            festival = new int[2];
            festival[0] = Integer.parseInt(st.nextToken());
            festival[1] = Integer.parseInt(st.nextToken());
            
            dfs(house[0], house[1], 20);
            
            if(answer) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    private static void dfs(int x, int y, int num){
        if(Math.abs(x-festival[0]) + Math.abs(y-festival[1]) <= num * 50) {
            answer = true;
            return;
        }
        
        for(int i=0; i<store.size(); i++) {
            int storeX = store.get(i)[0];
            int storeY = store.get(i)[1];

            if(!visited[i] && Math.abs(x-storeX) + Math.abs(y-storeY) <= num * 50) {
                visited[i] = true;
                dfs(storeX, storeY, 20);
            }
        }
    }
}