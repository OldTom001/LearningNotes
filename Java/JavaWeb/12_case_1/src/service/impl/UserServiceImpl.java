package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return dao.findAll();

    }

    @Override
    public User login(User user) {

        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id_str) {
        int id = Integer.parseInt(id_str);
        dao.delete(id);
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void deleteSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
//            this.deleteUser(id);
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //1. 创建PageBean对象
        PageBean<User> pb = new PageBean<User>();
        //2. 设置每页显示的记录数
        pb.setRows(rows);
        //3. 调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4. 计算总页数
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);
        //4. 设置当前页面编号
        if(currentPage<=0) {
            currentPage=1;
        }
        if(currentPage>totalPage){
            currentPage = totalPage;
        }
        pb.setCurrentPage(currentPage);

        //5. 调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows, condition);
        pb.setList(list);

        return pb;
    }


}
