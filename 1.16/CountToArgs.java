public class CountToArgs {
    public static void main(String[] args) {
        try {
            int maxCount = Integer.parseInt(args[0]); //Takes the first argument and tries to convert it to an
            integer
            for (int i = 0; i <= maxCount; i++) {
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred");
            e.printStackTrace();
        }
    }
}
