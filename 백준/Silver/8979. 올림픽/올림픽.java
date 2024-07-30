import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        /*
        금메달 수가 더 많은 나라 
        금메달 수가 같으면, 은메달 수가 더 많은 나라
        금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라
        */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Map<Integer, int[]> list = new HashMap<>();

        for(int i=0; i<N; i++){
            int nation = sc.nextInt();
            int[] medal = new int[4];
            medal[0] = sc.nextInt();
            medal[1] = sc.nextInt();
            medal[2] = sc.nextInt();
            list.put(nation, medal);
        }

        boolean[] isEqual = new boolean[N];
        List<Integer> keySet = new ArrayList<>(list.keySet());
        keySet.sort((o1, o2) -> {
            int[] array1 = list.get(o1);
            int[] array2 = list.get(o2);

            if(array1[0] != array2[0]){
                return Integer.compare(array2[0], array1[0]);
            }
            else if(array1[1] != array2[1]){
                return Integer.compare(array2[1], array1[1]);
            }
            else if(array1[2] != array2[2]){
                return Integer.compare(array2[2], array1[2]);
            }
            else {
                isEqual[o2] = true;
                return 0;
            }
        });

        int result = 1;
        for(Integer key : keySet){
            if(key.equals(K)) break;
            if(isEqual[key]) continue;
            else result++;
        }
        
        System.out.println(result);
    }
}