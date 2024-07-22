#include <iostream>
#include <algorithm>

using namespace std;

int n;
int arr[10000] = { 0, };
int DP[10000] = { 0, };

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	DP[0] = arr[0];
	DP[1] = arr[0] + arr[1];
	DP[2] = max({arr[2] + arr[0], arr[2] + arr[1], DP[1]});

	for (int i = 3; i < n; i++) {
		// i 번째 선택
			// i-1 번째 선택
			// i-1 번째 선택 x
		// i 번째 선택 x

		int temp = max(arr[i] + arr[i - 1] + DP[i - 3], arr[i] + DP[i - 2]);

		DP[i] = max(temp , DP[i - 1]);
	}

	cout << DP[n-1];

}
