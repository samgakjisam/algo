#include<iostream>
#include<string>
#include<queue>

using namespace std;

int n, m;
char arr[100][100];
int vis[100][100] = { 0, };
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		string line;
		cin >> line;

		for (int j = 0; j < m; j++) {
			arr[i][j] = line[j];
		}
	}

	queue<pair<int, int>> qu;
	qu.push({ 0, 0 });
	vis[0][0] = 1;

	while (!qu.empty()) {
		int a = qu.front().first;
		int b = qu.front().second;
		qu.pop();

		if (a == n - 1 && b == m - 1) {
			break;
		}


		for (int i = 0; i < 4; i++) {
			int na = a + dx[i];
			int nb = b + dy[i];

			if (na >= 0 && na < n &&
				nb >= 0 && nb < m &&
				arr[na][nb] == '1' &&
				vis[na][nb] == 0) {
				vis[na][nb] = vis[a][b] + 1;
				qu.push({ na, nb });
			}
		}
	}

	cout << vis[n - 1][m - 1];

	return 0;
}
