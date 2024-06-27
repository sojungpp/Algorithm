import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] grades = new int[N];
        for(int i=0; i<N; i++){
            grades[i] = sc.nextInt();
        }

        for(int i=0; i<K; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            int sum = 0;
            for(int j=start-1; j<end; j++){
                sum += grades[j];
            }
            System.out.println(String.format("%.2f", sum/(double)(end-start+1)));
        }
    }
}
