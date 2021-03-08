package org.denamyte.hyperskill.structures.multiset;

import java.util.*;
import java.util.stream.Collectors;

class HashMultiset<E> implements Multiset<E> {

    private Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E elem) {
        map.put(elem, getMultiplicity(elem) + 1);
    }

    @Override
    public void remove(E elem) {
        final int count = getMultiplicity(elem);
        if (count > 0) {
            if (count == 1) {
                map.remove(elem);
            } else {
                map.put(elem, count - 1);
            }
        }
    }

    @Override
    public void union(Multiset<E> other) {
        other.toSet().forEach(elem -> map.compute(
                elem, (key, count) -> Math.max(other.getMultiplicity(elem), count == null ? 0 : count)));
    }

    @Override
    public void intersect(Multiset<E> other) {
        map = map.entrySet().stream()
                .peek(en -> en.setValue(Math.min(en.getValue(), other.getMultiplicity(en.getKey()))))
                .filter(en -> en.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k1, k2) -> k1, HashMap::new));
    }

    @Override
    public int getMultiplicity(E elem) {
        return map.getOrDefault(elem, 0);
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
        return map.values().stream().reduce(0, Integer::sum);
    }

    @Override
    public Set<E> toSet() {
        return new HashSet<>(map.keySet());
    }

    public static void main(String[] args) {
        HashMultiset<String> multiset = new HashMultiset<>();
        // Testing add
        multiset.add("aa");
        multiset.add("aa");
        multiset.add("bb");
        System.out.println("Testing add: " + multiset.map);
        // Testing remove
        multiset.remove("cc");  // no effect
        multiset.remove("bb");  // bb is removed now
        multiset.remove("aa");  // a has multiplicity 1
        System.out.println("Testing remove (removed cc(1), bb(1), aa(1)): " + multiset.map);
        // Testing getMultiplicity
        multiset.add("bb");
        multiset.add("bb");
        System.out.println("Testing getMultiplicity of 'aa'(exp. 1): " + multiset.getMultiplicity("aa"));
        System.out.println("Testing getMultiplicity of 'bb'(exp. 2): " + multiset.getMultiplicity("bb"));
        System.out.println("Testing getMultiplicity of 'cc'(exp. 0): " + multiset.getMultiplicity("cc"));
        // Testing numberOfUniqueElements
        System.out.println("Testing numberOfUniqueElements (exp. 2): " + multiset.numberOfUniqueElements());
        // Testing size
        for (int i = 0; i < 3; i++) {
            multiset.add("cc");
        }
        System.out.println("Testing size (aa=1, bb=2, cc=3, exp. 6): " + multiset.size());
        // Testing toSet
        System.out.println("Testing toSet (exp. [aa, bb, cc], any order): " + multiset.toSet());
        // Testing union
        Multiset<String> other = new HashMultiset<>();
        other.add("aa");
        other.add("aa");
        other.add("bb");
        other.add("dd");
        other.add("dd");
        multiset.union(other);
        System.out.println("Testing union [aa=1, bb=2, cc=3] + [aa=2, bb=1, dd=2]: " + multiset.map);
        // Testing intersect
        multiset = new HashMultiset<>();
        multiset.add("aa");
        multiset.add("bb");
        multiset.add("bb");
        multiset.add("cc");
        multiset.add("cc");
        multiset.add("cc");
        multiset.intersect(other);
        System.out.println("Testing intersect [aa=1, bb=2, cc=3] & [aa=2, bb=1, dd=2]: " + multiset.map);
    }
}
