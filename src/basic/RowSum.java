package basic;

import com.sun.rowset.internal.Row;

import java.util.Arrays;

public class RowSum {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};

        answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        System.out.println(answer);
        Arrays.stream(answer).forEach(System.out::print);

        return answer;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2},{3,4}};
        int[][] b = {{1,2},{3,4}};

        new RowSum().solution(a,b);
    }
}
