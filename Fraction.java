public class Fraction {
    private static int numberOfFractions;
    private int numerator, denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.setDenominator(denominator);
        numberOfFractions++;
    }
    
    public Fraction(Fraction f) {
        this(f.getNumerator(), f.getDenominator());
    }

    public Fraction() {
        this(0, 1);
    }

    @Override
    public String toString() {
        return this.getNumerator() + "/" + this.getDenominator();
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        } else {
            this.denominator = denominator;
        }
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public static int getNumberOfFractions() {
        return numberOfFractions;
    }

    public void add(Fraction f) {
        this.setNumerator(this.getNumerator() * f.getDenominator() + this.getDenominator() * f.getNumerator());
        this.setDenominator(this.getDenominator() * f.getDenominator());
    }

    public static Fraction add(Fraction f, Fraction g) {
        return new Fraction(f.getNumerator() * g.getDenominator() + f.getDenominator() * g.getNumerator(), f.getDenominator() * g.getDenominator());
    }

    public void sub(Fraction f) {
        this.add(mul(new Fraction(-1, 1), f));
    }

    public static Fraction sub(Fraction f, Fraction g) {
        return new Fraction(add(f, mul(new Fraction(-1, 1), g)));
    }

    public void mul(Fraction f) {
        this.setNumerator(this.getNumerator() * f.getNumerator());
        this.setDenominator(this.getDenominator() * f.getDenominator());
    }

    public static Fraction mul(Fraction f, Fraction g) {
        return new Fraction(f.getNumerator() * g.getNumerator(), f.getDenominator() * g.getDenominator());
    }

    public void div(Fraction f) {
        this.setNumerator(this.getNumerator() * f.getDenominator());
        this.setDenominator(this.getDenominator() * f.getNumerator());
    }

    public static Fraction div(Fraction f, Fraction g) {
        return new Fraction(f.getNumerator() * g.getDenominator(), f.getDenominator() * g.getNumerator());
    }

    public static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return (a == 0) ? b : a;
    }

    public void simplify() {
        int greatest_common_divisor = gcd(this.getNumerator(), this.getDenominator());
        this.setNumerator(this.getNumerator()/greatest_common_divisor); 
        this.setDenominator(this.getDenominator()/greatest_common_divisor);
    }

    public static Fraction simplify(Fraction f) {
        int greatest_common_divisor = gcd(f.getNumerator(), f.getDenominator());
        return new Fraction(f.getNumerator()/greatest_common_divisor, f.getDenominator()/greatest_common_divisor);
    }
    
    public boolean equals(Fraction f) {
        return this.getNumerator() * f.getDenominator() == this.getDenominator() * f.getNumerator();
    }

}
