#include<iostream>
#include<queue>

using namespace std;

int k;
int arr[6] = { 0, };

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> k;
	// w = 가장 긴 가로길이
	// h = 가장 긴 세로길이
	// mw = 파인곳의 가로길이
	// mh = 파인곳의 세로길이
	// x = 가장 긴 가로축의 인덱스 번호
	// y = 가장 긴 세로축의 인덱스 번호
	int w, h, mw, mh, x, y;
	w = h = 0;

	for (int i = 0; i < 6; i++) {
		int a, b;

		cin >> a >> b;

		arr[i] = b;

		// 가장 긴 변 찾아주기
		if (a == 1 || a == 2) {
			if (w < b) {
				x = i;
				w = b;
			}
		}
		else {
			if (h < b) {
				y = i;
				h = b;
			}
		}
	}

	// 밭이 파여있는 위치는 가장 긴 가로변, 가장긴 세로변이 만나는 점의 반대편
	// -> 가장긴변의 양옆 변의 길이확인
	
	// ny = x와 만나는 두 변중 y가 아닌쪽
	// nx = y와 만나는 두 변중 x가 아닌쪽
	int nx, ny;

	if ((x + 1) % 6 == y) {
		ny = (x + 5) % 6;
		nx = (y + 1) % 6;
	}
	else {
		ny = (x + 1) % 6;
		nx = (y + 5) % 6;
	}

	mw = w - arr[nx];
	mh = h - arr[ny];


	int ans = (w * h - mw * mh) * k;

	//cout << x << " " << nx << " " << y << " " << ny << "\n";
	//cout << w << " " << mw << " " << h << " " << mh << "\n";
	cout << ans;

	return 0;
}
