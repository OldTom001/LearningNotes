package web.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import web.domain.Person;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 * 校验用户名是否存在
 */
public class JacksonTest {

    /**
     * java对象转json
     * @throws Exception
     */
    @Test
    public void test_1() throws Exception {
        //1. 导入jackson的jar包

        Person p = new Person();
        p.setName("孙悟空");
        p.setAge(500);
        p.setGender("male");
        //2. 创建jackson核心对象ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3. 调用ObjectMapper相关方法
        //将java对象转成json字符串
        String json = mapper.writeValueAsString(p);
        System.out.println(json); //{"name":"孙悟空","age":500,"gender":"male"}
        //将数据写到e://a.txt
        mapper.writeValue(new File("e://a.txt"), p);
        //将数据关联到writer
        mapper.writeValue(new FileWriter("e://b.txt"), p);
    }

    /**
     * 测试JsonIgnore和JsonFromart两个注解
     * @throws Exception
     */
    @Test
    public void test_2() throws Exception {
        //1. 导入jackson的jar包

        Person p = new Person();
        p.setName("孙悟空");
        p.setAge(500);
        p.setGender("male");
        p.setBirthday(new Date());
        //2. 创建jackson核心对象ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3. 调用ObjectMapper相关方法
        //将java对象转成json字符串
        String json = mapper.writeValueAsString(p);
        System.out.println(json); //{"name":"孙悟空","age":500,"gender":"male","birthday":"2021-10-07"}
    }

    /**
     * 测试List对象转json
     * @throws Exception
     */
    @Test
    public void test_3() throws Exception {
        //1. 导入jackson的jar包

        Person p = new Person();
        p.setName("孙悟空");
        p.setAge(500);
        p.setGender("male");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("孙悟空");
        p1.setAge(500);
        p1.setGender("male");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("孙悟空");
        p2.setAge(500);
        p2.setGender("male");
        p2.setBirthday(new Date());

        List<Person> list = new ArrayList<>();
        list.add(p);
        list.add(p1);
        list.add(p2);

        //2. 创建jackson核心对象ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3. 调用ObjectMapper相关方法
        //将java对象转成json字符串
        String json = mapper.writeValueAsString(list);
        System.out.println(json); //[{"name":"孙悟空","age":500,"gender":"male","birthday":"2021-10-07"},{"name":"孙悟空","age":500,"gender":"male","birthday":"2021-10-07"},{"name":"孙悟空","age":500,"gender":"male","birthday":"2021-10-07"}]
    }

    /**
     * 测试Map对象转json
     * @throws Exception
     */
    @Test
    public void test_4() throws Exception {
        //1. 导入jackson的jar包

        Map<String, Object> map = new HashMap<>();
        map.put("name", "yangguo");
        map.put("age", "40");
        map.put("gender", "male");

        //2. 创建jackson核心对象ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3. 调用ObjectMapper相关方法
        //将java对象转成json字符串
        String json = mapper.writeValueAsString(map);
        System.out.println(json); //{"gender":"male","name":"yangguo","age":"40"}
    }

    /**
     * 测试json字符串对象转java对象
     * @throws Exception
     */
    @Test
    public void test_5() throws Exception {
        //1. 导入jackson的jar包

       String json = "{\"gender\":\"male\",\"name\":\"yangguo\",\"age\":\"40\"}";
        //2. 创建jackson核心对象ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3. 调用ObjectMapper相关方法
        //将java对象转成json字符串
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person); //Person{name='yangguo', age=40, gender='male', birthday=null}
    }
}
