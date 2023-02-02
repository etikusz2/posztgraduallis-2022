public class Main {
    public static void main(String[] args) {
        String karakterlanc = "abcab";
        int n = karakterlanc.length();
        System.out.println("A karakterlan osszes reszkarakterlancainak szama = " + ReszkarakterlancSzamlalo(karakterlanc, 0, n - 1, n));
    }

    static int ReszkarakterlancSzamlalo(String karakterlanc, int elsokarakter,
                                        int utolsokarakter, int karakterlanchossza) {
        if (karakterlanchossza == 1)
            return 1;
        if (karakterlanchossza <= 0)
            return 0;

        int reszkarakterlancokszama = ReszkarakterlancSzamlalo(karakterlanc, elsokarakter + 1, utolsokarakter, karakterlanchossza - 1) +
                ReszkarakterlancSzamlalo(karakterlanc, elsokarakter, utolsokarakter - 1, karakterlanchossza - 1) -
                ReszkarakterlancSzamlalo(karakterlanc, elsokarakter + 1, utolsokarakter - 1, karakterlanchossza - 2);

        if (karakterlanc.charAt(elsokarakter) == karakterlanc.charAt(utolsokarakter))
            reszkarakterlancokszama++;

        return reszkarakterlancokszama;
    }
}