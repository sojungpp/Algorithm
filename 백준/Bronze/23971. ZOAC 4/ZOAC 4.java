import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // H, W, N, M
        int H = sc.nextInt(); // 세로
        int W = sc.nextInt(); // 가로
        int N = sc.nextInt(); // 세로
        int M = sc.nextInt(); // 가로

        int row = H / (N+1);
        if(H % (N+1) != 0) row++;
        int col = W / (M+1);
        if(W % (M+1) != 0) col++;

        System.out.println(row * col);
    }
}