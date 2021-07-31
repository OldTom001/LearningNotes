package Test;

import Junit01.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class CalculatorTest {

    /*初始化方法
    * 用于资源申请, 所有测试方法在执行之前都会先执行该方法
    * */
    @Before
    public  void init() {
        System.out.println("init...");
    }

    /*释放资源方法
    * 所有测试方法执行完后都会自动执行该方法
    * */
    @After
    public void close(){
        System.out.println("close...");
    }

    @Test
    public void testAdd(){
//        System.out.println("我被执行了");
        Calculator c = new Calculator();

        int result = c.add(1, 2);

//        断言, 若result不等于期望值, 则判定失败, 显示橙色
        Assert.assertEquals(3, result);
    }

    @Test
    public void testSub(){
        Calculator c = new Calculator();
        int result = c.sub(1, 2);
        Assert.assertEquals(-1, result);
        System.out.println("testSub...");
    }
}
