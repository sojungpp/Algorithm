

import java.util.*;

public class Main {

    private static boolean isPrime(int value) {
        if(value < 2) return false;

        for(int i = 2; i < value; i++) {
            if(value % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int answer = 0;
        int minimum = Integer.MAX_VALUE;

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        for(int i = M; i < N + 1; i++){
            if(isPrime(i)) {
                answer += i;
                minimum = Math.min(minimum, i);
            }
        }

        if(answer == 0) System.out.println("-1");
        else {
            System.out.println(answer);
            System.out.println(minimum);
        }
    }

}
