#include<iostream>
#include<vector>

using namespace std;

int n, ans;
int m;
int arr[1001][10];

int main() {
	cin >> n;

	// 탑다운해야될거같음
	// - 0123456789 합계
	// 1 0000000000  0

	// x로 시작하는 y자리수
	// 1 1 1 1 1 1 1 1 1 1 10
	// 10 9 8 7 6 5 4 3 2 1 55
	// 이상함

	// x로 끝나느게 맞을듯
	// 1 1 1 1 1 1 1 1 1 1     10
	// 1 2 3 4 5 6 7 8 9 10    55
	// 1 3 6 10
	// 
	// 000
	// 001 011 111
	// 002 012 022 112 122 222
	// 003 013 023 033 113 123 133 223 233 333

	for (int i = 0; i < 10; i++) {
		arr[0][i] = 1;
	}

	for (int i = 1; i < n; i++) {
		arr[i][0] = 1;

		for (int j = 1; j < 10; j++) {
			arr[i][j] = arr[i - 1][j] + arr[i][j-1];
			if (arr[i][j] > 10007) arr[i][j] %= 10007;
		}
	}

	m = 0;

	for (int i = 0; i < 10; i++) {
		m += arr[n - 1][i];
	}

	ans = m % 10007;
	
	//for (int i = 0; i < n; i++) {
	//	for (int j = 0; j < 10; j++) {
	//		cout << arr[i][j] << " ";
	//	}
	//	cout << endl;
	//}

	cout << ans;

	return 0;
}