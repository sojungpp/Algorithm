import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String[] list = sc.next().split("");
        boolean[] isEaten = new boolean[list.length];
        int answer = 0;

        for(int i=0; i<list.length; i++){
            if(!list[i].equals("P")) continue;
            int minStandard = 0;
            int maxStandard = list.length-1;
            if(i-K >= 0) minStandard = i-K;
            if(i+K <= maxStandard) maxStandard = i+K;
            // 먹을 수 있는 범위 중 가장 왼쪽 햄버거 먹기
            for(int j=minStandard; j<=maxStandard; j++){
                if(list[j].equals("H") && !isEaten[j]){
                    isEaten[j] = true;
                    answer++;
                    break;
                } 
            }
        }
        System.out.println(answer);
    }
}