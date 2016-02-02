package testing.db;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    void create(int id, String name);
}
