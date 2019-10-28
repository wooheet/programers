package String;
/**
 * [유사문자열]

 *  문자열을 편집하는 방법에는 세가지가 있습니다.
 *  문자 삽입 / 문자 삭제 / 문자 교체
 *  문자열 2개가 주어졌을때 문자열을 같게 만들기 위한 편집 횟수가 1회 이내인지 확인하는 함수
 *
 * [풀이]
 *  => 케이스분류
 *  => 문자열 교체일 경우, 문자열의 갯수가 같아야
 *  => 문자열 추가일 경우, 변경할 문자열이 1개 적어야
 *  => 문자열 삭제일 경우, 변경할 문자열이 1개 많아야
 * */
public class checkSimilarity {

    public static boolean solution(String strA, String strB) {
        // 두 문자열 길이의 차이가 1 이내
        int count = 0;
        if (strA.length() - strB.length() == 0) {
            // 문자열변경
            for (int i = 0; i < strA.length(); i++) {
                if(strA.charAt(i) != strB.charAt(i)) {
                    if(count != 1)  count++;
                    else            return false;
                }
            }
        }
        else if(strA.length() - strB.length() == 1) {
            // 문자열삭제
            for (int i = 0; i < strB.length(); i++) {
                if(strA.charAt(count++) != strB.charAt(i)) {
                    if(count < strA.length()) {
                        if(strA.charAt(count++) != strB.charAt(i)) return false;
                    } else return false;
                }
            }
        }
        else if(strB.length() - strA.length() == 1) {
            // 문자열추가
            for (int i = 0; i < strA.length(); i++) {
                if(strB.charAt(count++) != strA.charAt(i)) {
                    if(count < strB.length()) {
                        if(strB.charAt(count++) != strA.charAt(i)) return false;
                    } else return false;
                }
            }
        } else return false;

        return true;
    }

    public static void main(String[] args) {

        System.out.println(solution("abc", "abc"));  // true
        System.out.println(solution("abc", "abb"));  // true
        System.out.println(solution("abc", "abcc")); // true
        System.out.println(solution("abc", "aabc")); // true
        System.out.println(solution("abc", "ac"));   // true
        System.out.println(solution("abc", "bc"));   // true
        System.out.println(solution("abc", "ab"));   // true
        System.out.println();
        System.out.println(solution("abc", "bbb"));  // false
        System.out.println(solution("abc", "a"));    // false
        System.out.println(solution("abc", "abcaa"));// false

    }
}
