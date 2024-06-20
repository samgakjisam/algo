#include <iostream>

using namespace std;

void init(int M, int N, int x, int y) {
	int ans = -1;
	int diff = M - N;
	int cnt = 0;
	int tmp = x;
	while (1) {
		// 답 찾으면
		if (tmp == y) {
			// 계산
			ans = x + cnt * M;
			break;
		}
		// 다음 줄
		tmp = tmp + diff;
		if (diff < 0) {
			if (tmp <= 0) {
				tmp = N + tmp;
			}
		}
		else {
			tmp = tmp % N;
		}
		cnt++;

		// 답 못찾으면
		if (tmp == x) break;
	}
	
	cout << ans << "\n";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		int x, y, M, N;
		cin >> M >> N >> x >> y;
		init(M, N, x, y);
	}

}
