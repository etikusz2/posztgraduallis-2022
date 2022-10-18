public class Main {
    public static void main(String[] args) {
        //  Írj egy programot, ami beolvas egy egész számot, binárisan összekizáróvagyolja (XOR-olja) 512- vel, majd az eredményt kíjra.
        //Ennek a programnak a segítségével adj meg olyan számokat ami:
        //a. Kisebb mint 512 és a program kimenete 578.
        //b. Nagyobb mint 512 és a program kimenete 1030.
        //c. Nagyobb mint 512 és a program kimenete 1534.

        int i1 = 66;
        int i1Xor512 = i1 ^ 512;

        if (i1Xor512 == 578) {
            System.out.println("66 XOR 512-vel = " + i1Xor512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 578-al");
        }

        //b. Nagyobb mint 512 és a program kimenete 1030.

        int i2 = 1542;
        int i2Xor512 = i2 ^ 512;

        if (i2Xor512 == 1030) {
            System.out.println("1542 XOR 512-vel = " + i2Xor512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 1030-al");
        }

        //c. Nagyobb mint 512 és a program kimenete 1534.

        int i3 = 2046;
        int i3Xor512 = i3 ^ 512;

        if (i3Xor512 == 1534) {
            System.out.println("2046 XOR 512-vel = " + i3Xor512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 1534-el");
        }
    }
}