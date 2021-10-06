package proxy;

/**
 * 代理: 真实类
 */
public class Lenovo implements SellComputer{
    @Override
    public String sell(double money) {
        System.out.println("花了" + money + "元买了一台电脑");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑");
    }
}
