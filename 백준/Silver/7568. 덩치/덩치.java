import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, int[]> map = new HashMap<>();
        int[] answer = new int[N];
        
        for(int i=1; i<=N; i++){
            int[] arr = new int[2];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            map.put(i, arr);
        }

        List<Integer> key = new ArrayList<>(map.keySet());
        key.sort((o1, o2) -> {
            if(map.get(o1)[0] == map.get(o2)[0])
                return Integer.compare(map.get(o1)[1], map.get(o2)[1]);
            else return Integer.compare(map.get(o1)[0], map.get(o2)[0]);
                }
        );

        for(int i=0; i<key.size(); i++){
            int result = 0;
            for(int j=i+1; j<key.size(); j++){
                if(map.get(key.get(i))[0] == map.get(key.get(j))[0]) continue;
                if(map.get(key.get(i))[1] < map.get(key.get(j))[1]) {
                    result++;
                }
            }
            answer[key.get(i)-1] = result+1;
        }

        for(int a : answer){
            System.out.print(a + " ");
        }
    }
}