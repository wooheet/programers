package StackQueue;

/*
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 */

import java.util.Arrays;
import java.util.HashMap;

public class Top {
    public int[] solution(int[] heights) {
        int towerNum = heights.length;
        int[] answer = new int[towerNum];

        for (int sender = towerNum -1; sender >0; sender--) {
            for (int receiver = 0; receiver < sender; receiver++) {
                if(heights[receiver] > heights[sender])
                    answer[sender] = receiver + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] participant = new String[] {"leo", "kiki", "eden"}, completion = new String[] {"kiki", "eden"};

    }
}
