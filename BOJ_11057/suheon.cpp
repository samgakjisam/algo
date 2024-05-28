#include <iostream>

using namespace std;

// 0 ~ 9 , 10 ~ 99 , 100 ~ 999 ...

int main() {

	int num = 0;
	int ans = 0;
	int arr[1001][10] = { 0, };
	cin >> num;

	for (int i = 0; i < 10; i++) {
		arr[1][i] = i+1;
	}

	for (int i = 2; i < num+1; i++) {
		for (int j = 0; j < 10; j++) {
			if (j == 0) {
				arr[i][j] = 1;
				continue;
			}
			arr[i][j] = (arr[i][j - 1] + arr[i - 1][j]) % 10007;
		}
	}


	cout << arr[num][9];
}