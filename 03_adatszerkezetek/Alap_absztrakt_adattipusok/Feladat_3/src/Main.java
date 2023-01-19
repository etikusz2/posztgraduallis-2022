
public class Main {
    public static void main(String[] args) {

        BooleanMultihalmaz bmh1 = new BooleanMultihalmaz();
        BooleanMultihalmaz bmh2 = new BooleanMultihalmaz();
        bmh1.HozzaAd(true);
        bmh1.HozzaAd(true);
        bmh1.HozzaAd(false);
        bmh2.HozzaAd(false);
        bmh2.HozzaAd(false);
        BooleanMultihalmaz bmh1Kivonbmh2 = bmh1.Kivon(bmh2);
        bmh2.BenneVan(true);

        if (bmh1.ElemMultiplicitasa(true) == 2) {
            System.out.println("Lehet, hogy jól működik az adatszerkezet");
        } else {
            System.out.println("Tuti rossz az adatszerkezet.");
        }
    }
}

class BooleanMultihalmaz {

    int trueErtekekSzama;
    int falseErtekekSzama;


    public BooleanMultihalmaz() {
        trueErtekekSzama = 0;
        falseErtekekSzama = 0;
    }

    public void HozzaAd(boolean elem) {
        if (elem == true)
            trueErtekekSzama++;
        else
            falseErtekekSzama++;
    }

    public int Szamossag() {
        return trueErtekekSzama + falseErtekekSzama;
    }

    public void Kivesz(boolean elem) {
        if (trueErtekekSzama > 0 || falseErtekekSzama > 0)
            if (elem == true)
                trueErtekekSzama--;
            else
                falseErtekekSzama--;
    }

    public BooleanMultihalmaz Kivon(BooleanMultihalmaz kivonando) {
        BooleanMultihalmaz HalmazokKulonbsege = new BooleanMultihalmaz();
        if (this.trueErtekekSzama - kivonando.trueErtekekSzama > 0)
            HalmazokKulonbsege.trueErtekekSzama = this.trueErtekekSzama - kivonando.trueErtekekSzama;
        else
            HalmazokKulonbsege.trueErtekekSzama = 0;
        if (this.falseErtekekSzama - kivonando.falseErtekekSzama > 0)
            HalmazokKulonbsege.falseErtekekSzama = this.falseErtekekSzama - kivonando.falseErtekekSzama;
        else
            HalmazokKulonbsege.falseErtekekSzama = 0;
        return HalmazokKulonbsege;
    }

    public BooleanMultihalmaz Egyesit(BooleanMultihalmaz halmaz) {
        BooleanMultihalmaz EgyesitettHalmaz = new BooleanMultihalmaz();
        EgyesitettHalmaz.trueErtekekSzama = this.trueErtekekSzama + halmaz.trueErtekekSzama;
        EgyesitettHalmaz.falseErtekekSzama = this.falseErtekekSzama + halmaz.falseErtekekSzama;
        return EgyesitettHalmaz;
    }

    public BooleanMultihalmaz Metszet(BooleanMultihalmaz metszendo) {
        BooleanMultihalmaz metszet = new BooleanMultihalmaz();
        if (this.trueErtekekSzama > 0 && metszendo.BenneVan(true))
            metszet.HozzaAd(true);
        if (this.falseErtekekSzama > 0 && metszendo.BenneVan(false))
            metszet.HozzaAd(false);
        return new BooleanMultihalmaz();
    }

    public void Urit() {
        trueErtekekSzama = 0;
        falseErtekekSzama = 0;
    }

    public boolean BenneVan(boolean elem) {
        if (elem == true && trueErtekekSzama > 0)
            return true;
        if (elem == false && falseErtekekSzama > 0)
            return true;
        return false;
    }

    public boolean uresE() {
        return Szamossag() == 0;
    }

    public Boolean[] Ertekek() {
        return new Boolean[0];
    }

    public int ElemMultiplicitasa(boolean elem) {
        return 0;
    }
}