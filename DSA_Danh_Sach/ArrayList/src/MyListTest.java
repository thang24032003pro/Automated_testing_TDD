public class MyListTest {
    public static void main(String[] args) {
        System.out.println("=== KHỞI TẠO VÀ THÊM PHẦN TỬ ===");
        MyList<String> list = new MyList<>();
        list.add("Java");
        list.add("Python");
        list.add("PHP");

        // Chèn vào vị trí bất kỳ
        list.add(1, "C++");

        // Hiển thị danh sách hiện tại
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Vị trí " + i + ": " + list.get(i));
        }

        System.out.println("\n=== KIỂM TRA TÌM KIẾM VÀ CHỨA ===");
        System.out.println("Kích thước danh sách: " + list.size());
        System.out.println("Có chứa 'Java' không? " + list.contains("Java"));
        System.out.println("Vị trí của 'PHP': " + list.indexOf("PHP"));

        System.out.println("\n=== THỬ NGHIỆM XÓA PHẦN TỬ ===");
        String removedElement = list.remove(2); // Xóa phần tử vị trí số 2 ("Python")
        System.out.println("Đã xóa: " + removedElement);
        System.out.println("Kích thước sau khi xóa: " + list.size());
        System.out.println("Phần tử tại vị trí 2 mới: " + list.get(2));

        System.out.println("\n=== THỬ NGHIỆM BẮT NGOẠI LỆ (BIÊN LỖI) ===");
        try {
            list.get(10); // Thử lấy phần tử ngoài biên
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Bắt lỗi thành công: " + e.getMessage());
        }
    }
}