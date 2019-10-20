package Bruteforce;

import java.util.Arrays;

public class Capet {
    public static int[] solution(int brown, int red) {
        for (int y = 3; y <= red + 2; y++) {
            for (int x = y; (x * 2) + ((y - 2) * 2) <= brown; x++) {
                if (( x - 2) * (y - 2) == red) {
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        int[] test = new Capet().solution(14,6);
        Arrays.stream(test).forEach(t -> System.out.println(t));
    }
}
