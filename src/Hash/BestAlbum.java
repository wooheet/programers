package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.genres[i]는 고유번호가 i인 노래의 장르입니다.

plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.
 */
public class BestAlbum {

//    public int[] solution(String[] genres, int[] plays) {
//
//        //고유번호 = key값 & 장르, 플레이횟수 = value값
//        HashMap<Integer, Integer> pMap = new HashMap<Integer, Integer>();
//        HashMap<Integer, String> gMap = new HashMap<Integer, String>();
//        for(int i = 0; i < genres.length; i++){
//            pMap.put(i, plays[i]);
//            gMap.put(i, genres[i]);
//        }
//
//        //HashSet으로 장르 분류
//        HashSet<String> gSet = new HashSet<String>();
//
//        for(int i = 0; i < genres.length; i++){
//            gSet.add(genres[i]);
//        }
//
//        //장르별 총 플레이 횟수
//        HashMap<Integer, String> coPlay = new HashMap<Integer, String>();
//        for(String x : gSet){
//            int count = 0;
//            for(int i = 0; i < gMap.size(); i++){
//                if(gMap.get(i).equals(x)){
//                    count+= pMap.get(i);
//                }
//            }
//            coPlay.put(count, x);
//        }
//
//        //플레이 횟수 별로 정렬(키 값을 기준으로 정렬, TreeMap)
//        TreeMap sort = new TreeMap(coPlay);
//        String[] sortGenre = new String[gSet.size()];
//        int index = 0;
//        for(Object o : sort.keySet()){
//            sortGenre[index] = sort.get(o).toString();
//            index++;
//        }
//
//        //장르별 많이 플레이 된 노래의 고유번호 찾기
//        ArrayList<Integer> fIndex = new ArrayList<Integer>();
//        for(int i = sortGenre.length-1; i >= 0; i--){
//            int count = 0;
//            for(int p1 : gMap.keySet()){
//                if(sortGenre[i].equals(gMap.get(p1))){
//                    count++;
//                }
//            }
//
//            int[] temp = new int[count];
//            int k = 0;
//            for(int p2 : gMap.keySet()){
//                if(sortGenre[i].equals(gMap.get(p2))){
//                    temp[k] = pMap.get(p2);
//                    k++;
//                }
//            }
//
//            if(temp.length != 1){
//                Arrays.sort(temp);
//                for(int j = temp.length - 1; j >= temp.length - 2; j--){
//                    for(int p : pMap.keySet()){
//                        if(temp[j] == pMap.get(p)){
//                            fIndex.add(p);
//                            pMap.put(p, 0);
//                            break;
//                        }
//                    }
//                }
//            }else{
//                for(int p : pMap.keySet()){
//                    if(temp[0] == pMap.get(p)){
//                        fIndex.add(p);
//                        pMap.put(p, 0);
//                        break;
//                    }
//                }
//            }
//        }
//
//        int[] answer = new int[fIndex.size()];
//
//        for(int i = 0; i < fIndex.size(); i++){
//            answer[i] = fIndex.get(i);
//        }
//
//        return answer;
//    }

    public class Music implements Comparable<Music>{

        private int played;
        private int id;
        private String genre;

        public Music(String genre, int played, int id) {
            this.genre = genre;
            this.played = played;
            this.id = id;
        }

        @Override
        public int compareTo(Music other) {
            if(this.played == other.played) return this.id - other.id;
            return other.played - this.played;
        }

        public String getGenre() {return genre;}
    }

    public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(genres[i], plays[i], i))
                .collect(Collectors.groupingBy(Music::getGenre))
                .entrySet().stream()
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                .flatMap(x->x.getValue().stream().sorted().limit(2))
                .mapToInt(x->x.id).toArray();
    }

    private int sum(List<Music> value) {
        int answer = 0;
        for (Music music : value) {
            answer+=music.played;
        }
        return answer;
    }

    public static void main(String[] a) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        int[] r =new BestAlbum().solution(genres, plays);

        Arrays.stream(r).forEach(System.out::println);
    }
}
