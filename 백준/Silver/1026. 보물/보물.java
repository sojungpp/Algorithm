import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            listA.add(sc.nextInt());
        }

        for(int i=0; i<N; i++) {
            listB.add(sc.nextInt());
        }
        Collections.sort(listB);
        Collections.sort(listA, Comparator.reverseOrder());

        int s = 0;
        for(int i=0; i<N; i++) {
            s += (listA.get(i) * listB.get(i));
        }
        System.out.println(s);
    }
}