public class Main {
    public static void main(String[] args) {
        //  Írj egy programot, ami beolvas egy egész számot, binárisan összevagyolja 512-vel, majd az eredményt kíjra.
        //Ennek a programnak a segítségével adj meg 1-1 olyan különböző számot ami:
        //a. Kisebb mint 512 és a program kimenete 548.
        //b. Nagyobb mint 512 és a program kimenete 1536.

        int i1 = 36;
        int i1Vagy512 = i1 | 512;

        if (i1Vagy512 == 548) {
            System.out.println("36 | 512-vel = " + i1Vagy512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 548-al");
        }

        //b. Nagyobb mint 512 és a program kimenete 1536.

        int i2 = 1024;
        int i2Vagy512 = i2 | 512;

        if (i2Vagy512 == 1536) {
            System.out.println("1024 | 512-vel = " + i2Vagy512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 1536-al");
        }
    }
}