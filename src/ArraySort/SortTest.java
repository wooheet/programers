package ArraySort;


public class SortTest {
    private static final int[] ARR_INT = new int[]{39, 3, 5, 81, 11, 20, 19,
            4, 3, 20, 1};
    private static final String[] ARR_STR = {"ab", "_123", "125", "한글", "#",
            "AB", "String", "my", "test"};

    public static void main(String[] args) {

        SortTest test = new SortTest();
        test.sortInteger();
        test.sortString();
    }

    /**
     * 숫자형 배열의 정렬 ARR_INT를 오름차순으로 정렬하여 화면에 출력
     */
    public void sortInteger() {
        int t = 1;
        for (int i = 0; i < ARR_INT.length; i++) {
            boolean changed = false;

            for (int j = 0; j < ARR_INT.length - 1 - i; j++) {
                if (ARR_INT[j] > ARR_INT[j + 1]) {
                    int temp = ARR_INT[j];
                    ARR_INT[j] = ARR_INT[j + 1];
                    ARR_INT[j + 1] = temp;
                    changed = true;
                }
            }
            for (int k = 0; k < ARR_INT.length; k++)
                if (t == 11)
                    System.out.println(ARR_INT[k]);
            t++; // t의 값이 11이 되었을때 ARR_INT[k] 배열의 값
            // 11번 배열의 갯수만큼 돈것중에 최종 모두 정렬된 값의 ARR_INT[k] 값을 출력
            if (!changed)
                break;
        }
        System.out.println();
    }

    /**
     * 문자형 배열의 정렬 ARR_STR을 내림차순으로 정렬하여 화면에 출력
     */
    public void sortString() {

        for (int i = 0; i < ARR_STR.length; i++) {
            boolean changed = false;

            for (int j = i + 1; j < ARR_STR.length; j++) {
                if ((ARR_STR[i].compareTo(ARR_STR[j])) < 0) {
                    String temp = ARR_STR[j];
                    ARR_STR[j] = ARR_STR[i];
                    ARR_STR[i] = temp;
                    changed = true;
                }
            }
            System.out.println(ARR_STR[i]);
            if (!changed)
                break;
        }
    }
}
