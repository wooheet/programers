package basic;

import java.util.Arrays;

/*
array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.

divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 */
public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
//        int[] answer = new int[arr.length];
//        int count = 1;
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] % divisor == 0) {
//                answer[i] = arr[i];
//                count++;
//            }
//        }
//
//        if (count == 1) {
//            answer[0] = -1;
//        }
//        Arrays.sort(answer);
//        return answer;

        int[] answer = new int[1];
        int[] ret = Arrays.stream(arr).filter(num -> num % divisor == 0).toArray();

        if(Arrays.stream(ret).count() == 0) {
            answer[0] = -1;
        } else {
            answer = ret;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 9, 7, 10};
        int divisor = 5;

        int[] arr2 = new int[]{2, 36, 1, 3};
        int divisor2 = 1;

        int[] arr3 = new int[]{3,2,6};
        int divisor3 = 10;

        int[] result = new 나누어떨어지는숫자배열().solution(arr, divisor);
        int[] result2 = new 나누어떨어지는숫자배열().solution(arr2, divisor2);
        int[] result3 = new 나누어떨어지는숫자배열().solution(arr3, divisor3);

        Arrays.stream(result).forEach(i -> System.out.print(i));
        System.out.println();
        Arrays.stream(result2).forEach(i -> System.out.print(i));
        System.out.println();
        Arrays.stream(result3).forEach(i -> System.out.print(i));
    }
}
