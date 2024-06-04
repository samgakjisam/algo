// int는 2^31-1까지 => 오버플로우 방지하려면 unsigned int 써야함

#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N = 0;
	int K = 0;
	int arr[10000] = { 0, };

	cin >> K >> N;

	// 가장 긴 랜선
	int max = 0;

	for (int i = 0; i < K; i++) {
		cin >> arr[i];
		if (arr[i] >= max) max = arr[i];
	}

	unsigned int left = 1;
	unsigned int right = max;
	unsigned int mid = 0;
	unsigned int ans = 0;

	while (left <= right) {
		mid = (left + right) / 2;

		unsigned int sum = 0;

		// 개수 구하기
		for (int i = 0; i < K; i++) {
			sum += arr[i] / mid;
		}

		// 개수가 N보다 크거나 같으면 답 저장하고 길이 늘리기
		if (sum >= N) {
			if (mid >= ans) ans = mid;
			left = mid + 1;
		}
		// 길이 줄이기
		else {
			right = mid - 1;
		}
	}

	cout << ans << '\n';
}
