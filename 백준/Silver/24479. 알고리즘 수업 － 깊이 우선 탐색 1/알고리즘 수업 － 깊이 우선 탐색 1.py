import sys
sys.setrecursionlimit(10**9) # recursionError(재귀 함수 호출 횟수 제한) 해결을 위해 깊이 늘리기
input = sys.stdin.readline


N, M, R = map(int, input().split()) # 정점 수, 간선 수, 시작 정점
adj = [[] for _ in range(N+1)] # 리스트 만들기
visited = [0] * (N+1) # 방문 여부이자 순서 저장
index = 1 # 방문 순서

for _ in range(M):
    a, b = map(int, input().split())
    adj[a].append(b) # 양방향 설정
    adj[b].append(a)

def dfs(x):
    global index
    adj[x].sort() # 오름차순 정렬
    visited[x] = index # 방문 순서

    for i in adj[x]: # 이어진 간선들 중
        if not visited[i]: # 방문하지 않았으면 탐색
            index += 1 # 방문 순서 +1
            dfs(i) 

dfs(R)

for i in range(1, N+1):
    print(visited[i])

