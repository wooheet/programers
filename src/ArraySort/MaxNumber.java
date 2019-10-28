package ArraySort;

import java.util.Arrays;
/*
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
예를들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰수는 6210입니다.
0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어졌을 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 리턴 하도록 solution 함수를 작성해주세요.

 */
public class MaxNumber {
    public static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            arr[i] = String.valueOf(numbers[i]);

        Arrays.sort(arr, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));

        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();

        for (int i=0; i < arr.length; i++)
            sb.append(arr[i]);

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] num = new int[] {6, 10, 2};
        String sol = solution(num);
        System.out.println(sol);
    }
}
