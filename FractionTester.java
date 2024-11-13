public class FractionTester {
    public static void main(String[] args) {

        /*
         * Was ich aus den Lösungen lernte:
         * - Es macht sinn Funktionalität überall wo es sinn macht in einzelne Methoden zu separieren,
         * - anstatt für jeden Fall eine Methode mit wiederholtem Code zu schreiben.
         */

        Fraction f = new Fraction(24, 4);

        // Der folgende Code funktioniert nur, wenn die Felder von Fraction nicht privat sind:
        // f.numerator = 12;
        // f.denominator = 2;
        // System.out.println(f.numerator + "/" + f.denominator);
        
        // toString():
        System.out.println("f: " + f);

        // Encapsulation, Getter und Setter:
        System.out.println("f: " + f.getNumerator() + "/" + f.getDenominator());
        f.setNumerator(12);
        f.setDenominator(2);

        // Copy-Konstruktor und equals():
        Fraction g = new Fraction(f);
        Fraction h = new Fraction(6, 1);
        System.out.println("(" + g + " == " + f + "): " + g.equals(f));
        System.out.println("(" + g + " == " + h + "): " + g.equals(h));
        
        // Klassen- und Instanzenmethoden:
        System.out.println("f + g = " + Fraction.add(f, g));
        h.add(f);
        System.out.println("h + f = " + h);

        // statische Variablen:
        System.out.println("static numberOfFractions: " + Fraction.getNumberOfFractions());

        // Konstante Variablen
        final double PI = 3.14159d;
        System.out.println("const PI = " + PI);
        // PI += 1; // geht nicht
        // PI kann nicht geändert werden

        // Operationen
        System.out.println("f: " + f + ", g: " + g);
        System.out.println("f + g = " + Fraction.add(f, g));
        System.out.println("f - g = " + Fraction.sub(f, g));
        System.out.println("f * g = " + Fraction.mul(f, g));
        System.out.println("f / g = " + Fraction.div(f, g));
        f.simplify();
        System.out.println("simplified f: " + f);

        // MixedNumber
        MixedNumber a = new MixedNumber(0, 4, 2);
        MixedNumber b = new MixedNumber(1, 1, 2);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("simple a: " + MixedNumber.simplify(a));
        System.out.println("simple b: " + MixedNumber.simplify(b));
        System.out.println("a + b = " + MixedNumber.simplify(MixedNumber.add(a, b)));
        System.out.println("a - b = " + MixedNumber.simplify(MixedNumber.sub(a, b)));
        System.out.println("a * b = " + MixedNumber.simplify(MixedNumber.mul(a, b)));
        System.out.println("a / b = " + MixedNumber.simplify(MixedNumber.div(a, b)));
    }
}