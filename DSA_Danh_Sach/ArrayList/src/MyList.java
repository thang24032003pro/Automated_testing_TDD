import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    // Khởi tạo danh sách với kích thước mặc định (10)
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Khởi tạo danh sách với kích thước tùy chọn ban đầu
    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Kích thước không hợp lệ: " + capacity);
        }
    }

    // Tăng kích thước mảng khi vượt quá giới hạn
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newSize = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    // Thêm phần tử vào cuối danh sách
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    // Thêm phần tử vào một vị trí chỉ định
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        // Dịch chuyển các phần tử sang phải để tạo khoảng trống
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Xóa một phần tử tại vị trí chỉ định và trả về phần tử đó
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldValue = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            // Dịch chuyển các phần tử sang bên trái
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Tránh rò rỉ bộ nhớ (Garbage Collector xử lý)
        return oldValue;
    }

    // Lấy phần tử tại vị trí chỉ định
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    // Kiểm tra danh sách có chứa phần tử o hay không
    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    // Tìm vị trí xuất hiện đầu tiên của phần tử
    public int indexOf(E o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }

    // Trả về số lượng phần tử hiện tại
    public int size() {
        return this.size;
    }

    // Xóa sạch tất cả phần tử trong danh sách
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Nhân bản danh sách hiện tại sang một danh sách mới độc lập
    @SuppressWarnings("unchecked")
    public MyList<E> clone() {
        try {
            MyList<E> v = (MyList<E>) super.clone();
            v.elements = Arrays.copyOf(elements, size);
            v.size = this.size;
            return v;
        } catch (CloneNotSupportedException e) {
            // Fallback thủ công nếu không kế thừa Cloneable
            MyList<E> cloneList = new MyList<>(this.size);
            cloneList.elements = Arrays.copyOf(this.elements, this.size);
            cloneList.size = this.size;
            return cloneList;
        }
    }
}