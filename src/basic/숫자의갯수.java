package basic;

/*
세 개의 자연수를 입력받아 곱한 결과에서

0부터 9까지 숫자가 각각 몇 번 쓰였는지 출력

 */
public class 숫자의갯수 {
    public static void main(String[] args) {
        int A = 30;
        int B = 10;
        int C = 20;

        int[] counts = new int[10];
        int number = A * B * C;

        System.out.println(number);
        while (number > 0) {
            counts[number % 10]++;
            number /= 10;
        }

        for (int i = 0; i < counts.length; ++i) {
            System.out.print(counts[i]);
        }
    }
}
