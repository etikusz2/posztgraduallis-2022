public class Main {
    //Írj egy programot, ami beolvas egy egész számot, binárisan összeéseli 512-vel, majd az eredményt kíjra.
    // Ennek a programnak a segítségével adj meg 3-3 olyan különböző számot ami:
    // a. Kisebb mint 512 és a program kimenete 0.
    //b. Nagyobb mint 512 és a program kimenete 512.
    //c. Nagyobb mint 512 és a program kimenete 0.
    public static void main(String[] args) {

        // a. Kisebb mint 512 és a program kimenete 0.

        int i1 = 1;
        int i2 = 100;
        int i3 = 500;

        int i1Es512 = i1 & 512;
        int i2Es512 = i2 & 512;
        int i3Es512 = i3 & 512;

        if (i1Es512 == 0) {
            System.out.println("1 & 512-vel = " + i1Es512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 0-val");
        }

        if (i2Es512 == 0) {
            System.out.println("10 & 512-vel = " + i2Es512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 0-val");
        }

        if (i3Es512 == 0) {
            System.out.println("500 & 512-vel = " + i3Es512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 0-val");
        }

        //b. Nagyobb mint 512 és a program kimenete 512.

        int i4 = 513;
        int i5 = 600;
        int i6 = 1023;

        int i4Es512 = i4 & 512;
        int i5Es512 = i5 & 512;
        int i6Es512 = i6 & 512;

        if (i4Es512 == 512) {
            System.out.println("513 & 512-vel = " + i4Es512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 512-vel");
        }

        if (i5Es512 == 512) {
            System.out.println("600 & 512-vel = " + i5Es512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 512-vel");
        }

        if (i6Es512 == 512) {
            System.out.println("1023 & 512-vel = " + i6Es512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 512-vel");
        }

        //c. Nagyobb mint 512 és a program kimenete 0.

        int i7 = 1024;
        int i8 = 2048;
        int i9 = 4096;

        int i7Es512 = i7 & 512;
        int i8Es512 = i8 & 512;
        int i9Es512 = i9 & 512;

        if (i7Es512 == 0) {
            System.out.println("1024 & 512-vel = " + i7Es512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 0-val");
        }

        if (i8Es512 == 0) {
            System.out.println("2048 & 512-vel = " + i8Es512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 0-val");
        }

        if (i9Es512 == 0) {
            System.out.println("4098 & 512-vel = " + i9Es512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 0-val");
        }
    }
}