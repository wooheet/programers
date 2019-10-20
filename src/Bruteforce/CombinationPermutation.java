package Bruteforce;

public class CombinationPermutation {
    public static void main(String[] ar){
        /* 조합 */
        int n = 5;
        int r = 3;
        int[] arr = {1, 2, 3, 4, 5};
        int[] container = new int[arr.length];
        combination(container, n, r, 0, 0, arr);

        /* 순열 */
        permutation(arr, 0);
    }

    /*
        @ param container : 선택한 요소들을 저장하는 배열
        @ param n        : 요소들의 갯수
        @ param r        : 선택할 요소들의 총 갯수 (선택하면 r - 1, 선택하지 않으면 r)
        @ param index     : container 배열의 위치를 나타내는 index
        @ param target    : 선택한 수가 아닌, 선택한 수의 arr 배열에서의 위치
    */
    public static void combination(int[] container, int n, int r, int index, int target, int[] arr){
        if(r == 0){
            // 배열을 모두 탐색하든 탐색하지 않든, r개를 뽑은 경우에는 통과! //
            printArr(arr, container);
        } else if(target == n) {
            // 배열을 모두 탐색했지만, r개를 뽑지 못한 경우에는 통과! //
        } else{
            container[index] = target;
            combination(container, n, r - 1, index + 1, target + 1, arr);
            combination(container, n, r, index, target + 1, arr);
        }
    }

    public static void printArr(int[] arr, int[] container) {
        for(int i = 0; i < 3; i++)
            System.out.print(arr[container[i]]);

        System.out.println();
    }

    public static void printArr(int[] arr) {
        for(int i = 0; i < 3; i++)
            System.out.print(arr[i]);

        System.out.println();
    }

    public static void permutation(int[] arr, int index){
        if(index == arr.length - 1){
            printArr(arr);
        } else {
            for(int i = index; i < arr.length; i++){
                swap(arr, index, i);
                permutation(arr, index + 1);
                swap(arr, index, i);
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
