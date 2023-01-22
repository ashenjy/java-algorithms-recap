package algorithms.unionfind;
/******************************************************************************
 * Coursera - Algorithms Part II
 *
 * Week 1 - Interview Questions
 *
 * Union-find with specific canonical element. Add a method find() to the
 * union-find data type so that find(i) returns the largest element in the
 * connected component containing i. The operations, union(), connected(), and
 * find() should all take logarithmic time or better.
 *
 * For example, if one of the connected components is {1,2,6,9}, then the find()
 * method should return 9 for each of the four elements in the connected
 * components because 9 is larger 1, 2, and 6.
 ******************************************************************************/


/******************************************************************************
 *  Compilation:  javac WeightedQuickUnionUF.java
 *  Execution:  java WeightedQuickUnionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Weighted quick-union (without path compression).
 *
 ******************************************************************************/

import java.util.Scanner;

/**
 *  The <tt>WeightedQuickUnionUF</tt> class represents a union-find data structure.
 *  It supports the <em>union</em> and <em>find</em> operations, along with
 *  methods for determinig whether two objects are in the same component
 *  and the total number of components.
 *  <p>
 *  This implementation uses weighted quick union by size (without path compression).
 *  Initializing a data structure with <em>N</em> objects takes linear time.
 *  Afterwards, <em>union</em>, <em>find</em>, and <em>connected</em> take
 *  logarithmic time (in the worst case) and <em>count</em> takes constant
 *  time.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/15uf">Section 1.5</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class WeightedQuickUnionUF {

    private int[] parent;   // parent[i] = parent of i
    private int[] size;     // size[i] = number of objects in subtree rooted at i
    private int[] max;		// max[i] = largest element in subtree rooted at i
    private int count;      // number of components

    /**
     * Initializes an empty union-find data structure with N isolated components 0 through N-1.
     * @param N the number of objects
     * @throws java.lang.IllegalArgumentException if N < 0
     */
    WeightedQuickUnionUF(int N){
        parent = new int[N];
        size = new int[N];
        max = new int[N];
        count = N;

        for(int i=0; i < N; i++){
            parent[i] = i;
            size[i] = 1;
            max[i] = i;
        }
    }

    /**
     * Returns the component identifier for the component containing site <tt>p</tt>.
     * @param p the integer representing one site
     * @return the component identifier for the component containing site <tt>p</tt>
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= p < N
     */
    public int find(int p) {
        validate(p);
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int N = parent.length;
        if (p < 0 || p >= N) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + N);
        }
    }

    /**
     * Are the two sites <tt>p</tt> and <tt>q</tt> in the same component?
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return <tt>true</tt> if the two sites <tt>p</tt> and <tt>q</tt>
     *    are in the same component, and <tt>false</tt> otherwise
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    /**
     * Returns the number of components.
     * @return the number of components (between 1 and N)
     */
    public int count() {
        return count;
    }

    public int findMax(int p) {
        int rootP = find(p);
        return max[rootP];
    }

    /**
     * Merges the component containing site<tt>p</tt> with the component
     * containing site <tt>q</tt>.
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return; //if connected

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
            max[rootQ] = Math.max(max[rootP], max[rootQ]);
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
            max[rootP] = Math.max(max[rootP], max[rootQ]);
        }
        count--;
    }

    /**
     * Reads in a sequence of pairs of integers (between 0 and N-1) from standard input,
     * where each integer represents some object;
     * if the objects are in different components, merge the two components
     * and print the pair to standard output.
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);

        while(sc.hasNext()){
            int p = sc.nextInt();
            int q = sc.nextInt();
            if(!uf.connected(p,q)){
                uf.union(p,q);
                System.out.println(p + " " + q);
            }
        }
        System.out.println(uf.count() + " components");

        for(int i = 0; i < N; ++i) {
            System.out.println("Max: " + i + " = " + uf.findMax(i));
        }
    }

}
