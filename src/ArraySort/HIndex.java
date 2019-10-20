package ArraySort;

import java.util.Arrays;
import java.util.Collections;

/*
H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.

어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h가 이 과학자의 H-Index입니다.

citations	return
[3, 0, 6, 1, 5]	3

 */
public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int smaller = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, smaller);
        }

        return answer;
    }

    public static void main(String[] a) {
        int[] test = {1,7,0,1,6,4};
        int r = new HIndex().solution(test);
        System.out.println(r);
    }
}