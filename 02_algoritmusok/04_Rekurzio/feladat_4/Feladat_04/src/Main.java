public class Main {
    // Egy 𝑛egész szám esetén 𝑛!jelöli 1-től 𝑛-ig a számok szorzatát. 5!=1⋅2⋅3⋅4⋅5.
    // Írjon rekurzív algoritmust amely kiszámolja 𝑛!értékét.
    public static void main(String[] args) {
        int n = 12;
        System.out.println("A " + n + " faktorialisa = " + FaktorialisRek(n));
    }

    private static long FaktorialisRek(int n){
        if (n <= 1)
            return 1;
        return n * FaktorialisRek(n-1);
    }
}