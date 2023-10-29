package model;

public class Account {
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String email;
    private int age;

    public Account(String username, String password, String fullName, String phoneNumber, String address, String email, int age) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Tài khoản = " + username +
                ", Mật khẩu = " + password +
                ", Họ tên = " + fullName +
                ", Số điện thoại = " + phoneNumber +
                ", Địa chỉ = " + address +
                ", Email = " + email +
                ", Tuổi = " + age;
    }
}

