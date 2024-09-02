#include <iostream>

using namespace std;

int N;
int arr[17][17];
int ans = 0;

int di[3] = {0,1,1};
int dj[3] = {1,0,1};

void dfs(int i, int j, int dir) {

    if (i == N && j == N) {
        ans++;
        return;
    }

    for (int k = 0; k < 3; k++) {
        if ((dir == 0 && k == 1) || (dir == 1 && k == 0)) continue; // 가로-세로, 세로-가로 변환 불가

        int ni = i + di[k];
        int nj = j + dj[k];

        if (ni > N || nj > N || arr[ni][nj] == 1) continue;

        if (k == 2 && (arr[i + 1][j] == 1 || arr[i][j + 1] == 1)) continue;

        dfs(ni, nj, k);
    }
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> N;
	for (int i = 1; i < N+1; i++) {
		for (int j = 1; j < N+1; j++) {
			cin >> arr[i][j];
		}
	}

	dfs(1,2,0);
	cout << ans;
	
}
