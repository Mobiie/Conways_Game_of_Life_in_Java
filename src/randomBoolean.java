public class randomBoolean {
        public static boolean getRandomBoolean() {
            return Math.random() < 0.5;
        }
    public static void main(String[] args) {
        for(int i = 1; i < 25; i++)
            System.out.println(getRandomBoolean());
    }
}