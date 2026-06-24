public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    // Lớp nội Node đại diện cho một mắt xích trong danh sách
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    // Khởi tạo không tham số (Danh sách rỗng)
    public MyLinkedList() {
    }

    // Khởi tạo một tham số (Khởi tạo node đầu tiên trong danh sách)
    public MyLinkedList(E data) {
        head = new Node(data);
        numNodes++;
    }

    // Thêm phần tử mới vào đầu danh sách
    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }

    // Thêm phần tử mới vào cuối danh sách
    public void addLast(E e) {
        if (head == null) {
            addFirst(e);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numNodes++;
    }

    // Thêm đối tượng vào vị trí thứ index chỉ định
    public void add(int index, E element) {
        if (index <= 0) {
            addFirst(element);
            return;
        }
        if (index >= numNodes) {
            addLast(element);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        Node holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= numNodes || head == null) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }

        Node temp = head;
        Object data;

        if (index == 0) {
            data = head.data;
            head = head.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
        }
        numNodes--;
        return (E) data;
    }

    // Xóa một phần tử dựa trên đối tượng cho trước
    public boolean remove(Object o) {
        if (head == null)
            return false;

        if ((o == null && head.data == null) || (o != null && o.equals(head.data))) {
            head = head.next;
            numNodes--;
            return true;
        }

        Node temp = head;
        while (temp.next != null) {
            if ((o == null && temp.next.data == null) || (o != null && o.equals(temp.next.data))) {
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Lấy dữ liệu của phần tử ở vị trí index
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    // Trả về số lượng các phần tử có trong danh sách
    public int size() {
        return this.numNodes;
    }

    // Kiểm tra phần tử o có nằm trong danh sách không
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    // Trả về vị trí xuất hiện đầu tiên của phần tử o, nếu không tìm thấy trả về -1
    public int indexOf(Object o) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if ((o == null && temp.data == null) || (o != null && o.equals(temp.data))) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> cloneList = new MyLinkedList<>();
        if (this.head == null)
            return cloneList;

        cloneList.head = new Node(this.head.data);
        cloneList.numNodes++;

        Node current = this.head.next;
        Node cloneCurrent = cloneList.head;

        while (current != null) {
            cloneCurrent.next = new Node(current.data);
            cloneCurrent = cloneCurrent.next;
            cloneList.numNodes++;
            current = current.next;
        }
        return cloneList;
    }
}