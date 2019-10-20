package Bruteforce;

import java.util.Stack;

/*
숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를

불러서 결과를 확인합니다. 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.

 * 숫자는 맞지만, 위치가 틀렸을 때는 볼

 * 숫자와 위치가 모두 맞을 때는 스트라이크

예를 들어, 아래의 경우가 있으면

A : 123
B : 1스트라이크 1볼.

A : 356
B : 1스트라이크 0볼.

A : 327
B : 2스트라이크 0볼.

A : 489
B : 0스트라이크 1볼.
이때 가능한 답은 324와 328 두 가지입니다.
 */
public class BaseBallNumber {
    public static int solution(int[][] baseball) {
        Stack<String> stack = new Stack<>();
        for(int i = 1; i < 10; i++) {
            for(int j = 1; j < 10; j++) {
                for(int k = 1; k < 10; k++) {
                    if(i != j && j != k && i != k) {
                        stack.add(String.valueOf(i * 100 + j * 10 + k));
                    }
                }
            }
        }
        Stack<String> temp = new Stack<>();
        boolean flag = true;
        while(!stack.isEmpty()) {
            String num = stack.pop();
            for(int i = 0; i < baseball.length && flag; i++) {
                int strike = strike(num, String.valueOf(baseball[i][0]));
                int ball = ball(num, String.valueOf(baseball[i][0])) - strike;
                if(strike != baseball[i][1] || ball != baseball[i][2]) {
                    flag = false;
                }
            }
            if(flag) {
                temp.add(num);
            }
            flag = true;
        }
        return temp.size();
    }

    public static int strike(String num, String target) {
        int cnt = 0;
        for(int i = 0; i < target.length(); i++) {
            cnt = num.charAt(i) == target.charAt(i) ? cnt + 1 : cnt;
        }
        return cnt;
    }

    public static int ball(String num, String target) {
        int cnt = 0;
        for(int i = 0; i < target.length(); i++) {
            cnt = num.contains(String.valueOf(target.charAt(i))) ? cnt + 1 : cnt;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] baseball = new int[][] {{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
        int sol = solution(baseball);
        System.out.println(sol);
    }
}
