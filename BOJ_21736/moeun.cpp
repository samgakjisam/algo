#include<iostream>
#include<string>
#include<queue>

using namespace std;

int n, m;
int arr[600][600] = { 0, };
int vis[600][600] = { 0, };
int dx[4] = { 0, 1, 0, -1 };
int dy[4] = { 1, 0, -1, 0 };

void bfs(int x, int y) {
	queue<pair<int, int>> q;

	q.push({ x, y });
	vis[x][y] = 1;
	int ans = 0;

	while (!q.empty()) {
		int a = q.front().first;
		int b = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int na = a + dx[i];
			int nb = b + dy[i];

			if (na >= 0 && na < n && nb >= 0 && nb < m && arr[na][nb] != 1 && vis[na][nb] != 1) {
				if (arr[na][nb] == 2) {
					ans++;
				}
				vis[na][nb] = 1;
				q.push({ na, nb });
			}
		}
	}

	if (ans > 0) {
		cout << ans;
	}
	else {
		cout << "TT";
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	cin >> n >> m;
	int x, y;

	for (int i = 0; i < n; i++) {
		string line;
		cin >> line;

		for (int j = 0; j < m; j++) {
			char c = line[j];
			if (c == 'O') arr[i][j] = 0;
			else if (c == 'I') {
				x = i;
				y = j;
			}
			else if (c == 'X') arr[i][j] = 1;
			else if (c == 'P') arr[i][j] = 2;
		}
	}

	bfs(x, y);

	return 0;
}
