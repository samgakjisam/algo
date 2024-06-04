#include<iostream>

using namespace std;

int n, k;
long long lt;
long long arr[10000];

bool length_check(long long l) {
	int cou = 0;
	for (int i = 0; i < k; i++) {
		cou += arr[i] / l;
	}
	//cout << l << " " << cou << "\n";

	if (cou >= n)
		return true;
	return false;
}

long long find_length(long long m, long long l) {
	while (m < l) {
		long long mid = (m + l) / 2;
		if (length_check(mid)) {
			m = mid;
		}
		else {
			l = mid;
		}

		if (l == m + 1) { // m보다 l이 1더 클떈 무한루프 돌수있음
			if (length_check(l)) {
				m = l;
				break;
			}
			else {
				l = m;
				break;
			}
		}
	}

	return l;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	cin >> k >> n;

	lt = 0;

	for (int i = 0; i < k; i++) {
		long long a;
		cin >> a;
		arr[i] = a;

		if (a > lt) { // 최대길이부터 탐색시작
			lt = a;
		}
	}


	if (length_check(lt)) //최대길이로 바로 적용될때
		cout << lt;
	else
		cout << find_length(1, lt); //안되면 이분탐색 시작

	return 0;
}
