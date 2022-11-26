public class Main {
    // A  Fibonacci  sorozat  elég  természetellenes  képességű  nyulak  szaporodását  modellezi.
    // A  sorozat úgy  indul,  hogy 𝐹2=𝐹1=1.
    // Ezek  után  egy  tetszőleges 𝐹𝑛érteke  úgy  számolható  ki,
    // hogy  a sorozat két előző elemét összedadjuk 𝐹𝑛=𝐹𝑛−1+𝐹𝑛−2. (1,1,2,3,5,8,13,...)
    // Számolja ki 𝐹𝑛értékét rekurzió segítségéve.
    public static void main(String[] args) {
        int n = 7;
        System.out.println("F("+ n +") = " + FibonacciRek(7));
    }

    private static int FibonacciRek(int n) {
        if (n <= 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;

        return FibonacciRek(n-1) + FibonacciRek(n-2);
    }
}