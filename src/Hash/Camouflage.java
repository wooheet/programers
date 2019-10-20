package Hash;

import java.util.HashMap;

/*
스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 */
public class Camouflage {

    public int soulution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (hm.containsKey(clothes[i][1])){
                hm.replace(clothes[i][1], hm.get(clothes[i][1]) + 1);
            } else {
                hm.put(clothes[i][1], 1);
            }
        }

        int asnwer = 1;

        // headgear를 안골랐다를 포함해서 (0, yellow_hat, green_turban) 3가지 경우
        // eyewear를 안골랐다를 포함해서 (0, blue_sunglasses) 2가지 경우
        // 3 * 2 = 6가지 이고, 여기서 0,0인 둘다 안고르는 경우는 없기 때문에 -1

        for (int v : hm.values())
            asnwer *= (v + 1);

        asnwer -= 1;
        return asnwer;
    }


    public static void main(String[] args) {
        String[][] clothes = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int r = new Camouflage().soulution(clothes);
        System.out.println(r);
    }
}



//        int answer = 1;
//        HashMap<String, Integer> map = new HashMap<>();
//        for(int i=0; i<clothes.length; i++){
//            String key = clothes[i][1];
//            if(!map.containsKey(key)) {
//                map.put(key, 1);
//            } else {
//                map.put(key, map.get(key) + 1);
//            }
//        }
//        Iterator<Integer> it = map.values().iterator();
//        while(it.hasNext()) {
//            answer *= it.next().intValue()+1;
//        }
//        return answer-1;
