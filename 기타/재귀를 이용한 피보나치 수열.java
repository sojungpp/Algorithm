import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int answer = fibo(input);
        System.out.println(answer);
    }

    private static int fibo(int n) {
        if(n < 2) return n;
        else return fibo(n-1) + fibo(n-2);
    }
}
