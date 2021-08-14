package DataSource.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo02 {
    public static void main(String[] args) throws SQLException {
        //1. 获取DataSource, 使用默认配置
        DataSource ds = new ComboPooledDataSource();
        for(int i = 1; i<=11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":" + conn);
        }
//        testNamedConfig();

    }

    /**
     * 获取DataSource时使用命名的配置
     * @throws SQLException
     */
    public static void testNamedConfig() throws SQLException {
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        for(int i =1; i<=10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
        }
    }
}
