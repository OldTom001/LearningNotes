package RotatePicture;

public class RotatePicture {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
//        i表示行, j表示列
        for(int i = 0; i < len/2; i++) {
            for(int j = 0; j<(len+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-j-1][i];
                matrix[len-j-1][i] = matrix[len-i-1][len-j-1];
                matrix[len-i-1][len-j-1] = matrix[j][len-i-1];
                matrix[j][len-i-1] = temp;
            }
        }
    }
}
