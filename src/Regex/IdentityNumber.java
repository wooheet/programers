package Regex;

public class IdentityNumber {
    public boolean solution(String s) {
        String regExp = "^\\[0-9]{2}(0[0-9]|1[0-2])(0[0-9]|[12][0-9]|[3][0-1])\\-[1-4][0-9]{6}$";
        return s.matches(regExp);
    }

    public static void main(String[] args) {
        String test = "900109-1852011";
        boolean r = new Username().solution(test);
        System.out.println(r);
    }
}
