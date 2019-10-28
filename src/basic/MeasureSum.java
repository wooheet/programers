package basic;

/*
자연수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

입출력 예 #1

12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.

 */
public class MeasureSum {

    public int solution(int num) {
        int answer = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                answer += i;
            }
        }
        System.out.println(answer);

        int answer2 = 0;
        // 자기 자신의 반 숫자보다 큰 약수는 없다.
        for(int i =1; i<=num/2; i++){
            answer2 += num%i==0 ? i : 0;
        }
        // 마지막 자기 자신도 약수이다.
        answer2 +=num;

        return answer;
    }

    public static void main(String[] args) {
        new MeasureSum().solution(12);
        new MeasureSum().solution(5);
    }
}
