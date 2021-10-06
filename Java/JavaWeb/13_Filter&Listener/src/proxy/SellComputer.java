package proxy;

/**
 * 代理: 接口
 */
public interface SellComputer {
    /**
     * 卖电脑
     * @param money
     * @return
     */
    public String sell(double money);

    /**
     * 展示电脑
     */
    public void show();

}
