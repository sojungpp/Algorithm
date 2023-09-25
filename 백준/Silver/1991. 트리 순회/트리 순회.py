import sys
input = sys.stdin.readline

# 노드, 왼쪽, 오른쪽 값 갖는 클래스
class Node():
    def __init__(self, item, left, right):
        self.item = item
        self.left = left
        self.right = right

tree = {}
N = int(input())
for _ in range(N):
    # 노드, 왼쪽 자식 노드, 오른쪽 자식 노드
    a, b, c = map(str, input().split())
    # tree 배열에 Node 클래스 만들어서 넣어주기
    tree[a] = Node(a, b, c)

# 전위 순회
# 현재 -> 왼쪽 -> 오른쪽
def preorder(node):
    print(node.item, end = "")
    if node.left != ".":
        preorder(tree[node.left])
    if node.right != ".":
        preorder(tree[node.right])

# 중위 순회
# 왼쪽 -> 현재 -> 오른쪽
def inorder(node):
    if node.left != ".":
        inorder(tree[node.left])
    print(node.item, end = "")
    if node.right != ".":
        inorder(tree[node.right])

# 후위 순회
# 왼쪽 -> 오른쪽 -> 현재
def postorder(node):
    if node.left != ".":
        postorder(tree[node.left])
    if node.right != ".":
        postorder(tree[node.right])
    print(node.item, end="")

preorder(tree['A'])
print()
inorder(tree['A'])
print()
postorder(tree['A'])