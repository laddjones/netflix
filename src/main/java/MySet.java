import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import java.util.Arrays;
/**
* This class implements the SimpleSet interface
* @param <T> Param Type
* @version 1.0
* @author Edwin Ladd Jones
*/
public class MySet<T> implements Set<T> {

    private T[] backingArray;
    private int numElements;

    /**
    * constructor for MySet
    */
    public MySet() {
        this.backingArray = (T[]) new Object[10];
        numElements = 0;
    }

    /**
    * adds an element to the array
    * @param e the element you want to add
    * @return a boolean of whethere or not it has been added
    */
    public boolean add(T e) {
        if (e == null || contains((Object) e)) {
            return false;
        } else {
            T[] backingArrayLARGER = (T[]) new Object[numElements + 1];
          //  backingArrayLARGER = (T[]) backingArrayLARGER;
            for (int i = 0; i < numElements; i++) {
                backingArrayLARGER[i] = backingArray[i];
            }
            backingArrayLARGER[numElements] = e;
            numElements++;
            backingArray = backingArrayLARGER;
            return true;
        }
    }

    /**
    * adds all element to the array
    * @param c the elements you want to add
    * @return a boolean of whethere or not it has been added
    */
    public boolean addAll(Collection<? extends T> c) {
        boolean finalCheck = true;
        for (T element: c) {
            //checker = add(element);
            if (!(add(element))) {
                finalCheck = false;
            }
        }
        return finalCheck;
    }

    /**
    * clears an element from the array
    */
    public void clear() {
        T[] clearedArray = (T[]) new Object[numElements];
        backingArray = clearedArray;
        numElements = 0;

    }

    /**
    * checks whether or not the array contains and element
    * @param obj the elements you want to check
    * @return a boolean of whether or not it contains the element
    */
    public boolean contains(Object obj) {
        for (int i = 0; i < backingArray.length; i++) {
            if (backingArray[i] != null) {
                if (backingArray[i].equals(obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
    * checks whether or not the array contains all elements
    * @param c the elements you want to check
    * @return a boolean of whether or not it contains all elements
    */
    public boolean containsAll(Collection<?> c) {
        for (Object element: c) {
            if (!(contains(element))) {
                return false;
            }
        }
        return true;
    }

    /**
    * checks whether or not the array two object are equal
    * @param obj the elements you want to check
    * @return a boolean of whether or not they are equal
    */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MySet)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MySet newObject = (MySet) obj;
        if (newObject.size() != this.size()) {
            return false;
        }
        return (newObject.containsAll(this));
    }

    /**
    * creates a hash code for each object
    * @return overalHash an int that is the hash for the obj
    */
    @Override
    public int hashCode() {
        int tempPartialHash;
        int overalHash = 0;
        for (int i = 0; i < numElements; i++) {
            tempPartialHash = backingArray[i].hashCode();
            overalHash += tempPartialHash;
        }
        return overalHash;
    }

    /**
    * checks whether or not the array is empty
    * @return a boolean of whether or not the array is empty
    */
    public boolean isEmpty() {
        return (numElements == 0);
    }

    /**
    * removes an element from the array
    * @param o the object you want to remove
    * @return a boolean of whether or not you removed it
    */
    public boolean remove(Object o) {
        boolean check = false;
        if (o != null && numElements != 0) {
            for (int i = 0; i < numElements; i++) {
                if (backingArray[i].equals(o)) {
                    check = true;
                    backingArray[i] = null;
                    for (int j = i + 1; j < numElements; j++) {
                        backingArray[j - 1] = backingArray[j];
                    }
                    numElements--;
                    return check;
                }
            }
        }
        return false;
    }

    /**
    * removes all the ellements from the array
    * @param c the elements you want to remove
    * @return a boolean of whether or not you could remove them
    */
    public boolean removeAll(Collection<?> c) {
        boolean finalCheck = true;
        for (Object element: c) {
            if (!(remove(element))) {
                finalCheck = false;
            }
        }

        return finalCheck;
    }

    /**
    * retains specified elements in your array
    * @param c the elements you want to retain
    * @return a boolean of whether or not it contains the element
    */
    public boolean retainAll(Collection<?> c) {
        if (numElements != 0) {
            T[] retainArray = (T[]) new Object[c.size()];
            int j = 0;
            for (Object element: c) {
                if (this.contains(element)) {
                    retainArray[j] = (T) element;
                    j++;
                }
            }
            backingArray = Arrays.copyOf(retainArray, j);
            numElements = j;
            return (retainArray[0] != null);
        }
        return false;
    }

    /**
    * returns the size of the array
    * @return numElements the size of your array
    */
    public int size() {
        return numElements;
    }

    /**
    * returns an arry
    * @return arrayReturn the array you want to return
    */
    public Object[] toArray() {
        Object[] arrayReturn = new Object[numElements];
        for (int i = 0; i < numElements; i++) {
            arrayReturn[i] = backingArray[i];
        }
        return arrayReturn;
    }

    /**
    * not used
    * @param <T> a the elements you want to return
    * @param a the elements you input
    * @return null
    */
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
    * returns a custom toString
    * @return printableString a string of your class
    */
    @Override
    public String toString() {
        String printableString = "";
        for (int i = 0; i < numElements; i++) {
            printableString += backingArray[i].toString() + " ";

        }
        return printableString;
    }





    /*
    ----------------------------------------------
    These methods are provided to help you, DO NOT MODIFY!
    Refer to the slides on Iterators if you want to learn more
    http://cs1331.org/slides/iterators.pdf
    */

    /**
    * Returns an iterator if you wish to use it
    * @return An iterator for the SimpleSet
    */
    public Iterator<T> iterator() {
        return new MySetIterator();
    }

    private class MySetIterator implements Iterator {

        private int index = 0;
        public boolean hasNext() {
            return index < numElements;
        }

        public T next() {
            return backingArray[index++];
        }

        public void remove() {
            MySet.this.remove(backingArray[index]);
            index--;
        }
    }

}
