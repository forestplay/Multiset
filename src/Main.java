import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMultiset<Character> hms = new HashMultiset<>();

        // test no exception if other == null
        HashMultiset<Character> other = null;
        hms.union(other);
        hms.intersect(other);

        // now give it an empty set to start
        other = new HashMultiset<>();

        // test map with zero elements
        System.out.print((hms.getMultiplicity('a') == 0) ? "" : "Error: 0 getMultiplicity failed\n");
        System.out.print((hms.getMultiplicity('b') == 0) ? "" : "Error: 0.1 getMultiplicity failed\n");
        System.out.print((hms.contains('a') == false) ? "" : "Error: 0 getMultiplicity failed\n");
        System.out.print((hms.contains('b') == false) ? "" : "Error: 0.1 getMultiplicity failed\n");
        System.out.print((hms.numberOfUniqueElements() == 0) ? "" : "Error: 1 UniqueElements failed\n");
        System.out.print((hms.size() == 0) ? "" : "Error: 1 size failed\n");
        hms.union(other);
        System.out.print(hms.toStringMinus().equals("{}") ? "" : "Error: 0 union failed\n");
        hms.intersect(other);
        System.out.print(hms.toStringMinus().equals("{}") ? "" : "Error: 0 intersection failed\n");
        System.out.print((hms.size() == 0) ? "" : "Error: 2.1 size failed\n");


        // test map with one element
        hms.add('a');
        System.out.print((hms.getMultiplicity('a') == 1) ? "" : "Error: 1 getMultiplicity failed\n");
        System.out.print((hms.getMultiplicity('b') == 0) ? "" : "Error: 1.1 getMultiplicity failed\n");
        System.out.print((hms.contains('a') == true) ? "" : "Error: 1 getMultiplicity failed\n");
        System.out.print((hms.contains('b') == false) ? "" : "Error: 1.1 getMultiplicity failed\n");
        System.out.print((hms.numberOfUniqueElements() == 1) ? "" : "Error: 1 UniqueElements failed\n");
        System.out.print((hms.size() == 1) ? "" : "Error: 1 size failed\n");
        System.out.print(hms.toStringMinus().equals("{1}") ? "" : "Error: 1 toString failed\n");
        hms.union(other);
        System.out.print(hms.toStringMinus().equals("{1}") ? "" : "Error: 1 union failed\n");
        hms.intersect(other);
        System.out.print(hms.toStringMinus().equals("{}") ? "" : "Error: 1 intersection failed\n");
        hms.remove('a');
        System.out.print((hms.getMultiplicity('a') == 0) ? "" : "Error: 1 remove failed\n");
        System.out.print((hms.size() == 0) ? "" : "Error: 1.1 size failed\n");


        // test map with two elements
        hms.add('a');
        hms.add('b');
        System.out.print((hms.getMultiplicity('a') == 1) ? "" : "Error: 2 getMultiplicity failed\n");
        System.out.print((hms.getMultiplicity('b') == 1) ? "" : "Error: 2.1 getMultiplicity failed\n");
        hms.add('b');
        System.out.print((hms.getMultiplicity('b') == 2) ? "" : "Error: 2.2 getMultiplicity failed\n");
        System.out.print((hms.contains('a') == true) ? "" : "Error: 2 getMultiplicity failed\n");
        System.out.print((hms.contains('b') == true) ? "" : "Error: 2.1 getMultiplicity failed\n");
        System.out.print((hms.numberOfUniqueElements() == 2) ? "" : "Error: 2 UniqueElements failed\n");
        System.out.print((hms.size() == 3) ? "" : "Error: 2 size failed\n");
        System.out.print(hms.toStringMinus().equals("{1, 2}") ? "" : "Error: 2 toString failed\n");
        hms.union(other);
        System.out.print(hms.toStringMinus().equals("{1, 2}") ? "" : "Error: 2 union failed\n");
        hms.intersect(other);
        System.out.print(hms.toStringMinus().equals("{}") ? "" : "Error: 2 intersection failed\n");
        hms.add('a');
        hms.add('b');
        hms.add('b');
        hms.remove('b');
        System.out.print((hms.getMultiplicity('a') == 1) ? "" : "Error: 2 remove failed\n");
        System.out.print((hms.getMultiplicity('b') == 1) ? "" : "Error: 2.1 remove failed\n");
        hms.remove('b');
        System.out.print((hms.getMultiplicity('b') == 0) ? "" : "Error: 2.2 remove failed\n");
        hms.remove('a');
        System.out.print((hms.getMultiplicity('a') == 0) ? "" : "Error: 2.3 remove failed\n");
        System.out.print((hms.size() == 0) ? "" : "Error: 2.1 size failed\n");


        // test map with a bunch elements
        hms.add('a');

        hms.add('b');

        hms.add('c');
        hms.add('c');

        // add one out of order
        hms.add('b');

        hms.add('d');
        hms.add('d');

        hms.add('e');
        hms.add('e');
        hms.add('e');
        hms.add('e');
        System.out.print((hms.toStringMinus().equals("{1, 2, 2, 2, 4}")) ? "" : "Error: 3 equals failed\n");
        System.out.print((hms.numberOfUniqueElements() == 5) ? "" : "Error: 3 unique elements failed\n");
        System.out.print((hms.size() == 11) ? "" : "Error: 3 size failed\n");

        other.add('b');
        other.add('b');

        other.add('c');
        other.add('c');

        other.add('e');
        other.add('e');
        other.add('e');
        other.add('e');

        other.add('f');
        other.add('f');
        other.add('f');
        other.add('f');
        other.add('f');

        other.add('g');
        other.add('g');
        other.add('g');
        other.add('g');
        other.add('g');
        other.add('g');
        System.out.print((other.toStringMinus().equals("{2, 2, 4, 5, 6}")) ? "" : "Error: 4 equals failed\n");
        System.out.print((other.numberOfUniqueElements() == 5) ? "" : "Error: 4 unique elements failed\n");
        System.out.print((other.size() == 19) ? "" : "Error: 4 size failed\n");

        // test union
        hms.union(other);
        System.out.print((hms.toStringMinus().equals("{1, 2, 2, 2, 4, 5, 6}")) ? "" : "Error: 5 equals failed\n");
        System.out.print((hms.numberOfUniqueElements() == 7) ? "" : "Error: 5 unique elements failed\n");
        System.out.print((hms.size() == 22) ? "" : "Error: 5 size failed\n");


        hms = new HashMultiset<>();
        hms.add('a');

        hms.add('b');
        hms.add('b');

        hms.add('c');
        hms.add('c');

        hms.add('d');
        hms.add('d');

        hms.add('e');
        hms.add('e');
        hms.add('e');
        hms.add('e');
        System.out.print((hms.toStringMinus().equals("{1, 2, 2, 2, 4}")) ? "" : "Error: 6 equals failed\n");
        System.out.print((hms.numberOfUniqueElements() == 5) ? "" : "Error: 6 unique elements failed\n");
        System.out.print((hms.size() == 11) ? "" : "Error: 6 size failed\n");
        System.out.print((other.toStringMinus().equals("{2, 2, 4, 5, 6}")) ? "" : "Error: 6.1 equals failed\n");
        System.out.print((other.numberOfUniqueElements() == 5) ? "" : "Error: 6.1 unique elements failed\n");
        System.out.print((other.size() == 19) ? "" : "Error: 6.1 size failed\n");

        // test intersect
        hms.intersect(other);
        System.out.print((hms.toStringMinus().equals("{2, 2, 4}")) ? "" : "Error: 7 equals failed\n");
        System.out.print((hms.numberOfUniqueElements() == 3) ? "" : "Error: 7 unique elements failed\n");
        System.out.print((hms.size() == 8) ? "" : "Error: 7 size failed\n");
        System.out.print((other.toStringMinus().equals("{2, 2, 4, 5, 6}")) ? "" : "Error: 7.1 equals failed\n");
        System.out.print((other.numberOfUniqueElements() == 5) ? "" : "Error: 7.1 unique elements failed\n");
        System.out.print((other.size() == 19) ? "" : "Error: 7.1 size failed\n");
    }
}

