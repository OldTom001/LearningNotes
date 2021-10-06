package DataSource.Druid;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用Druid工具类
 */
public class DruidDemo02 {
    public static void main(String[] args) {
        /*
        完成添加操作, 给account表添加一条记录
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1. 获取连接
            conn = JDBCUtils.getConnection();
            //2. 定义sql
            String sql = "insert into account values(null, ?, ?)";
            //3. 获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4. 给?赋值
            pstmt.setString(1,"王五");
            pstmt.setDouble(2,3000);
            //5. 执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }
}
