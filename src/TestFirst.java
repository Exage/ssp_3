public class TestFirst {
    public static void main(String[] args) {
        RealNumberSet set1 = new RealNumberSet(5);
        RealNumberSet set2 = new RealNumberSet(5);

        set1.add(1.1);
        set1.add(2.2);
        set1.add(3.3);

        set2.add(3.3);
        set2.add(4.4);
        set2.add(5.5);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        RealNumberSet unionSet = set1.union(set2);
        System.out.println("Union set 1 and set 2: " + unionSet);

        double valueToCheck = 2.2;
        System.out.println("Set 1 contains " + valueToCheck + "? " + set1.contains(valueToCheck));

        set1.remove(2.2);
        System.out.println("Set 1 after remove " + valueToCheck + ": " + set1);

        RealNumberSet set3 = new RealNumberSet(5);
        set3.add(1.1);
        set3.add(3.3);
        System.out.println("Init Set 3: " + set3);

        System.out.println("Set 1 equals Set 3? " + set1.equals(set3));
    }
}
