import java.lang.management.MemoryType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Method {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>();
//        List<List<Integer>> triangle = new ArrayList<>();
        if(rowIndex <=1) {
            for(int i = 0; i<rowIndex+1; i++) {
                result.add(1);
            }
            return result;
        }

        int[][] triangle = new int[rowIndex+1][rowIndex+1];
        triangle[0][0] = 1;
        triangle[1][0] = 1;
        triangle[1][1] = 1;
        for(int i = 2; i<rowIndex+1; i++) {
            triangle[i][0] = 1;
            for(int j = 1; j <= i; j++) {
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];

            }
            triangle[i][rowIndex] = 1;
        }
        for(int i = 0; i<rowIndex+1; i++) {
            result.add(triangle[rowIndex][i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Method m = new Method();
        m.getRow(3);
    }

}
