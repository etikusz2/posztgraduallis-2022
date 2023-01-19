public class Main {
    private static String sKarakterlanc = "BirtalanEteleAkos";

    public static void main(String[] args) {
        Csere("G", 6);
    }

    private static void Csere(String Karakter, int Pozicio) {
        String ModositottKarakterlanc = sKarakterlanc.replaceFirst(String.valueOf(sKarakterlanc.charAt(Pozicio)), Karakter);
        System.out.println(sKarakterlanc);
        System.out.println(ModositottKarakterlanc);
    }
}