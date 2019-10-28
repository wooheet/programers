package String;

import java.util.Arrays;

/**
 * [순열확인]
 *  문자열 두개가 주어졌을때 이 둘이 서로 순열 관계에 있는지 확인하는 메서드
 *
 * [풀이]
 *  => 순열이란, 문자열을 재조합해서 해당 문자열을 만들 수 있는가의 관계 ( god <=> dog 순열관계 )
 *  => 두 문자열을 정렬해서 같다면 순열관계
 *
 * [추가사항]
 *  => 문자열은 모두 아스키코드인가
 *  => 아스키코드라면 플래그를 만들어서 채우는 방식으로 비교
 *
 * */

public class 순열확인 {
    public static void main(String[] args) {
        System.out.println(checkPermutation("abc", "aaa"));
        System.out.println(checkPermutation("abc", "cba"));
    }


    /* checkPermutation - 유니코드 */
    static boolean checkPermutation(String strA, String strB) {
        if(strA.length() == strB.length()) {
            return sort(strA).equals(sort(strB));
        }
        return false;
    }

    /* sort */
    static String sort(String str) {
        // == 문자열 to char배열 ==
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
