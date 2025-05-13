import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M, answer;
    static List<Node> house, chicken;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chicken = new ArrayList<>();
        answer = Integer.MAX_VALUE;
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input == 1) house.add(new Node(i, j));
                else if(input == 2) chicken.add(new Node(i, j));
            }
        }

        // 조합
        combination(new ArrayList<>(), 0);
        System.out.println(answer);
    }

    private static void combination(List<Node> list, int start) {
        if(list.size() == M) {
            checkMinDist(list);
            return;
        }

        for(int i=start; i<chicken.size(); i++) {
            list.add(chicken.get(i));
            combination(list, i+1);
            list.remove(list.size()-1);
        }
    }

    private static void checkMinDist(List<Node> list) {
        int temp = 0;
        for(Node h : house) {
            if(temp > answer) return;
            int distance = Integer.MAX_VALUE;
            for(Node l : list) {
                distance = Math.min(distance, Math.abs(h.x-l.x) + Math.abs(h.y-l.y));
            }
            temp += distance;
        }
        answer = Math.min(temp, answer);
    }
    

    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}