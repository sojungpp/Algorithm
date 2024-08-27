import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int size = target.length();

        int zero = size - target.replace("0", "").length();
        int one = size - target.replace("1", "").length();

        String answer = "";
        answer += "0".repeat(zero/2);
        answer += "1".repeat(one/2);

        System.out.println(answer);
    }
}