#include<iostream>
#include<queue>

using namespace std;

int n, m, s, e;
long long bus[1001][1001];
long long vis[1001];
priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> pq;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		vis[i] = -1;
		for (int j = 1; j <= n; j++) {
			bus[i][j] = -1;
		}
	}

	for (int i = 0; i < m; i++) {
		int a, b;
		long long c;
		cin >> a >> b >> c;
		if (bus[a][b] > c || bus[a][b] == -1)
			bus[a][b] = c;
	}
	cin >> s >> e;

	vis[s] = 0;

	for (int i = 1; i <= n; i++) {
		long long fee = bus[s][i];
		if (fee > -1) {
			pq.push({ fee, i });
		}
	}

	while (!pq.empty()) {
		long long f = pq.top().first;
		int t = pq.top().second;
		pq.pop();

		if (f < vis[t] || vis[t] == -1) {
			vis[t] = f;
		}

		//for (int i = 1; i <= n; i++) {
		//	cout << vis[i] << " ";
		//}
		//cout << "\n";
		
		for (int i = 1; i <= n; i++) {
			long long fee = bus[t][i];
			if (t != i && fee > -1 && (fee + f < vis[i] || vis[i] == -1)) {
				pq.push({ fee + f, i });
				vis[i] = fee + f;
			}
		}
	}

	cout << vis[e];

	return 0;
}
