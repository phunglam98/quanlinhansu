package Dao;

import model.Account;
import model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadAndWriteIOFile {
    private File file = new File("Employee.csv");
    private File file2 = new File("Account.csv");
    public void writeFile(ArrayList<Employee> employees){
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Employee employee:
                    employees ) {
                line += employee.getData()+ "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<Employee> readFile(){
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                Employee employee = new Employee(Integer.parseInt(data[0]), data[1],Integer.parseInt(data[2]),data[3],Double.parseDouble(data[4]),Integer.parseInt(data[5]));
                employees.add(employee);
            }
            bufferedReader.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return employees;
    }
    public void writeFileAccount(ArrayList<Account> list) {
        try {
            FileWriter fileReader = new FileWriter(file2);
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader);
            String line = "";
            for (Account account : list) {
                line += account.getUsername() + "," + account.getPassword() + "," + account.getFullName() + "," + account.getPhoneNumber()
                        + "," + account.getAddress() + "," + account.getEmail() + "," + account.getAge() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Account> readFileAccount() {
        ArrayList<Account> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Account account = new Account(data[0], data[1], data[2], data[3], data[4], data[5], Integer.parseInt(data[6]));
                list.add(account);
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
