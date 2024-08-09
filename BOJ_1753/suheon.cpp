#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int V, E;
int INF = int(1e9);

vector <pair<int,int>> info[20001];
int dist[20001];

void dijk(int s) {
	priority_queue <pair<int, int>> pq;

	pq.push({ 0,s });
	dist[s] = 0;

	while (!pq.empty()) {
		int now = pq.top().second;
		int cost = -(pq.top().first);
		pq.pop();

		if (dist[now] < cost) continue;

		for (int i = 0; i < info[now].size(); i++) {
			int next = info[now][i].second;
			int newCost = cost + info[now][i].first;

			if (dist[next] < newCost) continue;

			dist[next] = newCost;
			pq.push({ -newCost, next });
		}
	}
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int start;
	
	cin >> V >> E;
	cin >> start;
	
	for (int i = 0; i < E; i++) {
		int f, t, w;
		pair <int, int> p;
		cin >> f >> t >> w;
		p = make_pair(w, t);
		info[f].push_back(p);
	}

	for (int i = 1; i < V + 1; i++) {
		dist[i] = INF;
	}

	dijk(start);
	for (int i = 1; i < V+1; i++) {
		int x = dist[i];
		if (x == INF) {
			cout << "INF" << "\n";
		}
		else {
			cout << dist[i] << "\n";
		}
	}

	return 0;
}
