public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("=== THỬ NGHIỆM THÊM PHẦN TỬ ===");
        MyLinkedList<String> list = new MyLinkedList<>("Node_Gốc");
        list.addFirst("Đầu_1");
        list.addFirst("Đầu_2");
        list.addLast("Cuối_1");
        list.add(2, "Chèn_Giữa"); // Chèn vào vị trí số 2

        list.printList();
        System.out.println("Kích thước hiện tại: " + list.size());

        System.out.println("\n=== KIỂM TRA TÌM KIẾM ===");
        System.out.println("Vị trí của 'Chèn_Giữa': " + list.indexOf("Chèn_Giữa"));
        System.out.println("Có chứa 'Cuối_1' không? " + list.contains("Cuối_1"));

        System.out.println("\n=== THỬ NGHIỆM XÓA PHẦN TỬ ===");
        list.remove(1); // Xóa theo vị trí
        System.out.println("Sau khi xóa tại index 1:");
        list.printList();

        list.remove("Cuối_1"); // Xóa theo đối tượng
        System.out.println("Sau khi xóa đối tượng 'Cuối_1':");
        list.printList();

        System.out.println("\n=== THỬ NGHIỆM KHẢ NĂNG CLONE ===");
        MyLinkedList<String> clonedList = list.clone();
        System.out.print("Danh sách nhân bản: ");
        clonedList.printList();
    }
}