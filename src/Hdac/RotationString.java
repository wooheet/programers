package Hdac;
/**
 * [문자열회전]
 *  한 단어가 다른 문자열에 포함되어 있는지 판변하는 isSubString이라는 메서드가 있다고 가정
 *  s1과 s2의 두 문자열이 주어졌고, s2가 s1을 회전시킨 결과인지 판별하고자함
 *  가령 waterbottle은 erbottlewat을 회전시켜서 얻을 수 있는 문자열
 *  isSubString 메소드를 한번만 호출해서 판별하는 코드를 작성 ( 한번만 잘라서 같은 문자열이 되는지 )
 *
 *[풀이]
 *  => 회전이란 의미를 명확히
 *  => [방법1] 두번의 패턴을 비교하는 방법
 *  => [방법2] 1번의 회전으로 같아진다면 문자열에 마지막에 갔을때 다시 처음으로 가면 문자열이 이어짐
 * */
public class RotationString {

    static boolean isRotateString(String strA, String strB) {
        if(strA.length() != strB.length()) return false;

//        int startB = 0;
//        int pointerA = 0;
//        int pointerB = 0;
//        while(startB != strB.length() && pointerA != strA.length()) {
//            if(strA.charAt(pointerA) == strB.charAt(pointerB)) {
//                pointerA++;
//                pointerB++;
//                if(pointerB >= strB.length()) pointerB = 0; // == 순환 ==
//            } else {
//                pointerA = 0;
//                pointerB = ++startB;
//            }
//        }
//
//        return pointerA == strA.length() ? true : false;


        char[] a = strA.toCharArray();
        char[] b = strB.toCharArray();

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < b.length - 1; j++) {
                if (a[i] == b[j]) {
                    String subB = strB.substring(j);
                    String frontSubB = strB.substring(0,j);
                    StringBuilder sb = new StringBuilder();
                    sb.append(subB);
                    sb.append(frontSubB);
                    if (sb.toString().equals(strA)) return true;

                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRotateString("waterbottle", "erbottlewat")); // true
        System.out.println(isRotateString("waterbottla", "waterbottle")); // false
        System.out.println(isRotateString("12345", "45123")); // true
        System.out.println(isRotateString("33123", "32331")); // false
        System.out.println(isRotateString("0", "0")); // false
    }
}
