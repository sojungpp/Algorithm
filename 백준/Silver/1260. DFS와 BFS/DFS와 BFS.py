from collections import deque

import sys
input = sys.stdin.readline

# N = 정점 개수, M = 간선 개수, V = 정점 번호
N, M, V = map(int, input().split())

adj = [[0] * int(N+1) for _ in range(int(N+1))] # 메트릭스 만들기
visited = [False] * (N+1) # 방문 여부

for _ in range(M):
    a, b = map(int, input().split())
    adj[a][b] = adj[b][a] = 1 # 모든 간선에 1 넣어주기

def dfs(matrix, i, visited):
  visited[i] = True # 방문 표시
  print(i, end=' ')

  for a in range(len(matrix[i])):
    if matrix[i][a] == 1 and not visited[a]: # 간선이 있고, 방문하지 않은 것
      dfs(matrix, a, visited)

def bfs(matrix, i, visited):
  queue= deque()
  queue.append(i)

  while queue:
    value = queue.popleft()
    if not visited[value]: # 방문하지 않은 것
      visited[value] = True  # 방문 표시
      print(value, end=' ')
      for c in range(len(matrix[value])):
        if matrix[value][c] == 1 and not visited[c]:
          queue.append(c)


dfs(adj, V, visited)
print()
visited = [False] * int(N+1) # visited 초기화
bfs(adj, V, visited)