public class CountMultiplesBelow{
    public static void main(String[] args) {
        int multNum = Integer.parseInt(args[0]);
        int maxCount = Integer.parseInt(args[1]);
        for(int i = 1; i <= maxCount/multNum; i++) {
            System.out.println(multNum * i);
        }
    }
}