interface Multiset<E> {

    /**
     * Add an element to the multiset.
     * It increases the multiplicity of the element by 1.
     */
    void add(E elem);

    /**
     * Remove an element from the multiset.
     * It decreases the multiplicity of the element by 1.
     */
    void remove(E elem);

    /**
     * Unite this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in at least one of the initial multisets.
     * The multiplicity of each element is equal to the maximum multiplicity of
     * the corresponding elements in both multisets.
     */
    void union(Multiset<E> other);

    /**
     * Intersect this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in the both multisets.
     * The multiplicity of each element is equal to the minimum multiplicity of
     * the corresponding elements in the intersecting multisets.
     */
    void intersect(Multiset<E> other);

    /**
     * Returns multiplicity of the given element.
     * If the set doesn't contain it, the multiplicity is 0
     */
    int getMultiplicity(E elem);

    /**
     * Check if the multiset contains an element,
     * i.e. the multiplicity > 0
     */
    boolean contains(E elem);

    /**
     * The number of unique elements,
     * that is how many different elements there are in a multiset.
     */
    int numberOfUniqueElements();

    /**
     * The size of the multiset, including repeated elements
     */
    int size();

    /**
     * The set of unique elements (without repeating)
     */
    Set<E> toSet();
}

class HashMultiset<E> implements Multiset<E> {

