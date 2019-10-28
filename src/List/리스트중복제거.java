package List;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * [중복없애기]
 *  정렬되어 있지 않은 연결리스트가 주어졌을 때 이 리스트에서 중복되는 원소를 제거하는 코드를 작성
 *  임시버퍼를 사용하지 않고 만들수 있을까?
 *
 * [풀이]
 * => 리스트의 내부구현인가 ? 외부구현인가 ?
 * => 외부구현일때, 주어진 리스트를 사용해도 되나 ?
 *  => List Iterater 활용
 *  => Set 으로 데이터 임시저장
 * */

public class 리스트중복제거 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        deleteDuplicationA(list);
//        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void deleteDuplicationA(List<Integer> list) {
        HashSet<Integer> hs = new HashSet<>();
        list.stream().forEach(l -> {
            hs.add(l);
        });
        System.out.println(hs);

        Set<Integer> set = new HashSet<>();
        Iterator<Integer> i;

        i = list.iterator();
        while(i.hasNext()) {
            set.add(i.next());
        }
        System.out.println(set);

        // == Set iterator (자동정렬) ==
        list.clear();
        i = set.iterator();
        while (i.hasNext()) {
            list.add(i.next());
        }

        System.out.println(list);

    }

    static class Node {
        Node next;
        int data;
        Node(int data) {
            this.data = data;
        }
    }

    /* deleteDuplicationB - 내부구현 */
    static void deleteDuplicationB(Node node) {
        HashSet set = new HashSet();
        Node previous = null;
        while (node != null) {
            if(set.contains(node.data)) {
                previous.next = node.next;
            } else {
                set.add(node.data);
                previous = node;
            }
            node = node.next;
        }
    }

}
