package DfsBfs;

public class Basic {

    int cents[] = {50, 25, 10, 5, 1};
    public int count(int amount) {
        return count(amount, 0, 0);
    }

    public int count(int amount, int idx, int bungi) {
        if (amount == 0) {
            return 1;
        } else if(amount < 0 || idx >= cents.length) {
            return 0;
        } else {
            return count(amount - cents[idx], idx, 1) + count(amount, idx + 1, 2);
        }
    }

    public static void main(String[] args) {
        int r = new Basic().count(5);
        System.out.println(r);
    }
}
