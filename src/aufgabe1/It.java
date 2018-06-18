package aufgabe1;

import java.util.Iterator;
import java.util.function.Function;

public class It {
    public static <I, O> Iterable<O> map(Function<I, O> f, Iterable<I> s) {
        return () -> new Iterator<O>() {
            private final Iterator<I> it = s.iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public O next() {
                return f.apply(it.next());
            }
        };
    }

    public static <E> Iterable<E> take(int n, Iterable<E> xs) {
        return xs; // FIXME
    }

    public static void main(String[] args) {
        Iterable<Integer> nats = new Iterable<Integer>() {

            @Override
            public Iterator<Integer> iterator() {

                return new Iterator<Integer>() {

                    private int state = 0;

                    @Override
                    public boolean hasNext() {
                        return true;
                    }

                    @Override
                    public Integer next() {
                        int result = this.state;
                        this.state++;
                        return result;
                    }
                };
            }
        };

        for (int x : take(10, map((x) -> x * x, nats))) {
            System.out.println(x);
        }
    }

}