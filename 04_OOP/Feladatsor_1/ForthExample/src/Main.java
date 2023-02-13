public class Main {
    // Készítsünk egy osztályt törtek reprezentációjára,
    // és az osztályon belüli metódusok formájában implementáljuk az alapműveleteket (összeadás, kivonás, szorzás, osztás),
    // illetve az ezek elvégzéséhez szükséges segédműveleteket.
    // Készítsünk egy programot, amelyben szemléltetjük osztályunk működését.
    public static void main(String[] args) {

        double dNumber1 = 6.5;
        double dNumber2 = 3.25;

        FractionalNumbersOperation addTwoNumbers = new FractionalNumbersOperation();
        double sum = addTwoNumbers.addition(dNumber1, dNumber2);
        System.out.println("Sum of " + dNumber1 + " and " + dNumber2 + " is equal with " + sum);

        FractionalNumbersOperation subTracted = new FractionalNumbersOperation();
        double difference = subTracted.subtraction(dNumber1, dNumber2);
        System.out.println("Difference of " + dNumber1 + " and " + dNumber2 + " is equal with " + difference);

        FractionalNumbersOperation multiplyTwoNumbers = new FractionalNumbersOperation();
        double product = addTwoNumbers.multiplication(dNumber1, dNumber2);
        System.out.println(" Multiply " + dNumber1 + " with " + dNumber2 + " is equal with " + product);

        FractionalNumbersOperation dividTwoNumbers = new FractionalNumbersOperation();
        double ratio = addTwoNumbers.division(dNumber1, dNumber2);
        System.out.println("Ratio between " + dNumber1 + " and " + dNumber2 + " is equal with " + ratio);
    }
}

