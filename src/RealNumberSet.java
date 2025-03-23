public class RealNumberSet {
    private double[] elements;
    private int size;
    private int capacity;

    public RealNumberSet(int capacity) {
        this.capacity = capacity;
        this.elements = new double[capacity];
        this.size = 0;
    }

    public boolean contains(double value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return true;
            }
        }
        return false;
    }

    public boolean add(double value) {
        if (contains(value)) {
            return false;
        }
        if (size >= capacity) {
            return false;
        }
        elements[size++] = value;
        return true;
    }

    public boolean remove(double value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public RealNumberSet union(RealNumberSet other) {
        RealNumberSet result = new RealNumberSet(this.size + other.size);
        for (int i = 0; i < this.size; i++) {
            result.add(this.elements[i]);
        }
        // Добавляем элементы из другого множества (если их ещё нет)
        for (int i = 0; i < other.size; i++) {
            result.add(other.elements[i]);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RealNumberSet other = (RealNumberSet) obj;
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (!other.contains(this.elements[i])) {
                return false;
            }
        }
        return true;
    }
}
