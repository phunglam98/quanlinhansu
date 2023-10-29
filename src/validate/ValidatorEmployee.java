package validate;
import java.util.Scanner;

public class ValidatorEmployee {
    private static Scanner input = new Scanner(System.in);

    public static int getInputInt() {
        String regexNum = "^\\d+$";
        while (true) {
            String inputNum = input.nextLine();
            if (inputNum.matches(regexNum)) {
                return Integer.parseInt(inputNum);
            } else {
                System.out.print("Hãy nhập định dạng số.\nNhập lại: ");
            }
        }
    }

    public static double getInputDouble() {
        String regexNum = "^\\d+$";
        while (true) {
            String inputNum = input.nextLine();
            if (inputNum.matches(regexNum)) {
                return Double.parseDouble(inputNum);
            } else {
                System.out.print("Hãy nhập định dạng số.\nNhập lại: ");
            }
        }
    }

    public static String getInputString() {
        return input.nextLine();
    }

    public static String getInputUser_Pass() {
        String regexStr = "^[a-zA-Z0-9]{8,16}$";
        while (true) {
            String inputStr = input.nextLine();
            if (inputStr.matches(regexStr)) {
                return inputStr;
            } else {
                System.out.print("Hãy nhập chuỗi có độ dài từ 8-16 ký tự chứa chữ thường hoặc chữ hoa hoặc số.\nNhập lại: ");
            }
        }
    }

    public static String getInputPhone() {
        String regexNum = "^0\\d{9}$";
        while (true) {
            String inputPhone = input.nextLine();
            if (inputPhone.matches(regexNum)) {
                return inputPhone;
            } else {
                System.out.print("Sai định dạng!!!.\nNhập lại: ");
            }
        }
    }

    public static String getInputEmail() {
        String regexNum = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$";
        while (true) {
            String inputEmail = input.nextLine();
            if (inputEmail.matches(regexNum)) {
                return inputEmail;
            } else {
                System.out.print("Sai định dạng!!!.\nNhập lại: ");
            }
        }
    }

    public static int getInputStatus() {
        String regexStatus = "^(0|1)$";
        while (true) {
            String inputStatus = input.nextLine();
            if (inputStatus.matches(regexStatus)) {
                return Integer.parseInt(inputStatus);
            } else {
                System.out.print("0: Đang đi làm\n1: Đã nghỉ việc.\nNhập lại: ");
            }
        }
    }
}



