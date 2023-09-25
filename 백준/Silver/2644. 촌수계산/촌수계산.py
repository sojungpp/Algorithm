import sys
input = sys.stdin.readline


N = int(input()) # 정점 수
A, B = map(int, input().split()) # 구해야 하는 촌수 사람
M = int(input()) # 간선 수

arr = [[] for _ in range(N+1)] # 리스트 만들기
visited = [0] * (N+1) # 방문 여부이자 순서 저장
answer = [0] * (N+1)

for _ in range(M):
    a, b = map(int, input().split())
    arr[a].append(b) # 양방향 설정
    arr[b].append(a)

def dfs(x):
    visited[x] = 1 # 방문 체크
    for i in arr[x]: # 이어진 간선들 중
        if not visited[i]: # 방문하지 않았으면 탐색
            answer[i] = answer[x] + 1 # 촌수 +1
            dfs(i)

dfs(A)

if answer[B] == 0:
    print(-1)
else:
    print(answer[B])