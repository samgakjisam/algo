class Solution {
    static int zero = 0;
    static int one = 0;
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        divide(arr, 0, 0, arr.length, arr.length);
        
        answer[0] = zero;
        answer[1] = one;
        
        return answer;
    }
    
    static void divide(int[][] arr, int startX, int startY, int endX,           int endY) {
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (arr[i][j] != arr[startX][startY]) {
                    int midX = (startX + endX) / 2;
                    int midY = (startY + endY) / 2;
                    divide(arr, startX, startY, midX, midY);
                    divide(arr, startX, midY, midX, endY);
                    divide(arr, midX, startY, endX, midY);
                    divide(arr, midX, midY, endX, endY);
                    return;
                }
            }
        }
        if (arr[startX][startY] == 0) {
            zero++;
        } else {
            one++;
        }
    }
}
