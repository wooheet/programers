package Hdac;

public class First {

    public int solution(String number) {
        int result = 0;
        char[] strings = number.toCharArray();

        for (int i = 0; i < strings.length - 1; i++) {
            int parseInt = strings[i] - 48;
            result = parseInt * 10;

        }

        return result;
    }

    public static void main(String[] args) {
        int test = new First().solution("12345");
        System.out.println(test);
    }

}
