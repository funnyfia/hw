public class Rational{

  private int numer;
  private int denom;
  
  public Rational() {
    numer = 0;
    denom = 1;
  }

  public Rational(int top, int bottom) {
    if (bottom == 0) {
      System.out.println("Silly user! You can't divide by zero!");
      numer = 0;
      denom = 1;
    }
    else {
      numer = top;
      denom = bottom;
    }
  }
  
  public String toString() {
    return "" + numer + "/" + denom;
  }

  public double floatValue() {
    double floater = (double)numer/denom;
    return floater;
  }

  public void multiply(Rational num) {
    numer *= num.numer;
    denom *= num.denom;
  }

  public void divide(Rational num) {
    numer *= num.denom;
    denom *= num.numer;
  }

  public void add(Rational num) {
    numer = numer * num.denom + num.numer * denom;
    denom *= num.denom;
  }

  public void subtract(Rational num) {
    numer = numer * num.denom - num.numer * denom;
    denom *= num.denom;
  }
  
  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    else {
      return gcd(b, a % b);
    }
  }
  
  public int gcd() {
    return gcd(numer, denom);
  }
  
  public void reduce() {
    int gcd = gcd();
    numer /= gcd;
    denom /= gcd;
  }

  public int compareTo(Rational num) {
    if (floatValue() == num.floatValue()) {
      return 0;
    }
    else if (floatValue() > num.floatValue()) {
      return 1;
    }
    else {
      return -1;
    }
  }
  
  public static void main( String[] args ) {
    Rational a = new Rational();
    Rational b = new Rational(2,3);
    Rational c = new Rational(1,2);
    System.out.println("a is " + a);
    System.out.println("b is " + b);
    System.out.println("c is " + c);
    System.out.print(b + " times " + c + " is "); 
    b.multiply(c);
    System.out.println(b);
    System.out.print(b + " divided by " + c + " is ");
    b.divide(c);
    System.out.println(b);
    System.out.println("In decimal form " + b + " is " + b.floatValue());
    System.out.println("In decimal form " + c + " is " + c.floatValue());
    System.out.print(b + " plus " + c + " is "); 
    b.add(c);
    System.out.println(b);
    System.out.print(b + " minus " + c + " is ");
    b.subtract(c);
    System.out.println(b);
    System.out.println("The greastest common factor of " + b.numer + " and " + b.denom + " is " + b.gcd());
    System.out.print("The reduced form of " + b + " is ");
    b.reduce();
    System.out.println(b);
    System.out.println(b.compareTo(c));
    System.out.println(c.compareTo(b));
    System.out.println(c.compareTo(c));
  }
}
