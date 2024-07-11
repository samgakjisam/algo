#include <iostream>
#include <algorithm>

using namespace std;

int N;
int arr[1001] = { 0, };
int DP[1001] = { 0, };

int main() {

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
		DP[i] = 1;
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < i; j++) {
			if (arr[i] > arr[j]) {
				DP[i] = max(DP[i], DP[j] + 1);
			}
		}
	}
	sort(DP, DP+N);
	cout << DP[N - 1];
}
