package Controller;

import Model.User;
import ReadAndWite.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {
    Scanner sc = new Scanner(System.in);
    List<User> userList = new ArrayList<>();
    ReadAndWrite readAndWrite = new ReadAndWrite();

    public List<User> getList(){
        userList = readAndWrite.readFile("user123.txt");
        return userList;
    }

    public  Controller(){
        userList = readAndWrite.readFile("user.txt");
    }

    public String creatName() {
        String name;
        while (true) {
            System.out.println("Nhập Tên");
            name = sc.nextLine();
            Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\"+\n" +
                    "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\"+\n" +
                    "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$");
            if (pattern.matcher(name).find()) {
                break;
            } else {
                System.err.println("Tên phải là chữ và viết hoa chữ cái đầu");
            }
        }
        return name;
    }

    public String creatNumberPhone() {
        String numberPhone;
        while (true) {
            System.out.println("Nhập Số Điện Thoại");
            numberPhone = sc.nextLine();
            Pattern pattern = Pattern.compile("^[0-9]{10}$");
            if (pattern.matcher(numberPhone).find()) {
                break;
            } else {
                System.err.println("Số Điện Thoại phải là số và có 10 số");
            }
        }
        return numberPhone;
    }

    public String creatAddress() {
        String address;
        while (true) {
            System.out.println("Nhập Địa chỉ");
            address = sc.nextLine();
            Pattern pattern = Pattern.compile("^[A-Za-z0-9]{3,}+$");
            if (pattern.matcher(address).find()) {
                break;
            } else {
                System.err.println("Địa chỉ phải là chữ hoặc số và có ít nhất 3 kí tự");
            }
        }
        return address;
    }

    public String creatEmail() {
        String email;
        while (true) {
            System.out.println("Nhập Email");
            email = sc.nextLine();
            Pattern pattern = Pattern.compile("^[A-za-z][A-za-z0-9]+@[A-za-z]+(\\.[A-za-z]+){1,3}$");
            if (pattern.matcher(email).find()) {
                break;
            } else {
                System.err.println("Không đúng định dạng email");
                System.err.println("Email phải bắt đầu bằng chữ");
            }
        }
        return email;
    }

    public String creatFacebook() {
        String facebook;
        while (true) {
            System.out.println("Nhập Tên Facebook");
            facebook = sc.nextLine();
            Pattern pattern = Pattern.compile("^[A-Za-z0-9]{3,}+$");
            if (pattern.matcher(facebook).find()) {
                break;
            } else {
                System.err.println("Facebook phải là chữ hoặc số và có ít nhất 3 kí tự");
            }
        }
        return facebook;
    }

    public String creatSex() {
        System.out.println("Nhập Giới tính");
        String gender = sc.nextLine();
        if (gender.equals("Nam")){
            return "Nam";
        }else if (gender.equals("Nữ")){
            return "Nữ";
        }else {
            return "Không xác định";
        }
    }

    public String creatGroup() {
        System.out.println("Nhập Nhóm GIA ĐÌNH hoặc BẠN BÈ");
        String group = sc.nextLine();
       return group;
    }

    public User creatUser(){
        return new User(creatName(),creatNumberPhone(),creatAddress(),creatEmail(),creatFacebook(),creatGroup(),creatSex());
    }

    public void add(){
        userList.add(creatUser());
        readAndWrite.writer("user.txt",userList);

    }

    public void show(){
        userList = readAndWrite.readFile("user.txt");
        for (int i = 0; i < userList.size(); i++) {
            if (i%5==0 && i != 0){
               sc.nextLine();
            }
            System.out.println(userList.get(i).toString());
        }
    }

    public int findIndexByNumberPhone(){

        String numberPhone = creatNumberPhone();

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getNumberPhone().equals(numberPhone)) {
                return i;
            }
        }
        return -1;
    }

    public void edit(){
        userList = readAndWrite.readFile("user.txt");
        while (true){
            int index = findIndexByNumberPhone();
            if (index >= 0){
                userList.get(index).setName(creatName());
                userList.get(index).setGroup(creatGroup());
                userList.get(index).setEmail(creatEmail());
                userList.get(index).setFacebook(creatFacebook());
                userList.get(index).setAddress(creatAddress());
            }else {
                System.out.println("Không tìm thấy ID");
            }
            System.out.println(" Nhấn Enter để thoát hoặc 1 phím bất kỳ để tiếp tục");
            String out = sc.nextLine();
            if (out.equals("")){
                break;
            }
        }
        readAndWrite.writer("user.txt", userList);

    }

    public void find(){
        userList = readAndWrite.readFile("user.txt");
        System.out.println("Nhập số điện thoại");
        String numberPhone = sc.nextLine();
        for (int i = 0; i < userList.size() ; i++) {
            if (userList.get(i).getNumberPhone().contains(numberPhone)){
                System.out.println(userList.get(i).toString());
            }
            
        }
    }

    public void delete(){
        userList = readAndWrite.readFile("user.txt");
        while (true){
            int index = findIndexByNumberPhone();
            if (index>=0){
                System.out.println("Nhập 'Y' để tiến hành xóa hoặc nhấn phím bất kỳ để trở lại menu");
                String out = sc.nextLine();
                if (out.equalsIgnoreCase("Y")){
                    userList.remove(index);
                }else {
                    return;
                }
                System.out.println("Xóa thông tin thành công");
            }else {
                System.err.println("Không tìm thấy thông tin theo số điện thoại");
            }
            System.out.println(" Nhấn Enter để thoát hoặc 1 phím bất kỳ để tiếp tục");
            String out = sc.nextLine();
            if (out.equals("")){
                break;
            }
        }
        readAndWrite.writer("user.txt", userList);

    }



















}
