package String;

/*
문자열 s의 길이가 4혹은 6이고, 숫자로만 구성되있는지 확인해주는 함수, solution을 완성하세요.

예를들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
 */
public class CharCheck {

    public boolean solution(String s) {
        char[] c = s.toCharArray();

        if(s.length() == 4 || s.length() == 6) {
            try{
                Integer.parseInt(s);
                return true;
            } catch(NumberFormatException e){
                return false;
            }
        }
        else return false;

//        if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
//        return false;
    }

    public static void main(String[] args) {
        String test1 = "1234";
        String test6 = "a123";

//        String test2 = "12345";
//        String test3 = "123456";
//        String test4 = "a123456";
//        String test5 = "a23456";

        System.out.println(new CharCheck().solution(test1));
        System.out.println(new CharCheck().solution(test6));


//        new CharCheck().solution(test2);
//        new CharCheck().solution(test3);
//        new CharCheck().solution(test4);
//        new CharCheck().solution(test5);

    }
}
