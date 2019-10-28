package Regex;
/*
소문자. 숫자. _-포함
3글자 이상 16글자 이하
 */
public class Username {
    public boolean solution(String s) {
        String regExp = "^[a-z0-9_-]{3,16}$";
        return s.matches(regExp);
    }

    public static void main(String[] args) {
        String test = "efef1123";
        boolean r = new Username().solution(test);
        System.out.println(r);
    }
}
