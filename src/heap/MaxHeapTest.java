package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by rajeshsubramanian on 3/20/18.
 */
public class MaxHeapTest {

    public static void main( String[] args ) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert( 10 );
        maxHeap.insert( 20 );
        maxHeap.insert( 15 );
        maxHeap.insert( 35 );
        maxHeap.insert( 5 );

        System.out.println(maxHeap.elements);
        maxHeap.delete();
        System.out.println(maxHeap.elements);
    }

}

class MaxHeap<T extends Comparable> {

    List<T> elements;

    public MaxHeap() {
        elements = new ArrayList<>();
    }

    public void insert(T element) {
        elements.add( element );
        siftUp();
    }

    public T delete() throws NoSuchElementException {
        if (elements.size() == 0) {
            throw new NoSuchElementException( "Empty" );
        }
        if (elements.size() == 1 ) {
            return elements.remove( 0 );
        }
        T hold = elements.get( 0 );
        elements.set( 0,  elements.remove( elements.size() - 1 ));
        siftDown();
        return hold;
    }

    private void siftDown() {
        int k = 0;
        int c = 2*k + 1;
        while ( c < elements.size() ) {
             int max = c;
             int r = c + 1;
             if (r < elements.size()) {
                 if ( elements.get( r ).compareTo( elements.get( c ) ) >0 ) {
                     max++;
                 }
             }
             if ( elements.get( k ).compareTo( elements.get( max ) ) < 0) {
                 //swap
                 T temp = elements.get( k );
                 elements.set( k, elements.get( max ) );
                 elements.set( max, temp);
                 k = max;
                 c = 2*k + 1;
             } else {
                 break;
             }
        }


    }

    private void siftUp() {
        int k = elements.size() - 1;

        while (k > 0) {
            int p = (k -1)/2;
            T item = elements.get( k );
            T parent = elements.get( p );

            if (item.compareTo( parent ) > 0) {
                //swap
                elements.set( k, parent );
                elements.set( p, item );
                k = p;
            } else {
                break;
            }
        }
    }
}
