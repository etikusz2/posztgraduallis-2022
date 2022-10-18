public class Main {
    public static void main(String[] args) {
        int i1 = 1;
        int i2 = 100;
        int i3 = 500;

        int i1Es512 = i1 & 512;
        int i2Es512 = i2 & 512;
        int i3Es512 = i3 & 512;

        if (i1Es512 == 0){
            System.out.println("1 & 512-vel = " +i1Es512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 0-val");
        }

        if (i2Es512 == 0){
            System.out.println("10 & 512-vel = " +i2Es512);
        } else {
            System.out.println("Az eredmeny nem egyenlo 0-val");
        }

        if (i3Es512 == 0){
            System.out.println("500 & 512-vel = " +i3Es512);
        } else  {
            System.out.println("Az eredmeny nem egyenlo 0-val");
        }
    }
}