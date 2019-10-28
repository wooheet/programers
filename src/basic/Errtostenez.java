package basic;

import java.util.Arrays;

/*
소수찾기
 */
public class Errtostenez {
    public static int[] solution(int num) {
        int[] answer = new int[num];
        int primes = 0;
        boolean[] check = new boolean[num+1];

        for (int i = 2; i < num; i++) {
            if (!check[i]) {
                answer[primes] = i;
                primes++;
            }

            for (int j = i * i; j <= num; j +=i) {
                check[j] = true;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int num = 10;
        int[] result = new Errtostenez().solution(num);

        Arrays.stream(result).forEach(r -> System.out.print(r));
    }
}
