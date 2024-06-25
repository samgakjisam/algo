#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int m, n;
int arr[1000][1000] = { 0, };
queue<pair<int, int>> que;
int di[4] = { 0, 1, 0, -1 };
int dj[4] = { 1, 0, -1, 0 };


void FindInitOne() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (arr[i][j] == 1) {
				pair<int, int> p = make_pair(i, j);
				que.push(p);
			}
		}
	}
}


void bfs() {
	while (!que.empty()) {
		int i = que.front().first;
		int j = que.front().second;
		que.pop();

		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (0 <= ni && ni < n && 0 <= nj && nj < m && arr[ni][nj] == 0) {
				arr[ni][nj] = arr[i][j] + 1;
				pair<int, int> p = make_pair(ni, nj);
				que.push(p);
			}
		}
	}
}


int FindAns() {
	int max_val = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (arr[i][j] == 0) {
				return -1;
			}
			max_val = max(max_val, arr[i][j]);
		}
	}
	return max_val - 1;
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> m >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
		}
	}

	FindInitOne();
	bfs();
	int ans = FindAns();
	cout << ans;
	
	return 0;
}