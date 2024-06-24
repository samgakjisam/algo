#include<iostream>
#include<queue>

using namespace std;

int n, m;
int arr[1000][1000] = { 0, };
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
queue<pair<int, int>> qu;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> m >> n;
	
	int u = 0;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			int t;
			cin >> t;

			arr[i][j] = t;
			if (t == 1) {
				qu.push({ i,j });
			}
			else if (t == 0) {
				u++;
			}
		}
	}

	if (u == 0) {
		cout << 0;
		return 0;
	}
	int ans = 0;

	while (!qu.empty()) {
		int a = qu.front().first;
		int b = qu.front().second;
		qu.pop();

		if (u <= 0) {
			break;
		}

		for (int i = 0; i < 4; i++) {
			int na = a + dx[i];
			int nb = b + dy[i];

			if (na < n && na >= 0 &&
				nb < m && nb >= 0 &&
				arr[na][nb] == 0) {
				arr[na][nb] = arr[a][b] + 1;
				u--;
				qu.push({ na,nb });
				if (arr[na][nb] > ans) {
					ans = arr[na][nb];
				}
			}
		}
	}

	//for (int i = 0; i < n; i++) {
	//	for (int j = 0; j < m; j++) {
	//		cout << arr[i][j] << " ";
	//	}
	//	cout << "\n";
	//}
	//cout << u << "\n";

	if (u <= 0) {	
		cout << ans - 1;
	}
	else {
		cout << -1;
	}

	return 0;
}
