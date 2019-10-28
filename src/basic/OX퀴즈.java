package basic;

import java.util.LinkedList;

/*
"OOXXOXXOOO" 와 같은 OX 퀴즈 결과가 T개 주어짐

문제를 맞은 경우 그 문제까지 맞은 개수가 그 문제의 점수가 됨

위 예의 경우 1+2+0+0+1+0+0+1+2+3 = 10 이 됨

각 테스트 케이스의 점수를 출력
 */
public class OX퀴즈 {

    public void solution(String str) {

        String[] s = str.split("");

        LinkedList<String> list = new LinkedList<>();
        int[] answer = new int[s.length];

        int count = 1;
        list.add(s[0]);

        for (int i = 1; i < s.length; i ++) {
            if (s[i].equals(list.getLast()) && s[i].equals("O")) {
                count++;
            }
        }



//        str.chars().filter(c -> 'O' == c).count();
//        System.out.println(str.chars().filter(c -> 'O' == c).count());

    }

    public static void main(String[] args) {
        new OX퀴즈().solution("OOXXOXXOOO");
    }
}
