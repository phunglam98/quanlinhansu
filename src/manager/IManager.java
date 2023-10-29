package manager;

import java.util.List;

public interface IManager<T> {
    void add(T e);
    boolean delete(int id);
    int findById(int id);
    boolean edit(int id,T e);
    List<T> findAll();

}