    private Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E elem) {
        Integer newValue = 1;
        if (map.containsKey(elem)) {
            newValue = map.get(elem) + 1;
        }
        map.put(elem, newValue);
    }

    @Override
    public void remove(E elem) {
        Integer newValue = 0;
        if (map.containsKey(elem)) {
            newValue = map.get(elem) - 1;
        }
        if (newValue != 0)
            map.put(elem, newValue);
        else
            map.remove(elem);
    }

    @Override
    public void union(Multiset<E> other) {
        if (other != null) {
            for (E key : other.toSet()) {
                if (this.contains(key)) {
                    map.put(key, Math.max(map.get(key), other.getMultiplicity(key)));
                } else {
                    map.put(key, other.getMultiplicity(key));
                }
            }
        }
    }

    @Override
    public void intersect(Multiset<E> other) {
        if (other != null) {
            Set<E> keys = new HashSet<>(map.keySet());
            keys.addAll(other.toSet());
            for (E key : keys) {
                if (this.contains(key) && other.contains(key)) {
                    map.put(key, Math.min(map.get(key), other.getMultiplicity(key)));
                } else {
                    while (this.getMultiplicity(key) > 0)
                        this.remove(key);
                }
            }
        }
    }

    @Override
    public int getMultiplicity(E elem) {
        if (map.containsKey(elem))
            return map.get(elem);
        else
            return 0;
    }

    @Override
    public boolean contains(E elem) {
        return map.containsKey(elem);
    }

    @Override
    public int numberOfUniqueElements() {
        return map.size();
    }

    @Override
    public int size() {
        int size = 0;
        for (E key : map.keySet()) {
            size += map.get(key);
        }
        return size;
    }

    @Override
    public Set<E> toSet() {
        // Creating a new HashSet<> object helps us avoid ConcurrentModificationException.
        // It is thrown when we try to iterate over elements of Map and modify them at the same time
        return new HashSet<>(map.keySet());
    }
    
    public String toStringMinus() {
        StringBuilder values = new StringBuilder("");
        if (map.size() > 0) {
            for (E key : map.keySet()) {
                values.append(map.get(key) + ", ");
            }
            values = new StringBuilder(values.toString().replaceAll(", $", ""));

        }
        return "{" + values + '}';
    }

    public String toStringPlus() {
        StringBuilder values = new StringBuilder("");
        if (map.size() > 0) {
            for (E key : map.keySet()) {
                values.append(key + "=" + map.get(key) + ", ");
            }
            values = new StringBuilder(values.toString().replaceAll(", $", ""));

        }
        return "{" + values + '}';
    }
}