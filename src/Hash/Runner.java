package Hash;

import java.util.HashMap;

/*
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 */
public class Runner {
    public static String solution(String[] participant, String[] completion){
        String answer ="";

        HashMap<String, Integer> hm = new HashMap<>();

        for (String name : participant)
            hm.put(name, hm.getOrDefault(name, 0) + 1); //찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.

        for (String name : completion)
            hm.put(name, hm.get(name) -1);

        for (String name : hm.keySet())
            if (hm.get(name) != 0){
                answer = name;
                break;
            }
        return answer;
    }

    public static void main(String[] args) {
        String[] participant = new String[] {"leo", "kiki", "eden"}, completion = new String[] {"kiki", "eden"};
        String sol = solution(participant, completion);
        System.out.println(sol);
    }
}
