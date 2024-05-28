/*
이분탐색
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector <int> v;

int main() {

	// 시간 초과 방지
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int N = 0;
	cin >> N;

	for (int i = 0; i < N; i++) {
		int tmp = 0;
		cin >> tmp;
		v.push_back(tmp);
	}

	sort(v.begin(), v.end());
	
	int M = 0;
	cin >> M;

	for (int i = 0; i < M; i++ ) {
		int target = 0;
		int ans = 0;
		int left = 0;
		int right = N - 1;

		cin >> target;
		while (left <= right) {

			int mid = (left + right) / 2;

			if (v[mid] < target) {
				left = mid + 1;
			}
			else if (v[mid] > target) {
				right = mid - 1;
			}
			else {
				ans = 1;
				break;
			}
		}
		cout << ans << "\n";
	}
}