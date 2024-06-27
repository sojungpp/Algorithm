import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    private static boolean isTree(int root, int vertex, int edge, boolean isEdgeOne){
        /*
        1. 들어오는 간선 하나도 없는 것 = 1개 (루트)
        2. 정점의 개수 - 1 == 간선의 개수
        3. 들어오는 간선 무조건 1개
        */
        return ((root == 1) && vertex - 1 == edge && isEdgeOne);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 0;
        while(true){
            k++;
            int edge = -1; // 0, 0 빼기
            int vertex = 0;
            int root = 0;
            boolean isEdgeOne = true;
            Map<Integer, Integer> map = new HashMap<>();
            
            while(true){
                edge++;
                int start = sc.nextInt();
                int end = sc.nextInt();
    
                // 테스트 케이스 하나 끝난 경우
                if(start == 0 && end == 0) break;
                // 전체 끝난 경우
                if(start == -1 && end == -1) return;

                
                map.put(start, map.getOrDefault(start, 0));
                if(start != end) map.put(end, map.getOrDefault(end, 0) + 1);
            }

            Set<Integer> keys = map.keySet();

            for (Integer key : keys) {
                vertex++;
                // root 체크
                if(map.get(key) == 0) root++;
                // 들어오는 간선 수 체크
                if(map.get(key) > 1) {
                    // 2개 이상이면 트리 X
                    isEdgeOne = false;
                    break;
                }
            }

            if(!isTree(root, vertex, edge, isEdgeOne) && map.size() != 0) System.out.println("Case " + k + " is not a tree.");
            else System.out.println("Case " + k + " is a tree.");
        }
    }
}