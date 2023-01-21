package algorithms.hashtables;

import java.util.HashSet;

/*Immutable data type for US phone numbers.
* with an area @code (3 digits), exchange (3 digits),
 *  and extension (4 digits).
 * */
public class PhoneNumber {
    private final int area;   // area @code (3 digits)
    private final int exch;   // exchange  (3 digits)
    private final int ext;    // extension (4 digits)

    /**
     * Initializes a new phone number.
     *
     * @param  area the area @code (3 digits)
     * @param  exch the exchange (3 digits)
     * @param  ext  the extension (4 digits)
     */
    public PhoneNumber(int area, int exch, int ext){
        this.area = area;
        this.exch = exch;
        this.ext = ext;
    }

    /**
     * Compares this phone number to the specified phone number.
     *
     * @param  other the other phone number
     * @return {@code true} if this phone number equals {@code other};
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object other) {
        return super.equals(other);
    }
    /**
     * Returns a string representation of this phone number.
     */
    @Override
    public String toString() {
        // 0 for padding with digits with leading 0s
        return String.format("(%03d) %03d-%04d", area, exch, ext);
    }
    /**
     * Returns an integer hash code for this phone number.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Unit tests the {@code PhoneNumber} data type.
     */
    public static void main(String[] args) {
        PhoneNumber a = new PhoneNumber(609, 258, 4455);
        PhoneNumber b = new PhoneNumber(609, 876, 5309);
        PhoneNumber c = new PhoneNumber(609, 555, 5309);
        PhoneNumber d = new PhoneNumber(215, 876, 5309);
        PhoneNumber e = new PhoneNumber(609, 876, 5309);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);

        HashSet<PhoneNumber> set = new HashSet<PhoneNumber>();
        set.add(a);
        set.add(b);
        set.add(c);
        System.out.println("Added a, b, and c");
        System.out.println("contains a:  " + set.contains(a));
        System.out.println("contains b:  " + set.contains(b));
        System.out.println("contains c:  " + set.contains(c));
        System.out.println("contains d:  " + set.contains(d));
        System.out.println("contains e:  " + set.contains(e));
        System.out.println("b == e:      " + (b == e));
        System.out.println("b.equals(e): " + (b.equals(e)));
    }

}
