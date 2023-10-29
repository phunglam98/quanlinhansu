package model;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private double salary;
    private int status;
    private static int idIncrease = 1;


    public Employee(){
    }
    public Employee( String name, int age, String gender, double salary, int status) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.status = status;
        idIncrease++;
    }

    public Employee(int id, String name, int age, String gender, double salary, int status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Mã nhân viên=" + id +
                ", TênNv='" + name + '\'' +
                ", Tuổi=" + age +
                ", Giới tính='" + gender + '\'' +
                ", Lương=" + salary +
                ", Trạng thái=" + ((status%2==0)?"Đang đi làm":"Đã nghỉ việc") +
                '}';
    }
    public String getData(){
        return id + "," + name +"," + this.age +"," + this.gender + "," + this.salary +"," +this.status;
    }
}
