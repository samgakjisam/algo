#include<iostream>
#include<queue>

using namespace std;

int n, m;
int arr[1000][1000];
int vis[1000][1000];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
    
	cin >> n >> m;

	int a, b;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			vis[i][j] = -1;

			cin >> arr[i][j];

			if (arr[i][j] == 2) {
				a = i;
				b = j;
				vis[i][j] = 0;
			}
			else if (arr[i][j] == 0) {
				vis[i][j] = 0;
			}
		}
	}

	queue<pair<int, int>> qu;

	qu.push({ a, b });	

	while (!qu.empty()) {
		int x = qu.front().first;
		int y = qu.front().second;
		qu.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (arr[nx][ny] == 1 && vis[nx][ny] == -1) {
					qu.push({ nx, ny });
					vis[nx][ny] = vis[x][y] + 1;
				}
				else if (arr[nx][ny] == 0) {
					vis[nx][ny] = 0;
				}
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << vis[i][j] << " ";
		}
		cout << "\n";
	}

	return 0;
}
