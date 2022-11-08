public class Main {
    public static void main(String[] args) {
        quiz(7);
    }
    private static void quiz (int i){
        if (i > 1){
            quiz(i/3);
            quiz(i-4);
        }
        System.out.println("*");
    }
}