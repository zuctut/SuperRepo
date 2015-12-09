//skeleton file for class Binary

//Zuhra Tukhtamisheva
//APCS1 pd5
//HW43
//2015-12-07

public class Binary {

    private int _decNum;
    private String _binNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
        _decNum = 0;
	     _binNum = "0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
        _decNum = n;
	     _binNum = decToBin(n);
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	    _binNum = s;
	    _decNum = Integer.parseInt(binToDec(s));
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	   return decToBin(_decNum);  
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
	       String r = "";
	       int q = n;
	       int rm = 0;
	     while (q > 0){
	       rm = q % 2;
	        r = rm + r;
	       q = q / 2;
	    
	       }
	       return r; 
           }


    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/

     public static String decToBinR( int n ) { 
          int q = n;
          int rm = 0;
          String r = "";
      if (n == 0){
         r = q % 2 + r;
         }
      else {
       r = q % 2 + r;
       return decToBinR(q/2) + r;
     }
       return r.substring(1);
       
    }


    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
     public static String binToDec( String s ) {
      int retint = 0;
      String rt = "";
      for (int i = 0; i < s.length(); i++){
        int a = Integer.parseInt(s.substring(i, i+1));
        int x = s.substring(i).length() - 1;
        retint += a* Math.pow(2, x);
      }
     rt += retint;
     return rt;}

   /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      
      ============================================*/
       public static String binToDecR( String s ) { 
      String rt = "";
      int retint = 0;
      if (s.length() == 1){
        int a = Integer.parseInt(s.substring(0, 1));
        int x = s.length() - 1;
        retint += a* Math.pow(2, x);
            }
      else {
        int a = Integer.parseInt(s.substring(0, 1));
        int x = s.length() - 1;
        retint += a* Math.pow(2, x);
        retint +=Integer.parseInt(binToDecR(s.substring(1)));
      }
      
          rt = "" + retint;
          return rt;
      

    }
    
    //Accessor Methods
    public int getDec(){
      return _decNum;
    }

    public String getBin(){
      return _binNum;
    }
    //helper function
    public boolean equalz (Binary a){
      int x = a.getDec();
      return (x == this.getDec());

    }
    //helper function 2
    public boolean equalz2 (Binary a){
      String x = a.getBin();
      return (x == this.getBin());
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      ============================================*/
    public boolean equals( Object other ) { 
      if (!(other instanceof Binary))
            return false;
      return equalz((Binary)other) || equalz2((Binary)other);
	       
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      ============================================*/
    public int compareTo( Object other ) {                
        int x = ((Binary)other).getDec();
        if (x == this.getDec()) {
            return 0;
        }
        else if (this.getDec() > x) {
            return 1;
        }
        else 
            {return -1;}}
	 
    

    
    //main method for testing
    public static void main( String[] args ) {
	

	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(7);

  System.out.println( b1 );
  System.out.println( b2 );
  System.out.println( b3 );       
  System.out.println( b4 );       
  System.out.println( "\n==..." );
  System.out.println( b1 == b2 ); //should be false
  System.out.println( b1 == b3 ); //should be true

  System.out.println( "\n==..." );
  System.out.println( "Testing recursively...");

  System.out.println(decToBinR(5));
  System.out.println(decToBinR(5));
  System.out.println(decToBinR(7));       

  System.out.println( "\n==..." );
  System.out.println( "Testing Binary to Decimal...");

      System.out.println(binToDec("0")); //should be 0
      System.out.println(binToDec("1")); //should be 1
      System.out.println(binToDec("10")); //should be 2
      System.out.println(binToDecR("11")); //should be 3
      System.out.println(binToDecR("1110")); //should be 14


  
	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false
 
 
	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos
	  
    }//end main()

} //end class
