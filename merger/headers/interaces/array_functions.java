package merger.headers.interaces;

public interface array_functions
{
    /* This Interface lists the functions for defining a dynamic array.Though the maximum size of the array is specified by max_capacity*/
    final int max_capacity = 100000000;

    public int[] split(int start,int end);

    /* returns a subarray from [start , end]*/
    public void push_back(int ele);

    /* inserts an element ele at the end of the array*/

    public void erase(int pos);

    /* deletes the element at position pos*/

   public  int[] toarray();

    /* returns an array object of the v_array object*/

     public boolean empty();

    /* returns true if the array is empty*/

    
    public int at(int pos);

    /* returns the element at position pos*/
}
