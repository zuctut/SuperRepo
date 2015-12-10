//Zuhra Tukhtamisheva
//APCS1 pd5
//HW45 -- Come Together
//2015-12-09




public class Hexadecimal implements Comparable {

	public int _decNum;
	private String _hexNum;
	private static final String _HEXDIGITS = "0123456789ABCDEF";

	  /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() { 
	_decNum=0;
	_hexNum="0";
    }


      /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of hex digits
      =====================================*/
    public Hexadecimal( int n ) {
    	_decNum = n;
    	_hexNum = decToHex(n);
	
}

/*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of hex digits representing value of this Object
      =====================================*/

      public String toString() {
      	return _hexNum;
      }

 /*=====================================
      String decToHex(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of hex digits
      eg  decToHex(0) -> "0"
          decToHex(1) -> "1"
	  decToHex(2) -> "2"
	  decToHex(3) -> "3"
	  decToHex(10) -> "A"
	  decToHex(16) -> "10"
	  decToHex(20) -> "14"
	  decToHex(32) -> "20"
	  decToHex(42) -> "2A"
      =====================================*/

     public static String decToHex(int n){
     	String s = "";
     	while (n > 0){
     		s += _HEXDIGITS.substring(n % 16, (n % 16 + 1)) + s;
     		n = n/16;
     	}
     	return s.substring(1);
	}

	  /*=====================================
      String decToHexR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of hex digits
      eg  decToHexR(0) -> "0"
          decToHexR(1) -> "1"
	  decToHexR(2) -> "2"
	  decToHexR(3) -> "3"
	  decToHexR(10) -> "A"
	  decToHexR(16) -> "10"
	  decToHexR(20) -> "14"
	  decToHexR(32) -> "20"
	  decToHexR(42) -> "2A"
      =====================================*/

      public static String decToHexR(int n) {
      	String s = "";
      	if (n >= 0) 
      		return decToHexR(n/16) + _HEXDIGITS.substring(n % 16, n % 16 + 1);
      	
      	else 
      		return s;
      }
/*=====================================
      String hexToDec(String) -- converts string input to hexadecimal
      pre:  
      post: returns int of hex digits
      eg  decToHex("0") -> 0
          decToHex("1") -> 1
	  decToHex("2") -> 2
	  decToHex("3") -> 3
	  decToHex("10") -> A
	  decToHex("16") -> 10
	  decToHex("14") -> 20
	  decToHex("20") -> 32
	  decToHex("2A") -> 42
      =====================================*/
public static int hexToDec(String s) {
	int ret = 0;
	for (int i = 0; i < s.length(); i++){
		String c = s.substring(i, i+1);
		int d = _HEXDIGITS.indexOf(c);
		ret = 16*ret + d;
	}
	return ret;}

/*public static int hexToDecR(String s) {
	if (s.length() >= 0){
	int i = 0;
	String c = s.substring(i, i+1);
	int d = _hexChars.indexOf(c);
	ret = 16*ret + d;
	return ret + hexToDecR(s.substring(i+1));}
	else {return 0;}}*/

    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
            Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
	return (compareTo(other) == 0);
    }
 
 //Accessor methods
    public int get_decNum() {return _decNum;}

 /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
      pre:  other is instance of class Hexadecimal
      post: Returns 0 if this Object is equal to the input Object,
            negative integer if this<input, positive integer otherwise
      =============================================*/
       
     public int compareTo( Object other ) {                
        if(!(other instanceof Comparable)) {
          throw new ClassCastException("Error, the input is not Hexadecimal");}
        
        else if (other == null) {
          throw new NullPointerException("Error, input is null");}
        
        else if ( other instanceof Comparable) {
        
        if (other instanceof Hexadecimal){
        int a = ((Hexadecimal)other)._decNum;
        int b = this._decNum;
        if (a == b) {return 0;}
        else if (a < b) {return 1;}
        else {return -1;}
        }

        else if (other instanceof Binary){
        int a = ((Binary)other).get_decNum();
        int b = this._decNum;
        if (a == b) {return 0;}
        else if (a < b) {return 1;}
        else {return -1;}
        }

        else if (other instanceof Rational){
        if (this._decNum > ((Rational)other).floatValue() ) {return 1;}
        else if (this._decNum == ((Rational)other).floatValue() ) {return 0;}
        else {return -1;}
        }}
	     return -1;}
	

	public static void main (String [] args){
	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal h1 = new Hexadecimal(10);
	Hexadecimal h2 = new Hexadecimal(10);
	Hexadecimal h3 = h1;
	Hexadecimal h4 = new Hexadecimal(20);

	System.out.println( h1 );
	System.out.println( h2 );
	System.out.println( h3 );       
	System.out.println( h4 );      
	    
	System.out.println( "\n==..." );
	System.out.println( h1 == h2 ); //should be false
	System.out.println( h1 == h3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( h1.equals(h2) ); //should be true
	System.out.println( h1.equals(h3) ); //should be true
	System.out.println( h3.equals(h1) ); //should be true
	System.out.println( h4.equals(h2) ); //should be false
	System.out.println( h1.equals(h4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( h1.compareTo(h2) ); //should be 0
	System.out.println( h1.compareTo(h3) ); //should be 0
	System.out.println( h1.compareTo(h4) ); //should be neg
	System.out.println( h4.compareTo(h1) ); //should be pos
	}}


