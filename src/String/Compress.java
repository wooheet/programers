package String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [문자열압축]
 *  반복되는 문자의 개수를 세는 방식의 기본직인 문자열 압축 메서드를 작성
 *  [ex] aabcccaaa => a2b1c3a3
 *  만약 압축된 문자열의 길이가 문자열의 길이보다 길다면 기존 문자열을 반환
 *  문자열은 대소분자 알파벳으로만 이루어짐
 *
 * [풀이]
 *  => StringBuilder 이용 문자열 압축처리
 */


public class Compress {
    public void solution(String test) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        char[] s = test.toCharArray();
        int count = 1;

        for (int i = 0; i < s.length -1; i++) {
            if (s[i] == s[i+1]) {
                count ++;
                if (i+1 == s.length - 1) {
                    sb.append(s[i]);
                    sb.append(count);
                    count = 1;
                }
            } else {
                sb.append(s[i]);
                sb.append(count);
                count = 1;
            }
        }
        System.out.println(sb.toString());

        char now = s[0];
        for (int i = 1; i < s.length; i++) {
            if (now == s[i]) {
                count++;
            } else {
                sb2.append("" + now + count);
                now = s[i];
                count = 1;
            }
        }
        sb2.append("" + now + count);
        System.out.println(sb2.toString());
        String result = (sb.length() > test.length() ? test : sb.toString());


        //queue
        Queue q = new LinkedList();
        for (int i = 0; i < s.length; i++) {

        }

        //hashmap 중복 제거때문에 사용 불가
        HashMap<String, Integer> hm = new HashMap<>();


    }

    public static void main(String[] args) {
        String test = "aabcccaaa";
        new Compress().solution(test);
    }
}
