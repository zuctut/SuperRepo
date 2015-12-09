/*****************************

Zuhra Tukhtamisheva 
Partner: Jason Dong4
APCS1 pd5
HW42 --Array of Titanium
Team Name: JZ
2015-12-05
 



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

public class SuperArray implements ListInt {
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private int[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor â€“ initializes 10-item array
    public SuperArray() 
    { 
	_data = new int[10];
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
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public int get( int index ) { return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) 
    { 
 	int temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( int newVal ) { 
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
    public void add( int index, int newVal ) {
    int [] temp = new int[_data.length];
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
    	int [] temp = new int[_data.length];
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
    int counter = 0;
    int i =0;
       while (i <= _lastPos){
    	counter+=1;
          i+=1;}
    return  counter;}


    //main method for testing
    public static void main( String[] args ) 
    {

	  ListInt zuhra = new SuperArray();
	  System.out.println("Printing empty ListInt zuhra");
	  System.out.println(zuhra);

	  for( int i = 0; i < ((SuperArray)zuhra)._data.length; i++ ) {
	    ((SuperArray)zuhra).set(i,i*2);
	    ((SuperArray)zuhra)._size++; //necessary bc no add() method yet
	}

	System.out.println("Printing populated ListInt zuhra...");
	System.out.println(zuhra);

	System.out.println("testing get()...");
	for( int i = 0; i < ((SuperArray)zuhra)._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( ((SuperArray)zuhra).get(i) );
	}

	System.out.println("Expanded ListInt zuhra:");
	((SuperArray)zuhra).expand();
	System.out.println(zuhra);

	ListInt lolzies = new SuperArray();
	System.out.println("Printing empty ListInt lolzies...");
	System.out.println(lolzies);

	  ((SuperArray)lolzies).add(5);
	  ((SuperArray)lolzies).add(4);
	  ((SuperArray)lolzies).add(3);
	  ((SuperArray)lolzies).add(2);
	  ((SuperArray)lolzies).add(1);

	  System.out.println("Printing populated ListInt lolzies...");
	  System.out.println(lolzies);
      
      System.out.println("Lets test the overridden add method");

      System.out.println("Adding 3 as the 0th element");
	  ((SuperArray)lolzies).add(0, 3);
	  System.out.println(lolzies);

	  System.out.println("Adding 1 as the 5th element");
	  ((SuperArray)lolzies).add(1, 5);
	  
	 
	  System.out.println(lolzies);

 	  ((SuperArray)lolzies).remove(3);
	  
	  System.out.println("Printing ListInt lolzies post-remove...");
	  System.out.println(lolzies);
	  
	  ((SuperArray)lolzies).remove(3);
	  System.out.println("Printing ListInt lolzies post-remove...");
	  System.out.println(lolzies);

	  ((SuperArray)lolzies).add(3,99);
	  System.out.println("Printing ListInt lolzies post-insert...");
	  System.out.println(lolzies);
	  ((SuperArray)lolzies).add(2,88);
	  System.out.println("Printing ListInt lolzies post-insert...");
	  System.out.println(lolzies);
	  ((SuperArray)lolzies).add(1,77);
	  System.out.println("Printing ListInt lolzies post-insert...");
	  System.out.println(lolzies);
	
	  System.out.println(((SuperArray)lolzies).size());

	//*****INSERT ANY ADDITIONAL TEST CALLS HERE*****

    }//end main
		
}//end class