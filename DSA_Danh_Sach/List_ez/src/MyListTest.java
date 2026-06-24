public class MyListTest {
    public static void main(String[] args) {
        // Bước 7 - Trường hợp 1: Tạo đối tượng listInteger chứa danh sách các số nguyên
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);

        System.out.println("--- Trường hợp 1: Hiển thị các phần tử hợp lệ ---");
        System.out.println("element 4: " + listInteger.get(4));
        System.out.println("element 1: " + listInteger.get(1));
        System.out.println("element 2: " + listInteger.get(2));

        // Thử nghiệm phần tử vượt quá số phần tử được thêm vào (index 6)
        try {
            System.out.println("\nThử nghiệm lấy phần tử vượt biên (index 6):");
            listInteger.get(6);
            System.out.println("element 6: " + listInteger.get(6));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ngoại lệ xảy ra: " + e.getMessage());
        }

        System.out.println("\n------------------------------------------------");

        // Bước 7 - Trường hợp 2: Hiển thị phần tử ở vị trí -1
        try {
            System.out.println("--- Trường hợp 2: Thử nghiệm lấy phần tử ở vị trí -1 ---");
            listInteger.get(-1);
            System.out.println("element -1: " + listInteger.get(-1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ngoại lệ xảy ra: " + e.getMessage());
        }
    }
}