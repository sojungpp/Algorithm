import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<N; i++){
            set.add(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        for(Integer value: set) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);

    }
}