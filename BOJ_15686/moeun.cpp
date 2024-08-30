#include<iostream>
#include<vector>
#define MAX_NUM 9999999

using namespace std;

int n;
int m;
int minp = MAX_NUM;

vector<pair<int, int>> chick;
vector<pair<int, int>> home;


// 거리 계산하는 함수
void func(vector<pair<int, int>> new_chi) {
	int cnt = 0;
	int h = home.size();

	
	for (int j = 0; j < home.size(); j++) {
		int h = home[j].first;
		int w = home[j].second;
		int mini = MAX_NUM;

		for (int i = 0; i < new_chi.size(); i++) {
			int x = new_chi[i].first;
			int y = new_chi[i].second;

			int r = abs(x - h) + abs(y - w);
			if (r < mini)
				mini = r;
		}

		cnt += mini;
		if (cnt >= minp) return;
	}
	
	if (cnt < minp)
		minp = cnt;

	return;
}

// 조합 구하는애
void comb(int l, int idx, vector<pair<int, int>> vec) {
	if (vec.size() == m) {
		func(vec);
		return;
	}

	for (int i = idx; i < l; i++) {
		vec.push_back(chick[i]);
		comb(l, idx + 1, vec);
		vec.pop_back();
	}

	return;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int num;
			cin >> num;

			if (num == 2)
				chick.push_back({ i, j });
			else if (num == 1)
				home.push_back({ i, j });
		}
	}

	vector<pair<int, int>> vec;

	comb(chick.size(), 0, vec);

	cout << minp;

	return 0;
}
