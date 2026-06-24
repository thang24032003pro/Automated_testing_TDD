import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    // Bước 2: Phương thức khởi tạo không tham số
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Bước 3: Cài đặt phương thức thay đổi số phần tử tối đa (tăng gấp đôi kích
    // thước mảng)
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    // Bước 4: Cài đặt phương thức thêm một phần tử mới vào cuối danh sách
    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    // Bước 5: Cài đặt phương thức truy cập một phần tử trong danh sách
    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size);
        }
        return (E) elements[i];
    }
}