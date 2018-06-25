package heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by rajeshsubramanian on 3/20/18.
 */
public class MinHeapTest {

    public static void main( String[] args ) {

        MinHeap heap = new MinHeap();
        heap.insert( 40 );
        heap.insert( 20 );
        heap.insert( 30 );
        heap.insert( 10 );
        heap.insert( 15 );

        System.out.println(heap.items);

        heap.delete();
        heap.delete();
        heap.delete();

        System.out.println(heap.items);

    }


}

class MinHeap<T extends Comparable> {

    ArrayList<T> items;

    public MinHeap () {
        items = new ArrayList<>();
    }

    public void insert(T item) {
        items.add( item );
        siftUp();
    }

    public T delete() throws NoSuchElementException{
        if (items.size() == 0) {
            throw new NoSuchElementException( "Empty" );
        }
        if (items.size() == 1) {
            return items.remove( 0 );
        }
        T hold = items.get( 0 );
        items.set( 0, items.remove( items.size() - 1 ) );
        siftDown();

        return hold;
    }

    private void siftDown() {

        int k = 0;
        int l = 2*k+1;
        while ( l < items.size() ) {
            int max = l;
            int r = l+1;
            if (r < items.size()) {
                if (items.get( l ).compareTo( items.get( r ) ) > 0 ) {
                    max = r;
                }
            }
            if (items.get( k ).compareTo( items.get( max ) ) > 0) {
                T temp = items.get( k );
                items.set( k, items.get( max ) );
                items.set( max, temp );
                k = max;
                l = 2*k+1;
            } else {
                break;
            }


        }
    }

    private void siftUp() {

        int k = items.size() - 1;
        while ( k > 0 ) {
            int p = (k -1)/2;
            T item = items.get( k );
            T parent = items.get( p );
            if (parent.compareTo( item ) > 0) {
                items.set( k, parent );
                items.set(p, item);
                k = p;
            } else {
                break;
            }
        }
    }

}
