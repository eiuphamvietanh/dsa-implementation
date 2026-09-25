public class MyArrayList<T> {
    private Object[] data;
    private int size;
    private int capacity;

    public MyArrayList() {
        capacity = 10;
        data = new Object[capacity];
        size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) data[index];
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        data[index] = value;

    }

    public void append(T value) {
        if (size == capacity) {
            resize();
        }
        data[size] = value;
        size++;
    }

    public void insertAt(int index, T value) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == capacity) {
            resize();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    public void removeAt(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        /// 3 4 7 8 3 datt
        /// 0 1 2 3 4 5
        /// remove index 2
        /// size = 6
        ///
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size - 1] = null;
        size--;
    }

    private void resize() {
        capacity = capacity * 2;
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == null ? value == null : data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1)
                sb.append(", ");
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.append(i);
        }
        System.out.println(list); //  [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println("size=" + list.size() + ", capacity=" + list.capacity);

        list.insertAt(3, 99);
        System.out.println(list); // [0, 1, 2, 99, 3, 4, 5, 6, 7, 8, 9]

        list.removeAt(0);
        System.out.println(list); // [1, 2, 99, 3, 4, 5, 6, 7, 8, 9]

        System.out.println(list.contains(99)); // true
        System.out.println(list.indexOf(5)); // 

    }
}