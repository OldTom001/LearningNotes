package Thread01;

public class MyThread extends Thread{

//    提供无参构造方法
    public MyThread() {
    }
    public MyThread(String name) {
        super(name);  //访问父类（Thread类）的带参构造方法
    }

    @Override
    public void run() {
        for(int i = 0; i< 100; i++) {
            System.out.println(getName()+ ": " + i);
        }
    }
}
