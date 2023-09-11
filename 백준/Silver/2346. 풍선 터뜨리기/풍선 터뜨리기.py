from collections import deque
import sys
input = sys.stdin.readline

N = int(input()) # 풍선의 수
balloon = deque(enumerate(map(int, input().split()))) # 풍선 순서, 종이에 적혀 있는 수
answer = [] # 터진 풍선의 번호

while balloon:
    paper = balloon[0][1]
    answer.append(balloon[0][0]+1) # 맨 앞(터뜨릴) 풍선 저장 (0부터 시작해서 +1)
    balloon.popleft() # 맨 앞(터뜨릴) 풍선 제거
    if paper > 0:
        balloon.rotate(-(paper-1)) # 앞에서 풍선을 제거했으므로(=한 번 회전됨) -(paper-1)만큼 회전
    else:
        balloon.rotate(-paper) # 앞에서 풍선 제거했어도 반대 방향 회전이므로 -paper만큼 회전

print(*answer)