import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Írj egy programot, amely egy karakterláncot kér be.
        // Majd minden olyan betüről, ami legalább kétszer szerepel, kiírja, hogy az hányszor szerepelt.
        // Pl: „thequickbrownfoxjumpsoverthelazydog” esetén o 4, e 3, u 2, h 2, r 2, t 2.
        // Bónuszpontért lehet előfordulási gyakoriság szerint csökkenő sorrendben kiírni.

        Scanner sc = new Scanner(System.in);
        System.out.println("Kerek egy karakterlancot: ");
        String sKarakterlanc = sc.nextLine();
        int [] ar=new int[256];
        for(int i=0;i<sKarakterlanc.length();i++)
        {
            ar[sKarakterlanc.charAt(i)]=ar[sKarakterlanc.charAt(i)]+1;
        }
        for(int i=0;i<256;i++)
        {
            char cKarakter =(char)i;
            if(ar[i]>1)
                    System.out.println(cKarakter +" = "+ar[i]);
                }


//        Map<Character, Integer> Karakterterkep = new HashMap<Character, Integer>();
//        char [] cKarakterlancKaraktereinekTombje = sKarakterlanc.toCharArray();
//
//        for (char ertek: cKarakterlancKaraktereinekTombje){
//            if (Character.isAlphabetic(ertek)){
//                if (Karakterterkep.containsKey(ertek)){
//                    Karakterterkep.put(ertek, Karakterterkep.get(ertek) + 1);
//                } else {
//                    Karakterterkep.put(ertek, 1);
//                }
//            }
//        }
//        System.out.println("A karakterlancban szereplo karakterek elofordulasi ertekei: ");
//        System.out.println(Karakterterkep);
    }
}