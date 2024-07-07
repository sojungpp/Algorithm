import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] answer = new int[N];
        
        for(int i=1; i<=N; i++){
            int num = sc.nextInt();
            int cnt = 0;
            for(int j=0; j<N; j++){
                if(answer[j] != 0) continue;
                if(cnt == num){
                    answer[j] = i;
                    break;
                }
                else cnt++;
            }

        }

        for(int i=0; i<N; i++){
            System.out.print(answer[i] + " ");
        }
    }
}