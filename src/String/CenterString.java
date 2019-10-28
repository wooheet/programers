package String;

public class CenterString {
    public String solution(String s) {
        String answer = "";

        if (s.length() % 2 != 0) {
            answer = answer + s.charAt(s.length() / 2);
        } else {
            answer = answer + s.charAt(s.length() / 2 - 1) + s.charAt(s.length() / 2);
        }

        System.out.println(answer);

        s = s.substring((s.length()-1)/2, s.length()/2 + 1);
        System.out.println(s);
        return answer;
    }

    public static void main(String[] args) {
        String test = "tests";
        String test2 = "tests2";
        new CenterString().solution(test2);
    }
}
