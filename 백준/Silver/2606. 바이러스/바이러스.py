import sys
input = sys.stdin.readline

N = int(input()) # 정점 수 (컴퓨터 수)
M = int(input()) # 간선 수

adj = [[] for _ in range(N+1)] # 리스트 만들기
visited = [0] * (N+1) # 방문 여부
answer = 0

for _ in range(M):
    a, b = map(int, input().split())
    adj[a].append(b) # 양방향 설정
    adj[b].append(a)

def dfs(x):
    global answer
    answer += 1
    visited[x] = 1 # 방문 표시

    for i in adj[x]: # 이어진 간선들 중
        if not visited[i]: # 방문하지 않았으면 탐색
            dfs(i)

dfs(1)
# 1번 컴퓨터도 포함했으니 마지막에 1 빼주기
print(answer-1)