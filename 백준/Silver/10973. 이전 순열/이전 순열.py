import sys
input = sys.stdin.readline

N = int(input())
value = list(map(int, input().split()))

for i in range(N-1, 0, -1): # for문 거꾸로
    if value[i] < value[i-1]: # 현재 값이 앞의 값(기준 값)보다 작은 경우 = 바꿔 주어야 하는 경우
        for j in range(N-1, 0, -1): # for문 거꾸로
            if value[i-1] > value[j]: # 기준 값보다 작은 값
                value[i-1], value[j] = value[j], value[i-1] # 기준 값 <-> 작은 값 swap

                temp = value[i:] # i값 부터는
                temp.sort(reverse=True) # 내림차순 정렬
                answer = value[:i] + temp # i값 이전과 위의 정렬한 것 합치기
                print(*answer)
                exit()
print(-1) # 첫 번째 순열인 경우