#include<iostream>
#include<algorithm>

using namespace std;

int n, m;
int arr[8];
int vis[8] = { 0, };

void func(int li[], int l, int r) {
	if (r == m) {
		for (int i = 0; i < m; i++) {
			cout << li[i] << " ";
		}
		cout << "\n";
		return;
	}

	if (l == n) {
		return;
	}

	for (int i = 0; i < n; i++) {
		if (vis[i] != 1) {
			vis[i] = 1;
			li[r] = arr[i];
			func(li, l + 1, r + 1);
			vis[i] = 0;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie();

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int lis[8];

	sort(arr, arr + n);

	func(lis, 0, 0);

	return 0;
}
