import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] member = new String[]{"SK", "CY"};
        if(N%2 == 0) System.out.println(member[1]);
        else System.out.println(member[0]);
    }
}