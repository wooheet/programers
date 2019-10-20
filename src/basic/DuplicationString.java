package basic;

import java.util.Arrays;

/**
 * [중복이없는가]
 *  문자열이 주어졌을때 이 문자열에 같은 문자가 중복되어 등장하는지 확인하는 알고리즘 작성
 *  자료구조를 사용하지 않고 풀 수 있는 알고리즘을 고민
 *
 * [풀이]
 *  => 문자열정렬
 *  => 앞뒤에같은문자가 나온다면 중복발생
 *
 * [추가사항]
 *  => 면접관에게 문자열이 ASCII 문자열인지 유니코드 문자열인지 물어 봐야한다.
 *  => 여기서는 간단하게 ASCII 문자열이라고 가정하면, 128개의 플래그로 처리할 수 있음
 * */

public class DuplicationString {

    /* main */
    public static void main(String[] args) {

        System.out.println(checkDuplicationA("abcdefg"));  // false
        System.out.println(checkDuplicationA("abcdefga")); // true
        System.out.println(checkDuplicationB("abcdefg"));  // false
        System.out.println(checkDuplicationB("abcdefga")); // true
    }

    /* ASCII 가정시 플래그값으로 푸는 방법  */
    static boolean checkDuplicationA(String str) {
        if(str.length() > 128) return false; // ASCII 가정
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(char_set[val]) {
                return true;
            }
            char_set[val] = true;
        }
        return false;
    }

    /* 유니코드시 가정시 정렬로 푸는 방법 */
    static boolean checkDuplicationB(String str) {

        // == split ==
        String[] strings = str.split("");

        // == sort ==
        Arrays.sort(strings);

        for(int i=0; i<strings.length-1; i++) {
            if(strings[i].equals(strings[i+1])) {
                return true;
            }
        }
        return false;
    }

}
