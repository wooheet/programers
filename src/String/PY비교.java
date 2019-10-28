package String;

import java.util.Arrays;

/*
대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
예를들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.

 */
public class PY비교 {
    boolean solution(String s) {
//        String[] str = s.split("");
//        int pcount = 0;
//        int ycount = 0;
//        for (int i =0; i < s.length(); i++) {
//            if (str[i].equals("p") || str[i].equals("P")) {
//                pcount++;
//            }
//
//            if (str[i].equals("y") || str[i].equals("Y")) {
//                ycount++;
//            }
//        }
//        if (pcount == ycount) return true;
//        return false;

        s = s.toUpperCase();
        return s.chars().filter(c -> 'P' == c).count() == s.chars().filter(c -> 'Y' == c).count();
    }

    public static void main(String[] args) {
        String str = "ppyy";
        String str2 = "pyy";

        System.out.println(new PY비교().solution(str));
        System.out.println(new PY비교().solution(str2));
    }

}
