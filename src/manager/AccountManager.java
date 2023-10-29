package manager;

import Dao.ReadAndWriteIOFile;
import model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountManager implements IManager<Account> {
    private ArrayList<Account> list;
    private ReadAndWriteIOFile readAndWriteIOFile;
    public AccountManager() {
        readAndWriteIOFile = new ReadAndWriteIOFile();
        list = readAndWriteIOFile.readFileAccount();
    }
    public int findIndex(String username) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public void add(Account account) {
        this.list.add(account);
        readAndWriteIOFile.writeFileAccount(list);

    }

    @Override
    public boolean delete(int index) {
        this.list.remove(index);
        readAndWriteIOFile.writeFileAccount(list);
        return true;
    }

    @Override
    public int findById(int id) {
        return 0;
    }

    @Override
    public boolean edit(int index, Account account) {
        this.list.set(index, account);
        readAndWriteIOFile.writeFileAccount(list);
        return true;
    }

    @Override
    public List<Account> findAll() {
        return list;
    }
    public boolean hasAlready(String username, String password) {
        boolean check = false;
        for (Account account : list) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                check = true;
                break;
            }
        }
        if (check) {
            return true;
        } else {
            return false;
        }
    }
}
