package basic;

import java.util.Arrays;

/**
 * [행렬회전]
 *  이미지를 표현하는 N * N 행렬
 *  이미지의 각 픽셀은 4바이트로 표현됩니다. 이미지를 90도 회전시키는 메소드를 작성
 *  행렬을 추가로 사용하지 않고서도 만들수 있습니까 ?
 *
 * [풀이]
 *  => 픽셀이 4바이트, int 배열
 *  => 일반화해서 규칙을 찾아야함
 *
 * */

public class 행렬로테이션 {
    /* main */
    public static void main(String[] args) {

        // == sample ==
        int[][] square = new int[][] {
                new int[] { 1, 2, 3 },
                new int[] { 4, 5, 6 },
                new int[] { 7, 8, 9 }
        };
        printSquare(square);
        System.out.println();

        // == 일반화공식처리 ==
        int[][] clone = rotateA(square);
        printSquare(clone);
        System.out.println();

        // == 케이스분류처리 ==
        rotateB(square);
        printSquare(square);
    }

    // == rotateA - 일반화공식처리 ==
    static int[][] rotateA(int[][] square) {
        int n = square.length;
        int[][] clone = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                clone[j][n-1-i] = square[i][j];
            }
        }

        return clone;
    }

    // == rotateB - 케이스분류처리 ==
    static int[][] rotateB(int[][] square) {
        if(square.length == 0 || square.length != square[0].length) return null;

        int n = square.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = square[first][i]; // 윗부분저장

                // 왼쪽 => 위쪽
                square[first][i] = square[last-offset][first];

                // 아래쪽 => 왼쪽
                square[last-offset][first] = square[last][last-offset];

                // 오른쪽 => 아래쪽
                square[last][last-offset] = square[i][last];

                // 위쪽 => 오른쪽
                square[i][last] = top;
            }
        }
        return null;
    }

    // == printSquare ==
    static void printSquare(int[][] square) {
        for (int i = 0; i < square.length; i++) {
            System.out.println(Arrays.toString(square[i]));
        }
    }

}
