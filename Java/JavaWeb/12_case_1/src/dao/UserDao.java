package dao;

import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的dao
 */
public interface UserDao {
    /**
     * 查询数据表中的所有数据并返回
     * @return
     */
    public List<User> findAll();

    /**
     * 根据用户输入的用户名和密码查询对应的用户信息, 并返回
     * @param username
     * @param password
     * @return
     */
    public User findUserByUsernameAndPassword(String username, String password);

    /**
     * 添加用户
     * @param user
     */
    public void add(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    public void delete(int id);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User findById(int id);

    /**
     * 修改用户信息
     * @param user
     */
    public void update(User user);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每一页的记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
