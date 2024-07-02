# [Gold V] 뱀과 사다리 게임 - 16928 

[문제 링크](https://www.acmicpc.net/problem/16928) 

### 성능 요약

영훈 - 메모리: 34168 KB, 시간: 64 ms<br/>
민재 - 메모리: 14276 KB, 시간: 108 ms<br/>
기용 - 메모리: 14332 KB, 시간: 100 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 문제 설명

<p><a href="https://en.wikipedia.org/wiki/Snakes_and_Ladders">뱀과 사다리 게임</a>을 즐겨 하는 큐브러버는 어느 날 궁금한 점이 생겼다.</p>

<blockquote>
<p>주사위를 조작해 내가 원하는 수가 나오게 만들 수 있다면, 최소 몇 번만에 도착점에 도착할 수 있을까?</p>
</blockquote>

<p>게임은 정육면체 주사위를 사용하며, 주사위의 각 면에는 1부터 6까지 수가 하나씩 적혀있다. 게임은 크기가 10×10이고, 총 100개의 칸으로 나누어져 있는 보드판에서 진행된다. 보드판에는 1부터 100까지 수가 하나씩 순서대로 적혀져 있다.</p>

<p>플레이어는 주사위를 굴려 나온 수만큼 이동해야 한다. 예를 들어, 플레이어가 i번 칸에 있고, 주사위를 굴려 나온 수가 4라면, i+4번 칸으로 이동해야 한다. 만약 주사위를 굴린 결과가 100번 칸을 넘어간다면 이동할 수 없다. 도착한 칸이 사다리면, 사다리를 타고 위로 올라간다. 뱀이 있는 칸에 도착하면, 뱀을 따라서 내려가게 된다. 즉, 사다리를 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 크고, 뱀을 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 작아진다.</p>

<p>게임의 목표는 1번 칸에서 시작해서 100번 칸에 도착하는 것이다.</p>

<p>게임판의 상태가 주어졌을 때, 100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값을 구해보자.</p>

### 입력 

 <p>첫째 줄에 게임판에 있는 사다리의 수 N(1 ≤ N ≤ 15)과 뱀의 수 M(1 ≤ M ≤ 15)이 주어진다.</p>

<p>둘째 줄부터 N개의 줄에는 사다리의 정보를 의미하는 x, y (x < y)가 주어진다. x번 칸에 도착하면, y번 칸으로 이동한다는 의미이다.</p>

<p>다음 M개의 줄에는 뱀의 정보를 의미하는 u, v (u > v)가 주어진다. u번 칸에 도착하면, v번 칸으로 이동한다는 의미이다.</p>

<p>1번 칸과 100번 칸은 뱀과 사다리의 시작 또는 끝이 아니다. 모든 칸은 최대 하나의 사다리 또는 뱀을 가지고 있으며, 동시에 두 가지를 모두 가지고 있는 경우는 없다. 항상 100번 칸에 도착할 수 있는 입력만 주어진다.</p>

### 출력 

 <p>100번 칸에 도착하기 위해 주사위를 최소 몇 번 굴려야 하는지 출력한다.</p>