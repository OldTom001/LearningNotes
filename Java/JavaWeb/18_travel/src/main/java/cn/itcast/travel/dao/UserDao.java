package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 保存用户
     * @param user
     */
    public void save(User user);

    /**
     *
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     * 激活, 将user.status设置为Y
     * @param user
     */
    void updateStatus(User user);

    /**
     * 根据用户名和密码查询用户
     * @param username, password
     * @return
     */
    User findByUsernameAndPassword(String username, String password);
}
