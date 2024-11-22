import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] buildings = new int[T];
        int[] answer = new int[T];
        for(int i=0; i<T; i++) {
            buildings[i] = sc.nextInt();
        }

        for(int i=0; i<T-1; i++) {
            answer[i]++;
            answer[i+1]++;
            double standard = buildings[i+1] - buildings[i];
            
            for(int j=i+2; j<T; j++) {
                if(standard < (double) (buildings[j] - buildings[i]) / (j-i)) {
                    standard = (double) (buildings[j] - buildings[i]) / (j-i);
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        int answerValue = 0;
        for(int i=0; i<T; i++) {
            answerValue = Math.max(answerValue, answer[i]);
        }
        System.out.println(answerValue);
    }
}