#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n, m;
int q;

vector <int> v[1001];
int visited[1001] = { 0, };

void bfs(int start) {

	queue <int> q;
	visited[start] += 1;
	q.push(start);

	while (!q.empty()) {
		int now = q.front();
		q.pop();

		for (int i = 0; i < v[now].size(); i++) {
			
			int next = v[now][i];

			if (visited[next] == -1) {
				visited[next] = visited[now] + 1;
				q.push(next);
			}
			else {
				visited[next] = min(visited[now] + 1, visited[next]);
			}
		}
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int f, t;
		cin >> f >> t;
		v[f].push_back(t);
		v[t].push_back(f);
	}

	cin >> q;

	for (int i = 0; i < q; i++) {
		int f, t;
		cin >> f >> t;
		for (int i = 1; i < n + 1; i++) {
			visited[i] = -1;
		}

		v[f].push_back(t);
		v[t].push_back(f);

		bfs(1);

		for (int i = 1; i < n + 1; i++) {
			cout << visited[i] << " ";
		}

		cout << "\n";
	}
}
