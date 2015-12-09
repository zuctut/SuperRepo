
public class Rational 
{
    // Instance Variables
    private int _n;
    private int _d;

    // Constructors
    public Rational()
    {
        _n = 0;
        _d = 1;
    }

    public Rational(int n, int d)
    {
        this();
        if (d != 0)
        {
            _n = n;
            _d = d;
        }
        else
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

    public void add (Rational fraction){
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
    public static void main(String[] args){
      Rational r = new Rational(2,3); //Stores the rational number 2/3
Rational s = new Rational(1,2); //Stores the rational number 1/2
r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains ½
System.out.println(r);
r.divide(s);
System.out.println(r);
Rational z = new Rational(0,3);
Rational k = new Rational(1,2);
z.add(k);
System.out.println(z);
z.divide(k);
System.out.println(z);

    }
}