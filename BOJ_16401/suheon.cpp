#include <iostream>

using namespace std;

int M;
int N;
int arr[1000000] = { 0, };
int ans = 0;

int f(int mid) {

	int num = 0;

	for (int i = 0; i < N; i++) {
		num = num + (arr[i] / mid);
	}

	return num;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> M >> N;
	
	int max_v = 0;
	
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
		if (max_v < arr[i]) max_v = arr[i];
	}

	int left = 1;
	int right = max_v;
	int mid;

	while (left <= right) {
		
		mid = (left + right) / 2;
		
		if (f(mid) >= M) {
			left = mid+1;
			if (ans < mid) ans = mid;
		}
		else {
			right = mid-1;
		}
	}

	cout << ans;
}
