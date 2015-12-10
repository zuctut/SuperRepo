//Zuhra Tukhtamisheva
//APCS1 pd5
//HW45 -- Come Together
//2015-12-09


public class Rational implements Comparable{
    
    // *===================================Phase 1-3================================*
    // Instance Variables
    public int _n;
    public int _d;

    // Constructors
    public Rational()
    {
        //setting values for the instance variables
        _n = 0;
        _d = 1;
    }
    //overloaded Constructor
    public Rational(int n, int d)
    {
        this();
        //denominator cannot be 0
        if (d != 0)
        {
            _n = n;
            _d = d;
        }
        else
        //if the denominator is 0, then return an error message
            _n = 0;
            System.out.println("Invalid. Fraction set to 0 / 1");
    }

    // Accessor Methods
    public int getN()
    {
        return _n;
    }

    public int getD()
    {
        return _d;
    }

    // Override toString() Method
    public String toString()
    {
        return ( "Fraction: " + _n + " / " + _d + "\n");
    }

    // Float Value Method
    public double floatValue()
    {
        return ( 1.0*_n / _d ); 
    }

    // Multiply Method
    public void multiply(Rational fraction)
    {
        _n *= fraction.getN();
        _d *= fraction.getD();
    }

    // Divide Method
    public void divide(Rational fraction)
    {
        if ( fraction.getN() != 0 )
        {
            _n *= fraction.getD();
            _d *= fraction.getN();
        }
        else
            System.out.println("Divide by Zero error.");
    }
    
    //Adding method
    public void add(Rational fraction){
        //common multiple
        int multiple = _d * fraction.getD();
        int m1 = multiple / _d ;
        int m2 = multiple / fraction.getD();
        if (_d==fraction.getD()) {
            _n+=fraction.getN();
            _d=fraction.getD();}
        else 
            _d = multiple;
            _n = (_n * m1) + (fraction.getN() * m2);
    }

     //Subtract method
    public void subtract(Rational fraction){
        int multiple = _d * fraction.getD();
            int m1 = multiple / _d ;
            int m2 = multiple / fraction.getD();
        if (_d==fraction.getD()) {
            _n+=fraction.getN();
            _d=fraction.getD();}
        else 
            _d = multiple;
            _n = (_n * m1) - (fraction.getN() * m2);
    }
     
     //Using Euclid's Algorithm to find the gcd
public static int gcdER (Rational r){
        int a = r.getN();
        int b = r.getD();
        //itterative version
        int maxNum = Math.max(a,b); //First number has to be bigger
        int minNum = Math.min(a,b);
        if (minNum == 0) return maxNum; // tests the zero case
        if (maxNum % minNum == 0) return minNum; //tests the zero case
        while (minNum != 0) {
        maxNum = maxNum - minNum;
        if (maxNum < minNum) {
        int temp = minNum;
        minNum = maxNum;
        maxNum = temp;
        }
    }
    return maxNum;
    }

public static int gcd (int n, int d) {
        //itterative version
        int maxNum = Math.max(n,d); //First number has to be bigger
        int minNum = Math.min(n,d);
        if (minNum == 0) return maxNum; // tests the zero case
        if (maxNum % minNum == 0) return minNum; //tests the zero case
        while (minNum != 0) {
        maxNum = maxNum - minNum;
        if (maxNum < minNum) {
        int temp = minNum;
        minNum = maxNum;
        maxNum = temp;
        }
    }
    return maxNum;
    }


    //Reducing fractions method
    public void reduce(){
        //using gcdER to find the greatest common divisor of the Rational
        Rational e = new Rational (_n, _d);
        int h = gcdER(e);
        _n = (_n / h); //new numerator
        _d = (_d / h); //new denominator
        
    }
    public boolean equals( Object other ) { 
    return (compareTo(other) == 0);
    }

    //Accessor methods
    //public int get_decNum() {return this._decNum;}

    public int compareTo(Object other){
    if(!(other instanceof Comparable)) 
         throw new ClassCastException("Error, the input is not Rational");
    else if (other == null)
         throw new NullPointerException("Error, input is null");
    else if ( other instanceof Comparable) {
    
        if (other instanceof Rational){
        int a = ((Rational)other)._n;
        int b = ((Rational)other)._d;

        int c = this._n;
        int d = this._d;
        
        if ((1.0 * a / b) == (1.0 * c / d)) {return 0;}
        else if ((1.0 * a / b) < (1.0 * c / d)) {return 1;}
        else {return -1;}}
        
        else if (other instanceof Hexadecimal){
        int a = ((Hexadecimal)other).get_decNum();
        double b = this.floatValue();
        if (a == b) {return 0;}
        else if (a < b) {return 1;}
        else {return -1;}}

        else if (other instanceof Binary){
        
        int a = ((Binary)other).get_decNum();
        double b = this.floatValue();
        if (a == b) {return 0;}
        else if (a < b) {return 1;}
        else {return -1;}
        } }
        return -1;}
        


 
    
        // *===================================Testing Phase================================*
    public static void main(String[] args){
    //testing multiply
    Rational r = new Rational(2,3); //Stores the rational number 2/3
    Rational s = new Rational(1,2); //Stores the rational number 1/2
    r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains ½
    System.out.println(r);
    //testing divide
    Rational z = new Rational(0,3);
    Rational k = new Rational(1,2);
    z.divide(k); //should give 0 / 3
    System.out.println(z);
    //testing compareTo
    System.out.println(z.compareTo(k)); //should return -1
    Rational q = new Rational(3,6);
    Rational t = new Rational(4,8);
    System.out.println(q.compareTo(t)); //should return 0
    Rational a = new Rational(1, 2);
    Rational b = new Rational(1, 2);
    b.divide(a); //should give 2 / 2
    System.out.println(b);
    //testing add
    Rational c = new Rational(0,3);
    Rational d = new Rational(1,2);
    c.add(d); //should give 3 / 6
    System.out.println(c);
    //testing subtract
    Rational e = new Rational(5,3);
    Rational f = new Rational(1,2);
    e.add(f); //should give 13 / 6
    System.out.println(e);
    //testing gcdER
    Rational g = new Rational(4,50);
    Rational h = new Rational(6,42);
    System.out.println(gcdER(g)); //should print 2
    System.out.println(gcdER(h)); //should print 6
    //testing gcd
    System.out.println(gcd(4, 50)); //should print 2
    System.out.println(gcd(6, 42)); //should print 6
    //testing reduce
    Rational i = new Rational(4,50);
    Rational j = new Rational(6,42);
    i.reduce();
    j.reduce();
    System.out.println(i); //should print 2 / 25
    System.out.println(j); //should print 1 / 7
    
    
    //PHASE 4 TESTS equals
    Object swag = new Object();
    Rational zuhra = new Rational(2,4);
    Rational aleks = new Rational(2,4);
    Rational brown = new Rational(1,5);
    System.out.print("\nShould return true: ");
    System.out.println(zuhra.equals(aleks));
    System.out.print("\nShould return true: ");
    System.out.println(aleks.equals(zuhra));
    System.out.print("\nShould return false: ");
    System.out.println(brown.equals(aleks));
    System.out.print("\nShould return false: ");
    System.out.println(swag.equals(aleks));
}
}
