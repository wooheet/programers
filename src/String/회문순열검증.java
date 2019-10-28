package String;
/**
 * [회문순열]
 *  주어진 문자열이 회문의 순열이지 아닌지 확인하는 함수
 *  주어진 문자열이 재배치를 통해서 회문이 되는 문자열인지 아닌지 판단하는 함수
 *
 * [풀이]
 *  => 회문이란 ? 앞으로 읽으나 뒤로 읽으나 같은 단어 혹은 구절을 의미
 *  => 순열이란 ? 문자열을 재배치하는 말함
 *  => * 결국 각각의 문자열이 모두 짝수개 거나 1개만이 홀수여야 함
 *
 * [추가사항]
 *  => 아스키코드에 한해 알파벳만 처리하도록 하겠습니다.
 * */

public class 회문순열검증 {
    public static void main(String[] args) {
        System.out.println(Character.getNumericValue(' ')); // -1
        System.out.println(Character.getNumericValue('a')); // 10
        System.out.println(Character.getNumericValue('A')); // 10
        System.out.println(Character.getNumericValue('z')); // 35
        System.out.println(Character.getNumericValue('Z')); // 35

        System.out.println(checkPalindrome("abaaba")); // true
        System.out.println(checkPalindrome("ababaa")); // true
        System.out.println(checkPalindrome("abaaca")); // false

    }

    /* checkPalindrome - 실행함수 */
    static boolean checkPalindrome(String str) {
        int[] table = getCharTable(str);
        return checkMaxOneOdd(table);
    }

    /* 각 문자가 몇 번 등장했는지 */
    static int[] getCharTable(String str) {
        // == 알파벳한정 ==
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for( char c : str.toCharArray() ) {
            int x = getCharNumber(c);
            if(x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    /* 각각 문자에 숫자를 대음 */
    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if( a <= val && val <= z) {
            return val - a; // == index에 맞게 앞으로 당김 ==
        }
        return -1;
    }

    /* 홀수문자가 한개 이상 존재하는지 */
    static boolean checkMaxOneOdd(int [] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if(count%2 == 1) {
                if(foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }
}
