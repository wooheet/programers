package DfsBfs;

import com.sun.deploy.panel.AbstractRadioPropertyGroup;

public class TargetNumber {

    static int ANSWER = 0;

    public int solution(int[] numbers, int target) {
        dfs(target, numbers, 0);
        return ANSWER;
    }

    public void dfs(int target, int[] numbers, int k) {
        if (k == numbers.length) {
            int sum = 0;
            for(int i=0; i<numbers.length; i++) {
                sum += numbers[i];
            }

            if (sum == target)
                ANSWER++;
            return;
        } else {
            numbers[k] *=1;
            dfs(target, numbers, k+1);

            numbers[k] *=-1;
            dfs(target, numbers, k+1);
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1,1,1,1,1};

        int result = new TargetNumber().solution(numbers, 3);
        System.out.println(result);
    }
}
