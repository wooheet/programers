package basic;

import java.util.Arrays;

/*
별이는 헬로월드텔레콤에서 고지서를 보내는 일을 하고 있습니다. 개인정보 보호를 위해 고객들의 전화번호는 맨 뒷자리 4자리를 제외한 나머지를 "*"으로 바꿔야 합니다.
전화번호를 문자열 s로 입력받는 hide_numbers함수를 완성해 별이를 도와주세요
예를들어 s가 "01033334444"면 "*******4444"를 리턴하고, "027778888"인 경우는 "*****8888"을 리턴하면 됩니다.
 */
public class 핸드폰번호가리기 {
    public void solution(String s) {
        String[] strings = s.split("");

        for (int i = 0; i < strings.length - 3; i++) {
            String temp = s.replace(strings[i], "*");
        }

        String endpoint = s.substring(s.length() - 4, s.length());

        String test = "******";

        System.out.println(test + endpoint);

        System.out.println(s);
    }

    public static void main(String[] args) {

        new 핸드폰번호가리기().solution("01020392819");

    }
}
