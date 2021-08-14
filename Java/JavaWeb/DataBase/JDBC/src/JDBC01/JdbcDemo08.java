package JDBC01;

import domain.Emp;
import util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用JDBC工具类
 */
public class JdbcDemo08 {
    public static void main(String[] args) throws SQLException {
        List<Emp> list = new JdbcDemo08().findall();
        System.out.println(list);
        System.out.println(list.size());
    }


    /**
     * 查询所有Emp对象
     */
    public List<Emp> findall() {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        List<Emp> list = null;
        //1. 注册驱动; 2. 获取连接对象
        try {
            conn = JdbcUtils.getConnection();

        //3.
        String sql = "select * from emp";
        //4.
        stmt = conn.createStatement();
        //5.
        rs = stmt.executeQuery(sql);
        //6.
        Emp emp = null;
        list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String ename = rs.getString("ename");
            int job_id = rs.getInt("job_id");
            int mgr = rs.getInt("mgr");
            Date joindate = rs.getDate("joindate");
            double salary = rs.getDouble("salary");
            double bonus = rs.getDouble("bonus");
            int dept_id = rs.getInt("dept_id");

            //创建emp对象
            emp = new Emp();
            emp.setId(id);
            emp.setEname(ename);
            emp.setJob_id(job_id);
            emp.setMgr(mgr);
            emp.setJoindate(joindate);
            emp.setSalary(salary);
            emp.setBonus(bonus);
            emp.setDept_id(dept_id);
            list.add(emp);
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JdbcUtils.close(rs, stmt, conn);
        return list;
    }
}