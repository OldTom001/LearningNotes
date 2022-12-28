package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImp implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public boolean regist(User user) {
        //1. 根据用户名查询用户对
        User u = userDao.findByUsername(user.getUsername());
        //用户名已存在, 注册失败
        if(u!=null){
            return false;
        }
        //2. 保存用户信息
        //设置激活码, 唯一字符串
        user.setCode(UuidUtil.getUuid());
        //设置邮件状态
        user.setStatus("N");
        userDao.save(user);
        //3. 发送激活邮件
        //String content = "<a href='http://localhost/travel/user/active?code="+user.getCode()+"'>点击激活[黑马旅游网]</a>";
        //使用相对路径
        String content = "<active?code="+user.getCode()+"'>点击激活[黑马旅游网]</a>";
        MailUtils.sendMail(user.getEmail(), content, "激活邮件");
        return true;
    }

    @Override
    public boolean active(String code) {
        //1. 根据激活码查询用户对象
        User user = userDao.findByCode(code);
        if(user!=null) {
            //2. 调用dao, 修改激活状态
            userDao.updateStatus(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
