package manager;

import Dao.ReadAndWriteIOFile;
import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager implements IManager<Employee> {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private ReadAndWriteIOFile readAndWriteIOFile = new ReadAndWriteIOFile();
    public EmployeeManager(){
        employeeList = readAndWriteIOFile.readFile();
    }
    public int findIndex(int id ){
        for (int i = 0; i <employeeList.size() ; i++) {
            if((employeeList.get(i).getId() == id)) {
                return i;
            }
        }
        return -1;
    }
    public int findIndex(String name ){
        for (int i = 0; i <employeeList.size() ; i++) {
            if((employeeList.get(i).getName() == name)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
        readAndWriteIOFile.writeFile(employeeList);
    }

    @Override
    public boolean delete(int id) {
        int index = findById(id);
        if(index == -1){
            return false;
        }
        this.employeeList.remove(index);
        return false;
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if(id == employeeList.get(i).getId()) return i;

        }
        return -1;
    }

    @Override
    public boolean edit(int id, Employee e) {
        int index = findById(id);
        if(index == -1){
            return false;
        }
        this.employeeList.set(index,e);
        readAndWriteIOFile.writeFile(employeeList);
        return false;
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }
}
