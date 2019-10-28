package basic;

 /* [0행렬]
         *  M * N 행렬의 한 원소가 0일 경우
         *  해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 작성
         *
         * [풀이]
         *  => 스캔하며 문자열이 0인 것을 찾음
         *      => 찾음과 동시에 요청사항을 처리하면
         *      => 후반부에 처리에 의해서 원하지 않은 "0"이 발생할 수 있음
         *  => 찾아진 0에 대해서 요청사항을 처리해줌
         *
         * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSquare {
    /* main */
    public static void main(String[] args) {

        // == sample ==
        int[][] square = new int[][] {
                new int[] { 1, 2, 1, 3, 1 },
                new int[] { 4, 5, 0, 6, 1 },
                new int[] { 7, 8, 1, 9, 1 },
                new int[] { 7, 8, 1, 9, 0 }
        };
        printSquare(square); // @Test
        System.out.println();

        setZero(square);
        printSquare(square); // @Test
    }

    /* setZero */
    static void setZero(int[][] square) {
        int m = square.length;
        int n = square[0].length;
        List<int[]> bucket = new ArrayList<>(m * n);

        // == findZero ==
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(square[i][j] == 0) {
                    bucket.add(new int[] {i, j});
                }
            }
        }

        // == setZero ==
        for (int i = 0; i < bucket.size(); i++) {
            int[] point = bucket.get(i);
            for (int j = 0; j < m; j++) {
                square[j][point[1]] = 0;
            }
            for (int j = 0; j < n; j++) {
                square[point[0]][j] = 0;
            }
        }
    }

    /* printSquare */
    static void printSquare(int[][] square) {
        for (int i = 0; i < square.length; i++) {
            System.out.println(Arrays.toString(square[i]));
        }
    }
}
