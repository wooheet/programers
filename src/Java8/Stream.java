package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b", "c", "d", "e");
        List<String> list2 = Arrays.asList("a", "b", "d");

        List<String> result1 = new ArrayList<>();
        for(String str1 : list1){
            for(String str2 : list2){
                if(str1.equals(str2)){
                    result1.add(str1);
                }
            }
        }
        for(String str : result1){
            System.out.print(str);
            System.out.println();
        }

        List<String> result2 = list1.stream().filter(str -> list2.stream().anyMatch(Predicate.isEqual(str)))
                                                .collect(Collectors.toList());

        result2.stream().forEach(System.out::print);
    }
}
