#include<iostream>
#define MAX_NUM 999999

using namespace std;

int n;
int arr[3];
int pre_max[3];
int pre_min[3];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n;

	for (int i = 0; i < 3; i++) {
		int number;
		cin >> number;
		arr[i] = number;
		pre_max[i] = number;
		pre_min[i] = number;
	}

	for (int i = 1; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> arr[j];
		}
		int new_max[3] = { -1, -1, -1 };
		int new_min[3] = { MAX_NUM, MAX_NUM, MAX_NUM };

		for (int j = 0; j < 3; j++) {
			for (int k = -1; k <= 1; k++) {
				int p = j + k;

				if (p < 0 || p > 2) continue;

				if (pre_max[p] + arr[j] > new_max[j]) {
					new_max[j] = pre_max[p] + arr[j];
				}

				if (pre_min[p] + arr[j] < new_min[j]) {
					new_min[j] = pre_min[p] + arr[j];
				}
				
			}
		}

		for (int j = 0; j < 3; j++) {
			pre_max[j] = new_max[j];
			pre_min[j] = new_min[j];
		}
	}

	int ansmax = -1;
	int ansmin = MAX_NUM;
	
	for (int j = 0; j < 3; j++) {
		if (ansmax < pre_max[j]) ansmax = pre_max[j];
		if (ansmin > pre_min[j]) ansmin = pre_min[j];
	}

	cout << ansmax << " " << ansmin;

	return 0;
}
