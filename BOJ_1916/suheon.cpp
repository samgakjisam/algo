#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M;
	cin >> N >> M;
	
	int INF = 2112345678;


	// 0,0으로 전부 초기화됨
	vector<pair<int, int>> arr[1001];

	int distance[1001] = { 0, };

	for (int i = 1; i < 1001; i++) {
		distance[i] = INF;
		//cout << arr[i].first << " " << arr[i].second << "\n";
	}
	
	for (int i = 0; i < M; i++) {
		int from, to, cost;
		cin >> from >> to >> cost;
		pair <int,int> tmp = make_pair(cost, to);
		arr[from].push_back(tmp);
	}

	//for (int i = 1; i < 1001; i++) {
	//	distance[i] = INF;
	//	for (int j = 0; j < arr[i].size(); j++) {
	//		cout << arr[i][j].first << " " << arr[i][j].second << " // ";
	//	}
	//	cout << "\n";
	//}

	int start, end;
	cin >> start >> end;

	priority_queue <pair<int, int>> pq;
	pq.push({ 0,start });
	distance[start] = 0;

	while (!pq.empty()) {
		int cost = -pq.top().first;
		int now = pq.top().second;
		pq.pop();

		if (distance[now] < cost) continue;

		for (int i = 0; i < arr[now].size(); i++) {
			int next = arr[now][i].second;
			int newCost = cost + arr[now][i].first;
			if (distance[next] > newCost) {
				distance[next] = newCost;
				pq.push(make_pair(-newCost, next));
			}
		}
	}
	cout << distance[end] << "\n";

}
