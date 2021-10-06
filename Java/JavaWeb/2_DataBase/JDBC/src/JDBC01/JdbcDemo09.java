package JDBC01;

import util.JdbcUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * • 练习：
 *      • 需求：
 *          ⅰ. 通过键盘录入用户名和密码
 *          ⅱ. 判断用户是否登录成功
 */
public class JdbcDemo09 {

    public static void main(String[] args) {
        //1. 键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        //2, 调用方法
        boolean flag = new JdbcDemo09().login2(username, password);
        //3. 判断结果
        if(flag) {
            System.out.println("登陆成功");
        } else {
            System.out.println("用户名或密码错误");
        }

    }



    /**
     * 登陆方法, 使用Statement实现
     */
    public boolean login(String username, String password) {
        if(username == null || password == null) {
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //连接数据库判断是否登陆成功
            //1. 获取连接
            conn = JdbcUtils.getConnection();
            //2. 定义sql
            String sql = "select * from user where username = '"+username+ "' and password = '"+password+"'";
            //3. 获取执行sql的对象
            stmt = conn.createStatement();
            //4. 执行查询
            rs = stmt.executeQuery(sql);
            //5. 判断
            /*if(rs.next()) {
                return true;
            } else {
                return false;
            }*/
            return rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(rs, stmt, conn);
        }

        return false;
    }


    /**
     * 登陆方法, 使用PreparedStatement实现
     */
    public boolean login2(String username, String password) {
        if(username == null || password == null) {
            return false;
        }
        Connection conn = null;
//        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try {
            //连接数据库判断是否登陆成功
            //1. 获取连接
            conn = JdbcUtils.getConnection();
            //2. 定义sql
            String sql = "select * from user where username = ? and password = ?";
            //3. 获取执行sql的对象, 需要传参
            pstmt = conn.prepareStatement(sql);
            //给?赋值
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            //4. 执行查询, 不需要传参
            rs = pstmt.executeQuery();
            //5. 判断
            /*if(rs.next()) {
                return true;
            } else {
                return false;
            }*/
            return rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }

        return false;
    }
}
