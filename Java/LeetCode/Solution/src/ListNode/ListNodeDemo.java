package ListNode;

/**
 * 测试ListNode
 */
public class ListNodeDemo {
    public static void main(String[] args) {
        ListNode nodeSta = new ListNode(0);    //创建首节点
        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点
        nextNode = nodeSta;                      //指向首节点, 此时nextNode和nodeSta都指向new ListNode, 完全相同,
        // 此时若操作nextNode, nodeSta也会有同样的改变
        //创建链表
        for (int i = 1; i < 10; i++) {
            ListNode node = new ListNode(i);  //生成新的节点
            nextNode.next = node;               //把心节点连起来
            nextNode = nextNode.next;           //当前节点往后移动
        } //当for循环完成之后 nextNode指向最后一个节点，

        nextNode = nodeSta;                     //重新赋值让它指向首节点
        print(nextNode);                      //打印输出
        //也可以不给nextNode重新赋值, 直接打印nodeSta
    }

    //打印输出方法
    static void print(ListNode listNoed) {
        //创建链表节点
        while (listNoed != null) {
            System.out.println("节点:" + listNoed.val);
            listNoed = listNoed.next;
        }
        System.out.println();
    }
}
