#include<iostream>

using namespace std;

int n;
int arr[200000];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		arr[i] = a;
	}

	int st = -1;
	int ed = 0;
	int fta[10] = { 0, };
	
	fta[arr[0]]++;
	int ft = 1;
	int maxl = 1;
	int len = 1;

	while (st <= ed && ed < n) {
		if (ft <= 2) {
			if (maxl < len) {
				maxl = len;
	/*			cout << st << " " << ed << "\n";*/
			}

			ed++;
			if (ed == n)
				break;

			if (fta[arr[ed]] == 0) {
				ft++;
			}
			fta[arr[ed]]++;
			len++;
		}
		else {
			st++;
			fta[arr[st]]--;
			len--;
			if (fta[arr[st]] == 0) {
				ft--;
			}
		}
	}

	cout << maxl;

	return 0;
}
