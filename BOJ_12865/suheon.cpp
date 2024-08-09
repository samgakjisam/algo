#include <iostream>
#include <vector>

using namespace std;

int n, k, w, v;
vector <pair<int, int>> info;

// i : 물건 / j : 무게  / dp[i][j] = i번째 물건까지 고려했을 때, 무게가 j인 배낭의 최대 가치
int dp[101][100001] = { 0, };

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> k;

	info.push_back({ 0,0 });

	for (int i = 0; i < n; i++) {
		// 무게, 가치
		cin >> w >> v;
		info.push_back({ w,v });
	}

	for (int i = 1; i < info.size(); i++) {
		// i번째 물건
		int weight = info[i].first;
		int value = info[i].second;

		for (int j = 1; j < k + 1; j++) {
			if (j >= weight) dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight] + value);
			else dp[i][j] = dp[i - 1][j];
		}
	}

	cout << dp[n][k];
}
