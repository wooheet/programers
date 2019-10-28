package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
배열 arr에서 제거 되고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.

[1,1,3,3,0,1,1]	   [1,3,0,1]

[4,4,4,3,3]	        [4,3]
 */
public class 같은숫자는싫어 {
    public int[] solution(int[] arr) {
//        int[] answer = new int[]{};
//
//        for (int i= 0; i < arr.length; i++) {
//            int count = 0;
//            if (arr[i] == arr[i+1]) {
//                answer[i] = arr[i];
//                count++;
//            }
//        }
//
//        return answer;

        LinkedList<Integer> list = new LinkedList<>();
        list.add(arr[0]);
        for(int i=1; i<arr.length;i++){
            if(arr[i]!=list.getLast()){
                list.add(arr[i]);
            }

        }

        Integer[] i = list.toArray(new Integer[list.size()]);

        Arrays.stream(i).mapToInt(Integer::valueOf).toArray();

        List<Integer> l = new ArrayList<>();

        LinkedList<Integer> ls = new LinkedList<>();


        Integer[] listing = list.toArray(new Integer[list.size()]);
        int []answer = Arrays.stream(listing).mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,3,3,0,1,1};
        int[] arr2 = new int[]{4,4,4,3,3};

//        new 같은숫자는싫어().solution(arr);
        new 같은숫자는싫어().solution(arr2);
    }
}

