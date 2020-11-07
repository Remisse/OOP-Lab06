package it.unibo.oop.lab06.generics1;

/**
 *
 */
public final class UseGraph {

    private UseGraph() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String... args) {
        final Graph<String> g = new GraphImpl<>();
        g.addNode("a");
        g.addNode("b");
        g.addNode("c");
        g.addNode("d");
        g.addNode("e");
        g.addNode("f");
        g.addNode("g");
        g.addNode("h");
        g.addEdge("a", "b");
        g.addEdge("b", "c");
        g.addEdge("c", "d");
        g.addEdge("d", "e");
        g.addEdge("c", "a");
        g.addEdge("e", "a");
        g.addEdge("c", "g");
        g.addEdge("f", "d");
        g.addEdge("h", "a");
        g.addEdge("h", "b");
        g.addEdge("b", "g");
        g.addEdge("e", "h");
        /*
         * Should print ["a","b","c","d","e"], in any order
         */
        System.out.println(g.nodeSet());
        /*
         * ["d","a"], in any order
         */
        System.out.println(g.linkedNodes("c"));
        /*
         * Must print either the path b,c,a or b,c,d,e,a
         */
        System.out.println(g.getPath("b", "a"));
    }
}
