answer = [0, 0];

function solution(arr) {
  const end = arr.length;

  if (isSame(0, 0, end, end, arr)) {
    answer[arr[0][0]]++;
  } else {
    const mid = end / 2;
    dnq(0, 0, mid, mid, arr);
    dnq(0, mid, mid, end, arr);
    dnq(mid, 0, end, mid, arr);
    dnq(mid, mid, end, end, arr);
  }

  return answer;
}

// 범위 내 요소들이 모두 동일한 지 확인하는 함수
const isSame = (s_row, s_col, e_row, e_col, arr) => {
  const standard = arr[s_row][s_col];

  for (let i = s_row; i < e_row; i++) {
    for (let j = s_col; j < e_col; j++) {
      if (standard != arr[i][j]) {
        return false;
      }
    }
  }

  return true;
};

const dnq = (s_row, s_col, e_row, e_col, arr) => {
  if (e_row - s_row === 1) {
    answer[arr[s_row][s_col]]++;
    return;
  }

  if (isSame(s_row, s_col, e_row, e_col, arr)) {
    answer[arr[s_row][s_col]]++;
  } else {
    const mid_row = (s_row + e_row) / 2;
    const mid_col = (s_col + e_col) / 2;

    dnq(s_row, s_col, mid_row, mid_col, arr);
    dnq(s_row, mid_col, mid_row, e_col, arr);
    dnq(mid_row, s_col, e_row, mid_col, arr);
    dnq(mid_row, mid_col, e_row, e_col, arr);
  }
};
