package DataSource.JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

/**
 * JdbcTemplate入门
 */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        //1. 导入jar包
        //2. 创建JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3. 调用方法
        String sql = "update account set balance = 5000 where id = ?";
        int count = template.update(sql, 3); //给第1个?赋值3
        System.out.println(count);
    }
}
