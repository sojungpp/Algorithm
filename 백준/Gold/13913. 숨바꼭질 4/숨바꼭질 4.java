import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        int[] way = new int[100001];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        visited[N] = true;
        way[N] = -1;
        

        while(!q.isEmpty()) {
            int[] temp = q.poll();

            if(temp[0] == K) {
                System.out.println(temp[1]);
                break;
            }

            for(int i=0; i<3; i++) {
                int[] newTemp = new int[temp.length+1];
                if(i==0 && temp[0]-1 >= 0 && !visited[temp[0]-1]) {
                    visited[temp[0]-1] = true;
                    way[temp[0]-1] = temp[0];
                    q.add(new int[]{temp[0]-1, temp[1]+1});
                } else if(i==1 && temp[0]+1 <= 100000 && !visited[temp[0]+1]) {
                    visited[temp[0]+1] = true;
                    way[temp[0]+1] = temp[0];
                    q.add(new int[]{temp[0]+1, temp[1]+1});
                } else if(temp[0]*2 >= 0 && temp[0]*2 <= 100000 && !visited[temp[0]*2]){
                    visited[temp[0]*2] = true;
                    way[temp[0]*2] = temp[0];
                    q.add(new int[]{temp[0]*2, temp[1]+1});
                }
            }
            
        }
    
        List<Integer> answer = new ArrayList<>();
        for(int i=K; i != -1; i=way[i]) {
            answer.add(i);
        }
        Collections.reverse(answer);
        for(int a : answer) {
            System.out.print(a + " ");
        }
    }
}