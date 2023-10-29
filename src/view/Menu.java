package view;


import manager.AccountManager;
import manager.EmployeeManager;
import model.Account;
import model.Employee;
import validate.ValidatorEmployee;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.spi.CurrencyNameProvider;

public class Menu {
    private AccountManager accountManager = new AccountManager();
    private EmployeeManager list = new EmployeeManager();
    private Scanner input = new Scanner(System.in);
    private String currentUsername ;

    public void showMainMenu() {
        int choice;
        while (true) {
            System.out.println("-----Đăng nhập-----\n" +
                    "1. Đăng nhập\n" +
                    "2. Đăng ký\n");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = ValidatorEmployee.getInputInt();
            switch (choice) {
                case 1:
                    showMenuLogin();
                    break;
                case 2:
                    showMenuSignUp();
                    break;
                default:
                    System.out.println("Nhập lại!!!");
            }
        }
    }

    public void showMenuSignUp() {
        System.out.println("\n-----Đăng ký-----");
        System.out.print("Nhập tài khoản: ");
        String username = ValidatorEmployee.getInputUser_Pass();
        System.out.print("Nhập mật khẩu: ");
        String password = ValidatorEmployee.getInputUser_Pass();
        System.out.print("Nhập họ tên: ");
        String name = ValidatorEmployee.getInputString();
        System.out.print("Nhập số điện thoại: ");
        String phone = ValidatorEmployee.getInputPhone();
        System.out.print("Nhập địa chỉ: ");
        String address = ValidatorEmployee.getInputString();
        System.out.print("Nhập email: ");
        String email = ValidatorEmployee.getInputEmail();
        System.out.print("Nhập tuổi: ");
        int age = ValidatorEmployee.getInputInt();
        Account account = new Account(username, password, name, phone, address, email, age);
        accountManager.add(account);
        System.out.println("\n==> Đăng ký thành công!!!\n");
    }

    public void showMenuLogin() {
        while (true) {
            System.out.println("\n-----Đăng nhập-----");
            System.out.print("Nhập tài khoản: ");
            currentUsername = ValidatorEmployee.getInputString();
            System.out.print("Nhập mật khẩu: ");
            String password = ValidatorEmployee.getInputString();
            if (accountManager.hasAlready(currentUsername, password)) {
                System.out.println("\n==> Đăng nhập thành công!!!\n");
                showMainMenuNv();
            } else {
                System.out.println("Sai tài khoản hoặc mật khẩu. Nhập lại!!!");
            }
        }
    }

    public void showMainMenuNv() {
        int choice;
        while (true) {
            System.out.println("---Quản Lí Nhân Sự---\n" +
                    "0.Hiển thị thông tin nhân viên\n"+
                    "1.Thêm nhân viên \n" +
                    "2.Tìm kiếm nhân viên \n" +
                    "3.Kiểm tra trạng thái nhân viên \n" +
                    "4.Sửa thông tin nhân viên \n" +
                    "5.Xóa thông tin nhân viên \n" +
                    "6.Hiển thị danh sách nhân viên theo trang thái:  \n" +
                    "7.Thông tin tài khoản \n" +
                    "8.Đăng xuất ");
            System.out.println("Nhập lựa chọn của bạn :");
            try {
                choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 0:
                        showAll();
                        break;
                    case 1:
                        showMenuAdd();
                        break;
                    case 2:
                        showMenuSearchByName();
                        break;
                    case 3:
                        showMenuCheckStatus();
                        break;
                    case 4:
                        showMenuEdit();
                        break;
                    case 5:
                        showMenuDelete();
                        break;
                    case 6:
                        showMenuStatus();
                        break;
                    case 7:
                        showAccountInformation();
                        break;
                    case 8:
                        showMainMenu();
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("VUI LÒNG NHẬP SỐ :");
            }
        }
    }
    private void showAll(){
        System.out.println("Danh sách nhân viên :");

        for (Employee employee:
                list.findAll()  ) {
            System.out.println(employee);
        }
    }
    private void showMenuAdd() {
        System.out.println("Đang thêm thông nhân viên ");
        System.out.println("Nhập Id : ");
        int id = ValidatorEmployee.getInputInt();
        System.out.println("Nhập tên nhân viên :");
        String name = ValidatorEmployee.getInputString();
        System.out.println("Nhập tuổi nhân viên :");
        int age = ValidatorEmployee.getInputInt();
        System.out.println("Nhập giới tính nhân viên:");
        String gender = ValidatorEmployee.getInputString();
        System.out.println("Nhập lương nhân viên:");
        double salary = ValidatorEmployee.getInputDouble();
        System.out.println("Nhập trạng thái nhân viên:");
        int status = ValidatorEmployee.getInputStatus();
        Employee employee = new Employee(id, name, age, gender, salary, status);
        list.add(employee);
        System.out.println("Thêm nhân viên thành công!!! \n");
    }

    private void showMenuSearchByName() {
        System.out.println("\nTìm kiếm theo tên gần đúng...");
        System.out.print("Nhập tên gần đúng: ");
        String name = ValidatorEmployee.getInputString();
        for (Employee employee: list.findAll() ) {
            if(employee.getName().toLowerCase().contains(name.toLowerCase())){
                System.out.println(employee);
            }
        }
    }

    private void showMenuCheckStatus() {
    }

    private void showMenuEdit() {
        System.out.println("Đang sửa thông tin nhân viên....");
        System.out.println("Nhập Id nhân viên cần sửa:");
        int id = ValidatorEmployee.getInputInt();
        int index = list.findById(id);
        if (index == -1) {
            System.out.println("Khong có Id nhân viên này: \n");
            return;
        }
        System.out.println("Nhập tên nhân viên :");
        String name = ValidatorEmployee.getInputString();
        System.out.println("Nhập tuổi nhân viên :");
        int age = ValidatorEmployee.getInputInt();
        System.out.println("Nhập giới tính nhân viên:");
        String gender = ValidatorEmployee.getInputString();
        System.out.println("Nhập lương nhân viên:");
        double salary = ValidatorEmployee.getInputDouble();
        System.out.println("Nhập trạng thái nhân viên:");
        int status = ValidatorEmployee.getInputStatus();
        Employee employee = new Employee(id, name, age, gender, salary, status);
        list.edit(id, employee);
        System.out.println("Sửa nhân viên thành công!!! \n");
    }

    private void showMenuDelete() {
        System.out.println("Đang xóa nhân viên ...");
        System.out.println("Nhập Id nhân viên cần xóa :");
        int id = ValidatorEmployee.getInputInt();
        int index = list.findById(id);
        if (index == -1) {
            System.out.println("không có nhân viên này ???\n");
            return;
        }
        list.delete(id);
        System.out.println("Xóa thành công hehehe!!!\n");
    }
    private void showMenuStatus(){
        System.out.println("---Danh sách trạng thái nhân viên---\n");
        System.out.println("Nhập trạng thái nhân viên: ");
        int status = ValidatorEmployee.getInputStatus();
        for (Employee employee:
                list.findAll() ) {
            if(employee.isStatus() == status){
                System.out.println(employee);
            }
        }
    }
    private void showAccountInformation(){
        System.out.println("\n-----Xem thông tin tài khoản------");
        int index = accountManager.findIndex(currentUsername);
        Account account = accountManager.findAll().get(index);
        System.out.println("Họ tên: " + account.getFullName() + ", username: " + account.getUsername() + ", tuổi: " + account.getAge() + ", số điện thoại: " + account.getPhoneNumber());
        System.out.println("---------------------------------\n");
    }
}
