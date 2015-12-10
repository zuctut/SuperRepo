//Zuhra Tukhtamisheva
//APCS1 pd5
//HW45 -- Come Together
//2015-12-09

//Note: Credits to Sungbin Kim and Sachal Malik for helping me out



 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray implements Comparable{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor â€“ initializes 10-item array
    public SuperArray() 
    { 
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() 
    { 
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) 
    { 
 	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) { 
    if (_size == 0) {_data[0] = newVal;
        _size+=1;
        _lastPos+=1;
  }
      else
        {_data[_size] = newVal;
          _size+=1;
          _lastPos+=1;
          }}


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
    Comparable [] temp = new Comparable[_data.length];
    if (index >= _size){System.out.println("Index is out of range");}
    if (index > 0){
         for (int i = 0; i<index; i++)
            temp[i] = _data[i];
      }
	if( _lastPos < _data.length ) {
	    for( int i = index + 1; i < _data.length; i++ ){
		
		temp[ index ] = newVal;
      temp [i] = _data[i - 1];
       }
	}
	else {
	    expand();
	    for( int i = index + 1; i < _data.length; i++ )
		_data[i] = _data[ i - 1 ];
	    _data[ index ] = newVal;
	}
	_lastPos ++;
	_size    ++;
	_data = temp;
    }

 //removes the item at index
    //shifts elements left to fill in newly-empted slot
 public void remove( int index ) {
    	Comparable [] temp = new Comparable[_data.length];
      if (index > 0){
         for (int i = 0; i<index; i++)
            temp[i] = _data[i];
      } 
 	 if( _lastPos < _data.length ) {
	    for( int i = index + 1; i < _data.length; i++ ){
		temp[ i-1 ] = _data[i];
       }
	}
	_lastPos --;
	_size    --;
	_data = temp;
}


    //return number of meaningful items in _data
 	public int size() {
    return _size;}

    //CompareTo method takes in an object
    public int compareTo( Object o ) {
    	//checks to see if o is an instance of Comparable
	if( o instanceof SuperArray ) {
		//If it is:
	    if( this.size() > ((SuperArray)o).size() ) { return 1; } 
	    else if( this.size() < ((SuperArray)o).size() ) { return -1; }
	    else { return 0; }
	}
	else if( o == null ) {
	    throw new NullPointerException( "compareTo()||ERROR||Input is null" );
	}
	else {
	    throw new ClassCastException( "compareTo()||ERROR||Input is not an instance of SuperArray" );
	}
    }
    
    //LinSearch takes in a Comparable and finds the index of it in the array
    //If the comparable is not in the array, it returns -1.
    public int linSearch( Comparable n ) {
	for( int i = 0; i < _size; i++ ) {
	    if( _data[i].compareTo(n) == 0 ) { return i; }
	}
	return -1;
    }
 
 	//isSorted returns true if the values are increasing
    public boolean isSorted() {
	for( int i = 1; i < _size; i++ ) {
	    if( _data[ i - 1 ].compareTo( _data[i]) == 1 ) {
		return false;
	    }
	}
	return true;
    }


    //main method for testing
  
    public static void main( String[] args ) 
    {
	 
    //~~~~~~~~~~~~~~~~~~RATIONAL~~~~~~~~~~~~~~~~~~~~~~
	SuperArray rational = new SuperArray();

	rational.add( new Rational(2, 4) );
	rational.add( new Rational(2, 5) );
	rational.add( new Rational(2, 6) );	
	rational.add( new Rational(2, 7) );	
	rational.add( new Rational(2, 8) );
	rational.add( new Rational(2, 9) );

	System.out.println();
	System.out.println("RATIONAL SUPERARRAY: ");
	System.out.println(rational);
	
	System.out.println();
	System.out.println( "What is the position of the fraction 2/5?  => " + rational.linSearch( new Rational(2, 5) )); //should be 1
	System.out.println( "What is the position of the fraction 4/57?  => " + rational.linSearch( new Rational(4, 57)) ); //should be -1
	

	System.out.println();
	System.out.println("Lets see if rational is sorted:");
	System.out.println( "Is it sorted? => " + rational.isSorted()); //should be false

	//~~~~~~~~~~~~~~~~~~BINARY~~~~~~~~~~~~~~~~~~~~~~
	SuperArray binary = new SuperArray();

	binary.add( new Binary(2) );
	binary.add( new Binary(4) );	
	binary.add( new Binary(6) );
	binary.add( new Binary(8) );
	binary.add( new Binary(10) );
	binary.add( new Binary(16) );

	System.out.println();
	System.out.println("BINARY SUPERARRAY: ");
	System.out.println(binary);
	
	System.out.println();
	System.out.println( "What is the position of 10? => " + binary.linSearch( new Binary(10) ) ); //should be 0
	System.out.println( "What is the position of 56473 => " + binary.linSearch( new Binary(56473) )  ); //should be -1
	
	System.out.println();
	System.out.println("Lets if binary is sorted :");
	System.out.println( "Is it sorted? => " + binary.isSorted() ); //should be true;

	//~~~~~~~~~~~~~~~~~~BINARY/RATIONAL/HEXADECIMAL~~~~~~~~~~~~~~~~~~~~~~
	SuperArray all = new SuperArray();
	all.add( new Binary(4) );
	all.add( new Hexadecimal(20) );
	all.add( new Binary(8) );
	all.add( new Hexadecimal(32) );
	all.add( new Rational(3, 4) );

	System.out.println();
	System.out.println("MIXED SUPERARRAY: ");
	System.out.println(all);
	
	System.out.println();
	System.out.println( "What is the position of 32? => " + all.linSearch( new Hexadecimal(32) ) );
	System.out.println( "What is the position of 3/4? => " + all.linSearch( new Rational(3, 4) )  );
	
	System.out.println();
	System.out.println("Lets see if all is sorted:");
	System.out.println( "Is it sorted => " + all.isSorted() ); //should be false
	
	
	
	/*  SuperArray zuhra = new SuperArray();
	  System.out.println("Printing empty SuperArray zuhra");
	  System.out.println(zuhra);

	  for( int i = 0; i < zuhra._data.length; i++ ) {
	    zuhra.set(i,i*2);
	    zuhra._size++; //necessary bc no add() method yet
	}

	System.out.println("Printing populated SuperArray zuhra...");
	System.out.println(zuhra);

	System.out.println("testing get()...");
	for( int i = 0; i < zuhra._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( zuhra.get(i) );
	}

	System.out.println("Expanded SuperArray zuhra:");
	zuhra.expand();
	System.out.println(zuhra);

	SuperArray lolzies = new SuperArray();
	System.out.println("Printing empty SuperArray lolzies...");
	System.out.println(lolzies);

	  lolzies.add(5);
	  lolzies.add(4);
	  lolzies.add(3);
	  lolzies.add(2);
	  lolzies.add(1);

	  System.out.println("Printing populated SuperArray lolzies...");
	  System.out.println(lolzies);
      
      System.out.println("Lets test the overridden add method");

      System.out.println("Adding 3 as the 0th element");
	  lolzies.add(0, 3);
	  System.out.println(lolzies);

	  System.out.println("Adding 1 as the 5th element");
	  lolzies.add(1, 5);
	  
	 
	  System.out.println(lolzies);

 	  lolzies.remove(3);
	  
	  System.out.println("Printing SuperArray lolzies post-remove...");
	  System.out.println(lolzies);
	  
	  lolzies.remove(3);
	  System.out.println("Printing SuperArray lolzies post-remove...");
	  System.out.println(lolzies);

	  lolzies.add(3,99);
	  System.out.println("Printing SuperArray lolzies post-insert...");
	  System.out.println(lolzies);
	  lolzies.add(2,88);
	  System.out.println("Printing SuperArray lolzies post-insert...");
	  System.out.println(lolzies);
	  lolzies.add(1,77);
	  System.out.println("Printing SuperArray lolzies post-insert...");
	  System.out.println(lolzies);
	
	  System.out.println(lolzies.size());*/

	//*****INSERT ANY ADDITIONAL TEST CALLS HERE*****

    }//end main
		
}//end class
