import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Írj egy programot ami bekér egy szöveget.
        // Ezt a szöveget vesszők mentén feldarabolja, majd kiírja az összes előforduló szót, de csak egyszer.
        // Pl.: „alma, körte, alma, kukorica” bemenetre „alma, körte, kukorica” íródik a képernyőre.

        Scanner sc = new Scanner(System.in);
        System.out.println("Kerek egy szoveget: ");
        String sSzoveg = sc.nextLine();
        String sSzovegFeldarabolva[] = sSzoveg.split(",");
        int iTombhossza = sSzovegFeldarabolva.length;
        System.out.println("A megadott szoveg a duplan szereplo szavak nelkul: ");
        for(int i=0; i<iTombhossza-1; i++){
            if(sSzovegFeldarabolva[i]!=null){
                for(int j=i+1; j<iTombhossza; j++){
                    if(sSzovegFeldarabolva[i].equals(sSzovegFeldarabolva[j])){
                        sSzovegFeldarabolva[j]=null;
                    }
                }
            }
        }
        for(int i=0; i<iTombhossza;i++){
            if(sSzovegFeldarabolva[i]==null)
                continue;
            System.out.println(sSzovegFeldarabolva[i]);
        }
    }
}