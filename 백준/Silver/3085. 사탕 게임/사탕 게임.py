N = int(input())
candy = [list(input()) for _ in range(N)]
answer = 1

def checkNum():
    global answer
    for a in range(N):
        width = 1
        height = 1
        for b in range(N-1):
            if candy[a][b] == candy[a][b+1]:
                width += 1
                answer = max(answer, width)
            else:
                width = 1
        for b in range(N-1):
            if candy[b][a] == candy[b+1][a]:
                height += 1
                answer = max(answer, height)
            else:
                height = 1

for i in range(N):
    for j in range(N):
        if j+1 < N:
            candy[i][j], candy[i][j + 1] = candy[i][j + 1], candy[i][j]
            checkNum()
            candy[i][j], candy[i][j + 1] = candy[i][j + 1], candy[i][j]
        if i+1 < N:
            candy[i][j], candy[i + 1][j] = candy[i + 1][j], candy[i][j]
            checkNum()
            candy[i][j], candy[i + 1][j] = candy[i + 1][j], candy[i][j]

print(answer)