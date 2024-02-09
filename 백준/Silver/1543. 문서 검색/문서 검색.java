import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String docs = sc.nextLine();
        String target = sc.nextLine();
        int answer = 0;

        while(docs.contains(target)) {
            answer += 1;
            docs = docs.substring(docs.indexOf(target)+target.length());
        }

        System.out.println(answer);
    }
}
