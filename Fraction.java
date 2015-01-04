/**
 * Created by keith for the second coursework assignment.
 * Modified by Zsolt Balvanyos on 22.11.2014
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }
	
	public Fraction(int num) {
		setNumerator(num);
		setDenominator(1);
	}

    @Override
    public String toString() {
		if(this.getDenominator() == 1){
			return "" + getNumerator();
		}else{
			return "" + getNumerator() + '/' + getDenominator();
		}
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction other) {

        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }
	
	public Fraction divide(Fraction other) {
		int num = this.getNumerator() * other.getDenominator();
		int denom = this.getDenominator() * other.getNumerator();
		return new Fraction(num, denom);
	}
	
	public Fraction add(Fraction other) {
		int num = this.getNumerator() * other.getDenominator() + this.getDenominator() * other.getNumerator();
		int denom = this.getDenominator() * other.getDenominator();
		return new Fraction(num, denom);
	}
	
	public Fraction subtract(Fraction other) {
		int num = this.getNumerator() * other.getDenominator() - this.getDenominator() * other.getNumerator();
		int denom = this.getDenominator() * other.getDenominator();
		return new Fraction(num, denom);
	}
	
	public Fraction absValue() {
		if(this.getNumerator() < 0 && this.getDenominator() > 0) {
			return new Fraction(this.getNumerator() * (-1), this.getDenominator());
		}else if(this.getNumerator() >= 0 && this.getDenominator() < 0) {
			return new Fraction(this.getNumerator(), this.getDenominator() * (-1));
		}else{
			return new Fraction(this.getNumerator(), this.getDenominator());
		}
	}
	
	public Fraction negate() {
		return new Fraction(this.getNumerator() * (-1), this.getDenominator());
	}

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
