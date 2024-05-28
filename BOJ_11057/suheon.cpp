#include <iostream>

using namespace std;

// 0 ~ 9 , 10 ~ 99 , 100 ~ 999 ...

int main() {

	int num = 0;
	long long ans = 0;
	long long arr[1002][10] = { 0, };

	for (int i = 0; i < 1001; i++) {
		for (int j = 0; j < 10; j++) {
			arr[i][j] = 1;
		}
	}

	cin >> num;

	for (int i = 2; i < num+2; i++) {
		long long temp = 0;
		ans = 0;
		
		// 다 더해서 다음 행의 첫 번째 열로 보내기
		for (int j = 0; j < 10; j++) {
			
			temp += arr[i - 1][j];
			ans += arr[i - 1][j];
		}

		arr[i][0] = temp;
		
		// 이전 행에서 빼기
		for (int j = 1; j < 10; j++) {
			arr[i][j] = arr[i][j - 1] - arr[i - 1][j - 1];
		}
	}

	cout << ans;
}