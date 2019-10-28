package basic;

public class 최대최소공배수 {

    public void solution(int a, int b) {
        //최소공배수
        int result = gcd(a,b);
        System.out.println(result);
        //최대공배수
        System.out.println(a * b / gcd(a,b));
    }

    public int gcd(int a, int b) {
        while(b!=0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        new 최대최소공배수().solution(100, 12);
    }
}
