import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int day = sc.nextInt();
            int[] stock = new int[day];
            for(int j=0; j<day; j++){
                stock[j] = sc.nextInt();
            }
            // 주식 하나를 산다.
            // 원하는 만큼 가지고 있는 주식을 판다.
            // 아무것도 안한다.
            int max = stock[day-1];
            long answer = 0;
            for(int j=day-2; j>=0; j--){
                if(stock[j] > max) max = stock[j];
                else answer += max - stock[j];
            }
            System.out.println(answer);
        }
    }
}