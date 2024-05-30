#include<iostream>
#include<queue>
#include<stack>
#define MAX_N 1001

using namespace std;

int n, m, v, x;
int arr[MAX_N][MAX_N] = { 0, };

void dfs() {
	stack<int> st;
	st.push(v);
	cout << v << " ";

	int vis[MAX_N] = { 0, };
	vis[v] = 1;

	while (!st.empty()) {
		x = st.top();
		bool flg = true;

		for (int i = 1; i <= n; i++) {
			if (arr[x][i] == 1 && vis[i] == 0) {
				st.push(i);
				cout << i << " ";
				vis[i] = 1;
				flg = false;
				break;
			}
		}

		if (flg) {
			st.pop();
		}
	}
}

void bfs() {
	queue<int> qu;
	qu.push(v);

	int vis[MAX_N] = { 0, };
	vis[v] = 1;

	while (!qu.empty())
	{
		x = qu.front();
		qu.pop();
		cout << x << " ";

		for (int i = 1; i <= n; i++) {
			if (arr[x][i] == 1 && vis[i] == 0) {
				qu.push(i);
				vis[i] = 1;
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m >> v;

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		arr[a][b] = 1;
		arr[b][a] = 1;
	}

	dfs();
	cout << endl;
	bfs();

	return 0;
}