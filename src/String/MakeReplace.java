package String;

/**
 * [문자열변경]
 *  문자열에 들어 있는 모든 공백을 '%20'으로 바꿔 주는 메소드를 작성
 *  최종적으로 모든 문자르 다 담을 수 있는 만큼 충분한 공간이 이미 확보되어 있으며
 *  문자열의 최종길이가 함께 주어진다고 가정해도 된다.
 *
 * [풀이]
 *  => replace를 사용하지 말것
 *  => StringBuilder를 사용할 수 있는가 ?
 *      => 문자열을 앞에서 부터 순회하며 StringBuilder로 조건에 맞게 이동
 *  => 사용할 수 없다면
 *      => 미리 변경될 문자열 크기의 배열을 만들어서 삽입
 *
 * */

public class MakeReplace {

    /* main */
    public static void main(String[] args) {

        String helloworld = "h e l l o w o r l d ! ! !";
        System.out.println(replaceA(helloworld));
        System.out.println(replaceB(helloworld));
    }

    /* replaceA - StringBuilder를 사용하지 않는 방법  */
    static String replaceA(String target) {
        char[] str = target.toCharArray();
        int trueLength = target.length();
        int spaceCount = 0, index, i = 0;

        // == 공백파악 ==
        for (i = 0; i < trueLength; i++) {
            if(str[i] == ' ') {
                spaceCount++;
            }
        }

        // == 필요공간 ==
        index = trueLength + spaceCount * 2;
        char[] newStr = new char[index];

        // == 공간변환 ==
        if( trueLength < str.length) str[trueLength] = '\0'; // 배열의끝
        for (i = trueLength - 1; i >= 0; i--) {
            System.out.println(str[i]);
            if(str[i] == ' ') {
                newStr[index - 1] = '0';
                newStr[index - 2] = '2';
                newStr[index - 3] = '%';
                index = index - 3;
            } else {
                newStr[index - 1] = str[i];
                index--;
            }
        }

        return new String(newStr);
    }

    /* replaceB - StringBuilder 사용방법 */
    static String replaceB(String target) {
        char[] arr = target.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
