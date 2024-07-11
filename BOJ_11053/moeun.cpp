#include<iostream>
#include<algorithm>

using namespace std;

int n;
int arr[1000];
int res[1000] = { 0, };

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		res[i] = 1;

		for (int j = i - 1; j >= 0; j--) {
			if (arr[j] < arr[i]) {
				res[i] = max(res[j] + 1, res[i]);
			}
		}
	}

	int ans = 0;
	for (int i = 0; i < n; i++) {
		if (ans < res[i]) {
			ans = res[i];
		}
	}

	cout << ans;

	return 0;
}
