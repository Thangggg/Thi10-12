package View;

import Controller.Controller;
import ReadAndWite.ReadAndWrite;
import javafx.scene.transform.Scale;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controller controller = new Controller();
        ReadAndWrite readAndWrite = new ReadAndWrite();
        while (true){
            System.out.println("Chương trình quản lý danh bạ");
            System.out.println("1.Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Đọc file");
            System.out.println("6. Ghi File");
            System.out.println("7. Xóa");
            System.out.println("0. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    controller.show();
                    break;
                case 2:
                    controller.add();
                    break;
                case 3:
                    controller.edit();
                    break;
                case 4:
                    controller.find();
                    break;
                case 5:
                    readAndWrite.readFile("user123.txt");
                case 6:
                    readAndWrite.writer("user123.txt", controller.getList());
                    break;
                case 7:
                    controller.delete();
                    break;
                case 0:
            }
        }
    }
}
