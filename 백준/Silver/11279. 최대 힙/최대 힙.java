import java.util.*;

class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        for(int i=0; i<num; i++){
            int target = sc.nextInt();
            if(target == 0){
                if(q.isEmpty()) System.out.println(target);
                else System.out.println(q.poll());
            }
            else q.add(target);
        }
    }
}