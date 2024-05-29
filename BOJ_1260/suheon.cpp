/*
  인접리스트 => 정렬
*/

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<vector<int>> v;

bool visited_D[1001] = { false, };
bool visited_B[1001] = { false, };

void dfs(int start) {
	visited_D[start] = true;
	cout << start << " ";
	for (int i = 0; i < v[start].size(); i++) {
		if (visited_D[v[start][i]] == true) continue;
		dfs(v[start][i]);
	}
}

void bfs(int start) {
	queue <int> q;
	q.push(start);
	visited_B[start] = true;
	while (!q.empty()) {
		int now = q.front();
		q.pop();
		cout << now << " ";
		for (int i = 0; i < v[now].size(); i++) {
			if (visited_B[v[now][i]] == true) continue;
			q.push(v[now][i]);
			visited_B[v[now][i]] = true;
		}
	}
}

int main() {
	int N, M, V = 0;
	cin >> N >> M >> V;

	for (int i = 0; i < N+1; i++) {
		vector<int> tmp;
		v.push_back(tmp);
	}

	for (int i = 0; i < M; i++) {
		int s, t = 0;
		cin >> s >> t;
		v[s].push_back(t);
		v[t].push_back(s);
	}

	for (int i = 0; i < N+1; i++) {
		sort(v[i].begin(), v[i].end());
	}

	dfs(V);
	cout << "\n";
	bfs(V);
}
