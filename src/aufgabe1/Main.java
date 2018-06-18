package aufgabe1;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

    /**
     * FIXME
     * @param xs
     * @param ys
     * @param <A>
     * @param <B>
     * @return
     */
    public static <A, B> Iterable<Pair<A, B>> rectangle(Iterable<A> xs, Iterable<B> ys) {
        return () -> new Iterator<Pair<A, B>>() {
            private final Iterator<A> it1 = xs.iterator();
            private final Iterator<B> it2 = ys.iterator();

            @Override
            public boolean hasNext() {
                return it1.hasNext();
            }

            @Override
            public Pair<A, B> next() {
                return new Pair<>(it1.next(), it2.next());
            }
        };
    }

    /**
     * FIXME
     * @param xs height of the rectangle
     * @param ys width of the rectangle
     * @return some Iterable Object. No idea what the base function was supposed to do?
     *         How do I start C# in IntelliJ?
     */
    public static Iterable<Pair<Integer, Integer>> rectangle(int xs, int ys) {
        return () -> new Iterator<Pair<Integer, Integer>>() {
            private int state = 0;

            @Override
            public boolean hasNext() {
                return state<ys;
            }

            @Override
            public Pair<Integer, Integer> next() {
                int ysResult = this.state;
                this.state++;
                Iterator<Integer> what = new Iterator<Integer>() {
                    private int state = 0;

                    @Override
                    public boolean hasNext() {
                        return state < xs;
                    }

                    @Override
                    public Integer next() {
                        int result = this.state;
                        state++;
                        return result;
                    }
                };
                return new Pair<>(what.next(), ysResult);
            }
        };
    }

    public static void main(String[] args) {
        /**
         * using anonymous rectangle method
         * FIXME
         */
        Iterable<Integer> links = Arrays.asList(0,1,2,3);
        Iterable<Integer> rechts = Arrays.asList(0,1,2,3,4);
        for (Pair<?,?> p : rectangle(links, rechts)) {
            System.out.println(p);
        }

        /**
         * FIXME
         * using int rectangle method
         */
        for (Pair<Integer,Integer> p : rectangle(3,4)) {
            System.out.println(p);
        }
    }
}
