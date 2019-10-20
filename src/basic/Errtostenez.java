package basic;

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

        for (int i = 0; i < primes; i++) {
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int num = 10;
        new Errtostenez().solution(num);
    }
}
