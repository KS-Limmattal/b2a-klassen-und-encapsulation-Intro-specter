public class MixedNumber extends Fraction {
    private int wholeNumber;

    public MixedNumber(int wholeNumber, int numerator, int denominator) {
        super(numerator, denominator);
        this.wholeNumber = wholeNumber;
    }

    public MixedNumber(MixedNumber f) {
        this(f.getWholeNumber(), f.getNumerator(), f.getDenominator());
    }

    public MixedNumber() {
        this(0, 0, 1);
    }

    public int getWholeNumber() {
        return wholeNumber;
    }

    public void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    }

    public void add(MixedNumber f) {
        Fraction frac = Fraction.add(this.toFraction(), f.toFraction());
        this.setNumerator(frac.getNumerator());
        this.setDenominator(frac.getDenominator());
        this.setWholeNumber(0);
        this.simplify();
    }

    public static MixedNumber add(MixedNumber f, MixedNumber g) {
        MixedNumber ret = new MixedNumber(f);
        ret.add(g);
        return ret;
    }

    public void sub(MixedNumber f) {
        Fraction frac = Fraction.sub(this.toFraction(), f.toFraction());
        this.setNumerator(frac.getNumerator());
        this.setDenominator(frac.getDenominator());
        this.setWholeNumber(0);
        this.simplify();
    }

    public static MixedNumber sub(MixedNumber f, MixedNumber g) {
        MixedNumber ret = new MixedNumber(f);
        ret.sub(g);
        return ret;
    }

    public void mul(MixedNumber f) {
        Fraction frac = Fraction.simplify(Fraction.mul(this.toFraction(), f.toFraction()));
        this.setNumerator(frac.getNumerator());
        this.setDenominator(frac.getDenominator());
        this.setWholeNumber(0);
        this.simplify();
    }

    public static MixedNumber mul(MixedNumber f, MixedNumber g) {
        MixedNumber ret = new MixedNumber(f);
        ret.mul(g);
        return ret;
    }

    public void div(MixedNumber f) {
        Fraction frac = Fraction.simplify(Fraction.div(this.toFraction(), f.toFraction()));
        this.setNumerator(frac.getNumerator());
        this.setDenominator(frac.getDenominator());
        this.setWholeNumber(0);
        this.simplify();
    }

    public static MixedNumber div(MixedNumber f, MixedNumber g) {
        MixedNumber ret = new MixedNumber(f);
        ret.div(g);
        return ret;
    }

    public void simplify() {
        super.simplify();
        if (this.getNumerator() > this.getDenominator()) {
            this.setWholeNumber(this.getWholeNumber() + this.getNumerator() / this.getDenominator());
            this.setNumerator(this.getNumerator() % this.getDenominator());
        }
    }

    public static MixedNumber simplify(MixedNumber f) {
        Fraction extract = Fraction.simplify(f.extractFraction());
        int wholeN = f.getWholeNumber();
        if (extract.getNumerator() > extract.getDenominator()) {
            wholeN = wholeN + extract.getNumerator() / extract.getDenominator();
            extract.setNumerator(extract.getNumerator() % extract.getDenominator());
        }
        return new MixedNumber(wholeN, extract.getNumerator(), extract.getDenominator());
    }

    public Fraction toFraction() {
        return Fraction.add(new Fraction(this.wholeNumber, 1), this.extractFraction());
    }

    public Fraction extractFraction() {
        return new Fraction(this.getNumerator(), this.getDenominator());
    }

    @Override
    public String toString() {
        return "(" + this.getWholeNumber() + "+" + super.toString() + ")";
    }
}
