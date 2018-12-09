package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Fibonacci {

    class FibonacciIterable implements Iterable<Long> {

        LinkedList<Long> list = new LinkedList<>();

        public void add(Long num) {
            list.add(num);
        }

        @Override
        public Iterator<Long> iterator() {
            return new FibonacciIterator(list);
        }
    }

    class FibonacciIterator implements Iterator<Long> {

        private LinkedList<Long> list;
        private int index = 0;

        public FibonacciIterator(LinkedList<Long> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {

            if (list.size() >= index + 1)  {
                return true;
            }
            return false;
        }

        @Override
        public Long next() {
            Long value = list.get(index);
            index++;
            return value;
        }


    }

    public static void main(String[] args) {

        Fibonacci fib = new Fibonacci();

        fib.invoke(5);


    }

    private long fibonacci(long value, FibonacciIterable iterable) {
        if (value == 0 || value == 1) {
            //iterable.add(value);
            return value;
        }
        long temp = fibonacci(value - 1, iterable) + fibonacci(value - 2, iterable);
        iterable.add(temp);
        return temp;
    }

    public void invoke(long value) {

        FibonacciIterable iterable = new FibonacciIterable();

        fibonacci(value, iterable);

        for (Long val : iterable) {
            System.out.println(val);
        }

    }

}
