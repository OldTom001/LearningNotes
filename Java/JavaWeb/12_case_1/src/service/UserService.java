package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return 将所有用户信息封装成List
     */
     public List<User> findAll();

    /**
     * 登陆, 返回用户名和密码对应的用户
     * @param user
     * @return
     */
     public User login(User user);

    /**
     * 保存user
     * @param user
     */
     public void addUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    public void deleteUser(String id);

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    public User findUserById(String id);

    /**
     * 修改用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 批量删除用户
     * 根据id列表删除所有选中的用户
     * @param ids
     */
    void deleteSelectedUser(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
