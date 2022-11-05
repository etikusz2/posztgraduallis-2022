public class Main {
    public static void main(String[] args) {

        if (atalkitasHelyes(false, false)
                && atalkitasHelyes(false, true)
                && atalkitasHelyes(true, false)
                && atalkitasHelyes(true, true)) {
            System.out.println("Jo atalakitas");
        } else {
            System.out.println("rossz atalakitas");
        }
    }

    private static boolean atalkitasHelyes(boolean a, boolean b) {
        return feltetelFeladatban(a, b) == feltetelAtalakitva(a, b);
    }

    private static boolean feltetelFeladatban(boolean a, boolean b) {
        if ((!a && !b) || (b && a) || (!b && a)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean feltetelAtalakitva(boolean a, boolean b) {
        return (!b || a);
    }
}