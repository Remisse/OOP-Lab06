package it.unibo.oop.lab.collections1;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
import java.util.*;

public final class UseCollection {
	
	private static final int READS = 1000;
	private static final int ELEMS = 100_000;
    private static final int TO_MS = 1_000_000;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	final List<Integer> list1 = new ArrayList<>();
    	
    	for (int i = 1000; i < 2000; i++) {
    		list1.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	final List<Integer> list2 = new LinkedList<>(list1);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	Integer temp;
    	
    	temp = list1.get(0);
    	list1.set(0, list1.get(list1.size()-1));
    	list1.set(list1.size()-1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for (Integer elem : list1) {
    		System.out.println(elem);
    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long time = System.nanoTime();
    	
    	for (int i = 0; i < ELEMS; i++) {
    		list1.add(0, i);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("\nArrayList INSERTION:\t" + time / TO_MS + " ms");
    	
    	time = System.nanoTime();
    	for (int i = 0; i < ELEMS; i++) {
    		list2.add(0, i);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("LinkedList INSERTION:\t" + time / TO_MS + " ms");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	int halfSize = list1.size() / 2;
    	
    	time = System.nanoTime();
    	for (int i = 0; i < READS; i++) {
    		list1.get(halfSize);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("\nArrayList READ:\t\t" + time / TO_MS + " ms");
    	
    	halfSize = list2.size() / 2;
    	time = System.nanoTime();
    	for (int i = 0; i < READS; i++) {
    		list2.get(halfSize);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("LinkedList READ:\t" + time / TO_MS + " ms");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	Map<String, Long> continents = new HashMap<>();
    	
    	continents.put("Africa", 1_110_635_000L);
    	continents.put("Americas", 972_005_000L);
    	continents.put("Antarctica", 0L);
    	continents.put("Asia", 4_298_723_000L);
    	continents.put("Europe", 742_452_000L);
    	continents.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
    	Long total = 0L;
    	
    	for (Long pop : continents.values()) {
    		total = total + pop;
    	}
    	System.out.println("\nWorld population: " + total);
    }
}
