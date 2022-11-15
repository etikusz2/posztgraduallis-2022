import java.util.Arrays;
import java.util.Random;

public class Main {
// / Hozzon létre egy új projektet, majd az e-mailben kapott megkever.java tartalmát másolja be a Main.java fájlba.
//        //A kód egy pakli kártyát generál, vagy kisebb tesztadatot, ha az a szükséges.
//        // Egészítse ki a main függvényt a következő lépésekkel
//        //a. Egy véletlenszerűen kiválasztott lapnál vágja ketté a paklit.
//        // Ennek eredményeként két olyan string tömbje kell előálljon amelyek együtes hossza megegyezik a pakli méretével,
//        // a pakli első fele az egyik tömbben, a másik fele a másik tömbben van.
//        //b. Írjon egy függvényt ami a két félpaklit összeteszi oly módon,
//        // hogy véletlenszerűen választ a nemüres félpaklik kizül, hogy melyikből veszi a következő lapot.
        public static void main(String[] args) {
            // false esetén kis tesztadatot ad a függvény
            String[] cards = generateDeck(true);
            Random r = new Random();
            String hand1 = Arrays.toString(cards).substring(Integer.parseInt(cards[0]), Integer.parseInt(cards[r.nextInt(cards.length)]));
            System.out.println(hand1);



        }



        /**
         * Generál egy pakli rendezett kártyát.
         *
         * @param fullDeck Ha igaz, akkor a teljes paklit generálja, hanem csak teszadatokat.
         * @return
         */
        private static String[] generateDeck(boolean fullDeck) {
            if (fullDeck) {
                String[] deck = new String[32];
                for (int i = 0; i < deck.length; i++) {
                    deck[i] = getColor(i / 8) + " " + getCardId(i % 8);
                }
                return deck;
            } else {
                // valami tesztadat fejelsztéshez
                String[] dummyDeck = new String[5];
                for (int i = 0; i < dummyDeck.length; i++) {
                    dummyDeck[i] = String.valueOf(i);
                }
                return dummyDeck;
            }
        }

        private static String getColor(int colorCode) {
            switch (colorCode) {
                case 0:
                    return "piros";
                case 1:
                    return "tök";
                case 2:
                    return "makk";
                case 3:
                    return "zöld";
            }
            // ez nem szép, de most ne foglalkozzunk vele
            return "";
        }

        private static String getCardId(int cardCode) {
            switch (cardCode) {
                case 0:
                    return "alsó";
                case 1:
                    return "felső";
                case 2:
                    return "király";
                case 3:
                    return "VII";
                case 4:
                    return "VIII";
                case 5:
                    return "IX";
                case 6:
                    return "X";
                case 7:
                    return "ász";
            }
            // ez nem szép, de most ne foglalkozzunk vele
            return "";
        }
    }
}