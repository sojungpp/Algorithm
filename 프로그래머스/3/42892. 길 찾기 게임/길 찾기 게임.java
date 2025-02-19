import java.util.*;

class Solution {
    int[][] answer;
    int index;
        
    public int[][] solution(int[][] nodeinfo) {
        // node 저장하기
        Node[] node = new Node[nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++) {
            node[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null);
        }
        
        // 노드 정렬 (y값 큰 순 -> x값 작은 순)
        Arrays.sort(node, (a, b) -> {
            if(a.y != b.y) return b.y - a.y;
            else return a.x - b.x;
        });
            
        // 트리 만들기
        Node root = node[0];
        for(int i=1; i<node.length; i++) {
            insertNode(root, node[i]);
        }
        
        answer = new int[2][nodeinfo.length];
        // 전위 순회
        index = 0;
        preorder(root);
        // 후위 순회
        index = 0;
        postorder(root);

        return answer;
    }
    
    private void postorder(Node root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][index++] = root.value;
        }
    }
    
    private void preorder(Node root) {
        if(root != null) {
            answer[0][index++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    private void insertNode(Node parent, Node child) {
        if(child.x < parent.x) {
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    public class Node {
        int x;
        int y;
        int value;
        Node left;
        Node right;
        
        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    
}