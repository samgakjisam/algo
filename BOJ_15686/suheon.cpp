#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

// 치킨 거리 = 집과 가장 가까운 치킨집 사이의 거리
// 도시의 치킨 거리 = 모든 집의 치킨 거리의 합

// 0은 빈칸, 1은 집, 2는 치킨집

int N, M; // NxN , 최대 치킨집 수 M개
vector <pair<int, int>> home;
vector <pair<int, int>> chicken;
vector <pair<int, int>> tmp; // 선택한 치킨 집 좌표

// bool visited[13] = { false, };

int min_dist = int(1e9);

// 조합
void com(int n, int c) {

	if (c == M) {
		// 합산 거리
		int dist = 0;
		for (int i = 0; i < home.size(); i++) {
			pair <int, int> p;
			p = home[i];
			// 선택된 치킨집 중 집에서 가장 가까운 것과의 거리
			int tmp_min = int(1e9);
			for (int j = 0; j < tmp.size(); j++) {
				pair <int, int> pp;
				pp = tmp[j];
				int d = abs(p.first - pp.first) + abs(p.second - pp.second);
				tmp_min = min(d, tmp_min);
			}
			dist += tmp_min;
			if (dist >= min_dist) {
				return;
			}
		}

		min_dist = min(dist, min_dist);
		return;
	}
	// 시간초과 이유 : 조합 똑바로 안해서
	for (int i = n; i < chicken.size(); i++) {
		//if (visited[i] == true) continue;
		tmp.push_back(chicken[i]);
		//visited[i] = true;
		com(i + 1, c + 1);
		tmp.pop_back();
		//visited[i] = false;
	}

}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			int t;
			cin >> t;
			if (t == 0) continue;
			if (t == 1) {
				home.push_back({ i,j });
			}
			else if (t == 2) {
				chicken.push_back({ i,j });
			}
		}
	}

	com(0,0);

	cout << min_dist;
}
