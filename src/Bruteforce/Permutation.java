package Bruteforce;

import java.util.HashSet;
import java.util.Set;

/*
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 */

/*
중복이 없는 조합을 구하는 방법
우선 1,2,3 구슬이 있습니다.
3개중에 2개를 뽑는다고 했을때, 모든 경우의 수는 다음과 같습니다.
1,2
1,3
2,1
2,3
3,1
3,2
총 6가지 입니다. 팩토리얼 개념으로 접근하면 3*2 = 6 가지임을 알 수 있습니다.

이제 여기서 중복을 제거한 경우의 수만 따진다면,
1,2
1,3
2,3
총 3가지 입니다. 이를 조합이라고 합니다. 수학적인 기호로 나타내면! nCr 입니다.

중복이 없고, 순서도 없는 경우의 수(조합) = nCr

재귀함수의 특징을 이용하여, 모든 경우의 수를 다 탐색하도록 하겠습니다.(=백트래킹 개념)

 */
public class Permutation {
    private boolean[] prime() {
        boolean[] primes = new boolean[10000000];
        primes[0] = true;
        primes[1] = true;
        for(int i = 2; i < primes.length; i++) {
            if(!primes[i]) {
                for(int j = 2; j * i < primes.length; j++) {
                    primes[j * i] = true;
                }
            }
        }

        return primes;
    }
    // r: n개중 r개 뽑기
    private void permutation(Set<Integer> set, int[] arr, int index, int r){
        if(index == r){
            set.add(createInteger(arr, r));
        } else {
            for(int i = 0; i + index < arr.length; i++){
                swap(arr, index, index + i);
                permutation(set, arr, index + 1, r); // 재귀적으로 호출
                swap(arr, index, index + i);
            }
        }
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int createInteger(int[] arr, int r) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++)
            sb.append(arr[i]);

        return Integer.parseInt(sb.toString());
    }

    public int solution(String numbers) {
        int answer = 0;

        // int array로 바꿈
        int[] arr = new int[numbers.length()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }

        // 중복 허용 안함
        Set<Integer> set = new HashSet<>();
        for(int r = 1; r <= arr.length; r++) {
            permutation(set, arr, 0, r);
        }

        boolean[] primes = prime();
        for(int num : set) {
            answer = primes[num] ? answer : answer + 1;
        }

        System.out.println("count: " + answer);
        return answer;
    }

    public static void main(String[] args) {
        new Permutation().solution("12345");
//        new Permutation().solution("011");
//        new Permutation().solution("17");
//        new Permutation().solution("123");
//        new Permutation().solution("11");
//        new Permutation().solution("33");
    }
}
